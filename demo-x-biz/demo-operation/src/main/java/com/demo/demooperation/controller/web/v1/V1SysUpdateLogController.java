package com.demo.demooperation.controller.web.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.democommoncore.constant.ReturnCode;
import com.demo.democommoncore.exception.BizException;
import com.demo.democommoncore.vo.Result;
import com.demo.demooperation.entity.DemoOperationFissionArticle;
import com.demo.demooperation.entity.DemoOperationSysUpdateLog;
import com.demo.demooperation.service.DemoOperationSysUpdateLogService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;


/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/18.
 */
@RestController
@RequestMapping("v1/sys/log")
@Api(tags = "更新日志", value = "更新日志")
@Slf4j
@Validated
public class V1SysUpdateLogController {

    @Resource
    private DemoOperationSysUpdateLogService demoOperationSysUpdateLogService;

    /**
     * 分页查询
     *
     * @param current
     * @param size
     * @return 分页查询 --> searchText ---->  title、href
     *
     */
    @GetMapping("")
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "分页查询日志", response = DemoOperationSysUpdateLog.class)
    public Result list1(@RequestParam(defaultValue = "1") Long current,
                        @Range(min = 1, max = 100, message = "分页参数有误") @RequestParam(required = false, defaultValue = "10") Long size
    ) {
        Page<DemoOperationSysUpdateLog> page = demoOperationSysUpdateLogService
                .page(new Page<>(current, size), Wrappers.<DemoOperationSysUpdateLog>lambdaQuery()
                        //带条件的sql拼接喷液查询
                        .select(DemoOperationSysUpdateLog::getId,DemoOperationSysUpdateLog::getIcon,DemoOperationSysUpdateLog::getTitle,DemoOperationSysUpdateLog::getCreateTime,DemoOperationSysUpdateLog::getSort)
                        .orderByAsc(DemoOperationSysUpdateLog::getSort)
                        );
        return Result.success().addData("list", page);
    }


    /**
     * 根据ID插入数据
     * @param id
     * @return
     */
    public Result save(@Valid @NotNull  @RequestParam Integer  id){//不为空，必须传值
        //传值校验
        id = Optional.ofNullable(id).orElseThrow(()->new BizException( ReturnCode.ERROR_ID_NOT_FOUNT) );
        DemoOperationSysUpdateLog demo = new DemoOperationSysUpdateLog();
        demo.setId(id);
        demoOperationSysUpdateLogService.save(demo);
        return Result.success();
        }
    /**
     * 删除日志
     *
     * @param id id
     * @return 删除结果
     */
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "删除日志")
    @DeleteMapping("{id}")
    public Result delete(@Valid @NotNull @PathVariable Integer id) {
        //传值校验
        id = Optional.ofNullable(id).orElseThrow(()->new BizException( ReturnCode.ERROR_ID_NOT_FOUNT) );
        demoOperationSysUpdateLogService.removeById(id);
        return Result.success();
    }

    /**
     * 根据ID跟新日志
     * @param demoOperationSysUpdateLog
     * @return 更新结果
     */
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "更新日志")
    @PutMapping("")
    public Result updateById(@RequestBody DemoOperationSysUpdateLog demoOperationSysUpdateLog) {
        demoOperationSysUpdateLogService.updateById(demoOperationSysUpdateLog);
        return Result.success();
    }
}

