package com.demo.demooperation.controller.web.v1;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.democommoncore.constant.ReturnCode;
import com.demo.democommoncore.exception.BizException;
import com.demo.democommoncore.valid.UpdateValid;
import com.demo.democommoncore.vo.Result;
import com.demo.demooperation.constant.ResultConst;
import com.demo.demooperation.entity.DemoOperationFissionArticle;
import com.demo.demooperation.entity.DemoOperationSysUpdateLog;
import com.demo.demooperation.service.DemoOperationFissionArticleService;
import com.demo.demooperation.service.DemoOperationSysUpdateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("v1/sys/article")
@Api(tags = "干货文章", value = "干货文章")
@Slf4j
@Validated
public class V1DemoOperationFissionArticleController {

    @Resource
    private DemoOperationFissionArticleService demoOperationFissionArticleService;



    /**
     * 查询单个
     *
     * @return
     */
    @GetMapping("{id}")
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "分页查询干货", response = DemoOperationSysUpdateLog.class)
    public Result obj(@NotNull @PathVariable Long id) {
        return Result.success().addData("obj", demoOperationFissionArticleService.getById(id));
    }

    /**
     * 插入数据
     *
     * @return
     */
    @PostMapping("")
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "保存干货")
    public Result save(@RequestBody DemoOperationFissionArticle demoOperationFissionArticle) {
        demoOperationFissionArticleService.save(demoOperationFissionArticle);
        return Result.success();
    }

    /**
     * 删除指定干货内容
     *
     * @param id id
     * @return 删除结果
     */
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "删除干货文章")
    @DeleteMapping("{id}")
    public Result delete(@Valid @NotNull(message = "") @PathVariable Integer id) {//不为空，必须传值
        //传值校验
        id = Optional.ofNullable(id).orElseThrow(() -> new BizException(ReturnCode.ERROR_ID_NOT_FOUNT));
        demoOperationFissionArticleService.removeById(id);
        return Result.success();
    }

    /**
     * 根据ID更改
     *
     * @param demoOperationFissionArticle
     * @return 更新结果
     */
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "更新干货")
    @PutMapping("")
    public Result updateById(@Validated(UpdateValid.class) @RequestBody DemoOperationFissionArticle demoOperationFissionArticle) {
        demoOperationFissionArticleService.updateById(demoOperationFissionArticle);
        return Result.success();
    }
}



