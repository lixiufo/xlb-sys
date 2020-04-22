package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/28.
 */

@Data
@TableName(value = "demo_operation_seller_qr_code_config")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoOperationSellerQrCodeConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 是否显示
     */
    @TableField(value = "hidden")
    private Integer hidden;

    /**
     * 文件路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 账号id
     */
    @TableField(value = "sys_user_id")
    private Integer sysUserId;

    /**
     * 账号用户名
     */
    @TableField(value = "sys_user_name")
    private String sysUserName;

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

    @TableLogic
    private Integer dr;

    /**
     * 头像
     */
    @TableField(value = "img_path")
    private String imgPath;

    /**
     * 业务手机号码
     */
    @TableField(value = "phone")
    private String phone;

}