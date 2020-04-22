package com.demo.democommoncore.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/7/2.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushVO extends BaseVO {

    public static final Integer TYPE_SINGLE = 0;

    public static final Integer TYPE_ALL = 1;

    public static final Integer TYPE_CONFIG = 2;

    public static final Integer TYPE_EVENT = 3;

    private String id;

    private String appId;

    private String createBy;

    /**
     * 0 - 单个粉丝
     * 1 - 所有粉丝
     * 2 - 高级功能
     */
    private Integer type;

    private String openId;

    /**
     * 多个openIdList
     */
    private List<String> openIdList;

    private Boolean tagStatus = Boolean.FALSE;

    private Boolean areaStatus = Boolean.FALSE;

    private Boolean sexStatus = Boolean.FALSE;

    private Boolean timeStatus = Boolean.FALSE;

    private String tagId;

    private String areaName;

    private String city;

    private Integer sexId;

    private Long timeStart;

    private Long timeEnd;

    /**
     * 定时发送时间
     */
    private Long scheduleDate;

    /**
     * 唯一性的uuid
     */
    private String uuid;

    /**
     * 参与的活动
     */
    private String eventId;
}
