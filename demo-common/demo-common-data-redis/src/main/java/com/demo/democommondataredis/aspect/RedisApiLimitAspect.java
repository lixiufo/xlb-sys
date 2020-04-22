package com.demo.democommondataredis.aspect;

import com.demo.democommoncore.constant.ReturnCode;
import com.demo.democommoncore.vo.Result;
import com.demo.democommondataredis.annotation.RedisApiLimit;
import com.demo.democommondataredis.enums.LimitType;
import com.demo.democommondataredis.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 */
@Aspect
@Component
@Slf4j
@Order(0)
public class RedisApiLimitAspect {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Around("@annotation(redisApiLimit)")
    public Object around(ProceedingJoinPoint point, RedisApiLimit redisApiLimit) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LimitType limitType = redisApiLimit.limitType();
        String key;
        int limitPeriod = redisApiLimit.period();
        int limitCount = redisApiLimit.count();
        switch (limitType) {
            case IP:
                key = IpUtils.getIpAddr(request);
                break;
            case KEY:
                key = redisApiLimit.key();
                break;
            default:
                key = method.getName().toUpperCase();
        }
        String luaScript = buildLuaScript(limitCount, limitPeriod);
        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
        List<String> keys = Collections.singletonList(redisApiLimit.prefix() + "_" + key + "_" + signature.getDeclaringType().getSimpleName().toLowerCase() + "_" + method.getName());
        Number count = redisTemplate.execute(redisScript, keys);
        if (count != null && count.intValue() <= limitCount) {
            return point.proceed();
        } else {
            return Result.error(ReturnCode.ERROR_API_LIMIT);
        }
    }

    /**
     * @param limitCount  访问数
     * @param limitPeriod 时限
     * @author fu
     * @description 编写 redis Lua 限流脚本
     * @date 2020/4/8 13:24
     */
    @SuppressWarnings("all")
    private String buildLuaScript(Integer limitCount, Integer limitPeriod) {
        StringBuilder lua = new StringBuilder();
        lua.append("local c");
        lua.append("\nc = redis.call('get',KEYS[1])");
        // 调用不超过最大值，则直接返回
        lua.append("\nif c and tonumber(c) > tonumber(");
        lua.append(limitCount);
        lua.append(") then");
        lua.append("\nreturn c;");
        lua.append("\nend");
        // 执行计算器自加
        lua.append("\nc = redis.call('incr',KEYS[1])");
        lua.append("\nif tonumber(c) == 1 then");
        // 从第一次调用开始限流，设置对应键值的过期
        lua.append("\nredis.call('expire',KEYS[1],");
        lua.append(limitPeriod);
        lua.append(")");
        lua.append("\nend");
        lua.append("\nreturn c;");
        return lua.toString();
    }

}
