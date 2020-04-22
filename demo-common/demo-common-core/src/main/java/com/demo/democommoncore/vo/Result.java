package com.demo.democommoncore.vo;

import com.demo.democommoncore.constant.ReturnCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WPF
 * @version distribution
 * @date 2019-04-02.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class Result extends BaseVO {

    private static final long serialVersionUID = -1L;

    /**
     * 成功标识1
     */
    private boolean success;

    /**
     * 错误编码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>(1);

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("操作成功");
        result.setCode(200);
        return result;


    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        result.setCode(200);
        return result;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success(Map<String, Object> data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 错误日志
     *
     * @param msg
     *
     * @return
     */
    public static Result error(String msg, Object... objs) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(500);
        result.setMsg(String.format(msg, objs));
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static Result error(HttpServletRequest request, Exception exception) {
        Result result = error(ReturnCode.ERROR_DEFAULT);
        result.setMsg(exception.getMessage());
        return result;
    }

    public static Result error(ReturnCode returnCode) {
        Result result = new Result();
        result.setCode(returnCode.getCode());
        result.setMsg(returnCode.getMsg());
        result.setSuccess(false);
        return result;
    }

    public static Result success(ReturnCode returnCode) {
        Result result = new Result();
        result.setCode(returnCode.getCode());
        result.setMsg(returnCode.getMsg());
        result.setSuccess(true);
        return result;
    }

    /**
     * 添加返回数据
     *
     * @param key
     * @param value
     *
     * @return
     */
    public Result addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 错误码
     *
     * @param code
     *
     * @return
     */
    public Result errorCode(Integer code) {
        this.code = code;
        return this;
    }

}
