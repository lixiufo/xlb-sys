package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class DemoOperationSysUpdateLog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * icon
     */
    @TableField(value = "icon")
    @ApiModelProperty(value="icon")
    private String icon;

    /**
     * 更新日志标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="更新日志标题")
    private String title;

    /**
     * 超链接
     */
    @TableField(value = "href")
    @ApiModelProperty(value="超链接")
    private String href;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    @TableField(value = "dr")
    @TableLogic
    private Integer dr;

    /**
     *  排序 
     */
    @TableField(value = "sort")
    @ApiModelProperty(value=" 排序 ")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}