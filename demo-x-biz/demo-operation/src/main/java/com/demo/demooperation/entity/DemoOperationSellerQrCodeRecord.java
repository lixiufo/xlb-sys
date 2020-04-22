package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * @date 2019/8/26.
 */

@Data
@TableName(value = "demo_operation_seller_qr_code_record")
public class DemoOperationSellerQrCodeRecord implements Serializable {

    public static final String COL_ID = "id";

    public static final String COL_CONFIG_ID = "config_id";

    public static final String COL_CREATE_TIME = "create_time";

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 二维码配置id
     */
    @TableField(value = "config_id")
    private String configId;

    /**
     * 来源
     */
    @TableField(value = "source")
    private String source;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}