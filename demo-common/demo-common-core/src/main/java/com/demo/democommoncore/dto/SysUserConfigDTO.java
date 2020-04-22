package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUserConfigDTO extends BaseDTO {

    /**
     * 创建人登录名称
     */
    private String createBy;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人登录名称
     */
    private String updateBy;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private Long sysUserId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 是否检测企业 1_检测，0_不检测
     */
    private Integer checkCompany = 1;

    /**
     * 是否检测公众号主体 1_检测 0_不检测
     */
    private Integer checkMaCompany = 1;

    /**
     * 最大授权公众号数量
     */
    private Integer appNum = 2;

    /**
     * 最大授权公众号数量
     */
    private Integer maNum = 1;

    /**
     * 最大公众号活动开启数量
     */
    private Integer maxWxEventNum = 10;

    /**
     * 最大分销活动开启数量
     */
    private Integer maxDistributionEventNum = 10;

    /**
     * 小程序最大开启数量
     */
    private Integer maxWxMaEventNum = 10;

    /**
     * 发送模板消息间隔
     */
    private Integer maxTemplateLimitTime = 60;

    /**
     * 发送小程序模板消息间隔
     */
    private Integer maxMaTemplateLimitTime = 60;

    /**
     * 发送客服消息间隔
     */
    private Integer maxMessageLimitTime = 60;

    /**
     * 同步用户数据间隔
     */
    private Integer maxSynchronizeLimitTime = 120;

}