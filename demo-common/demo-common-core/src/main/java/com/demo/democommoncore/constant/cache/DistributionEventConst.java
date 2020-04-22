package com.demo.democommoncore.constant.cache;

import lombok.Data;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/7/10.
 */
@Data
public class DistributionEventConst {

    /**
     * 邀请码参数
     */
    public static final String EVENT_FRONT_URL_SUFFIX = "&c=";

    /**
     * 活动链接的前缀
     */
    public static final String EVENT_FRONT_PREFIX = "<a href=\"";

    /**
     * 活动链接的后缀
     */
    public static final String EVENT_FRONT_SUFFIX = "\">活动入口，点击进入</a>";

    public static final String EVENT_INCOME_PREFIX = "<a href=\"";

    public static final String EVENT_INCOME_SUFFIX = "\">个人收益，点击查看</a>";

    public static final String EVENT_INVITE_LIST_PREFIX = "<a href=\"";

    public static final String EVENT_INVITE_LIST_SUBFIX = "\">邀请排行榜，点击查看</a>";

    /**
     * 活动入口
     */
    public static final String MSG_PLACEHOLDER_URL = "{{entrance}}";

    /**
     * 个人收益
     */
    public static final String MSG_PLACEHOLDER_INCOME = "{{income}}";

    /**
     * 邀请记录排行榜
     */
    public static final String MSG_PLACEHOLDER_INVITELIST = "{{invite}}";

    /**
     * 用户昵称
     */
    public static final String MSG_PLACEHOLDER_USERNAME = "{{nickname}}";

    /**
     * 好友昵称
     */
    public static final String MSG_PLACEHOLDER_P_USERNAME = "{{pnickname}}";

    /**
     * 奖金
     */
    public static final String MSG_PLACEHOLDER_AWARD = "{{award}}";

    /**
     * 总奖金
     */
    public static final String MSG_PLACEHOLDER_S_AWARD = "{{saward}}";

    /**
     * 通知时间
     */
    public static final String MSG_PLACEHOLDER_TIME = "{{time}}";

    /**
     * 分销总人数
     */
    public static final String MSG_PLACEHOLDER_NUM = "{{num}}";

    public static final String DISTRIBUTION_CACHE = "distributionEvent";

    /**
     * 活动表单缓存
     */
    public static final String DEMO_DISTRIBUTION_FORM_INFO_CACHE_PREFIX = "demoDistributionFormInfoCachePrefix:";

}
