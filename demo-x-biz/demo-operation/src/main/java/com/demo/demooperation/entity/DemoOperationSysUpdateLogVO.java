package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WPF 
 * @version xlb-sys
 * @date 2020/4/18.
 */

/**
    * 系统更新日志
    */
@ApiModel(value="com-demo-demooperation-entity-DemoOperationSysUpdateLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "demo_operation_sys_update_log")
public class DemoOperationSysUpdateLogVO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    private static final long serialVersionUID = 1L;
}