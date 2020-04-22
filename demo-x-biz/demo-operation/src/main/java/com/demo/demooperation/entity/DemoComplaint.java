package com.demo.demooperation.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "demo_complaint")
public class DemoComplaint implements Serializable {

    public static final String COL_APP_ID = "app_id";

    public static final String COL_EVENT_ID = "event_id";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_PATH = "path";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_DR = "dr";

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * appId
     */
    @TableField(value = "app_id")
    private String appId;

    /**
     * 活动id
     */
    @TableField(value = "event_id")
    private String eventId;

    /**
     * open_id
     */
    @TableField(value = "open_id")
    private String openId;

    @TableField(exist = false)
    private String headImgUrl;

    @TableField(exist = false)
    private String nickname;

    /**
     * 投诉图片路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 删除标识
     */
    @TableField(value = "dr")
    @TableLogic
    private Integer dr;
}