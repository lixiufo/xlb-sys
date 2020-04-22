package com.demo.democommoncore.constant;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/10.
 * 域名常量池
 */
public interface RandomHostConst {

    /**
     * 分销
     */
    interface Distribution {
        /**
         * 活动首页
         */
        String DISTRIBUTION_EVENT_MAIN_URL = "distributionEventMainUrl";

        /**
         * 排行榜
         */
        String DISTRIBUTION_EVENT_RANK_URL = "distributionEventRankUrl";

        /**
         * 个人中心
         */
        String DISTRIBUTION_EVENT_USER_URL = "distributionEventUserUrl";
    }

    /**
     * 店铺
     */
    interface Shop {
        /**
         * 店铺首页
         */
        String SHOP_MAIN_URL = "shopMainUrl";

        /**
         * 店铺分销详情页
         */
        String SHOP_DISTRIBUTION_URL = "shopDistributionUrl";

        /**
         * 店铺拼团详情页
         */
        String SHOP_ASSEMBLE_URL = "shopAssembleUrl";

        /**
         * 店铺拼团中间页
         */
        String SHOP_ASSEMBLE_MIDDLE_URL = "shopAssembleMiddleUrl";
    }

    /**
     * 活码
     */
    interface RandomCode {

        /**
         * 社群活码详情页
         */
        String RANDOM_CODE_GROUP_URL = "randomCodeGroupUrl";

        /**
         * 个人号活码详情页
         */
        String RANDOM_CODE_SINGLE_URL = "randomCodeSingleUrl";

    }

    /**
     * 公众号活动
     */
    interface WxSys {

        /**
         * 抽奖工具详情页
         */
        String WX_LOTTERY_URL = "wxLotteryUrl";

        /**
         * 抽奖工具的详情
         */
        String WX_DRAW_URL = "wxDrawUrl";

        /**
         * 排行榜
         */
        String WX_EVENT_RANK_URL = "wxEventRankUrl";

        /**
         * 投诉
         */
        String WX_EVENT_COMPLAIN_URL = "wxEventComplainUrl";

        /**
         * 二次扫码的中间页
         */
        String WX_EVENT_DOUBLE_URL = "wxEventDoubleUrl";

        /**
         * 节日签中间页
         */
        String WX_EVENT_FESTIVAL_URL = "wxEventFestivalUrl";

    }

}
