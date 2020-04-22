package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/12/17.
 */

@Data
@TableName(value = "sys_source_seller")
public class SysSourceSeller implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 业务的二维码配置
     */
    @TableField(value = "seller_config_id")
    private String sellerConfigId;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    @TableField(value = "dr")
    private Integer dr;
}