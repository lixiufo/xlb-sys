package com.demo.democommoncore.constant.consts;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/1.
 * 通用工具类
 */
public interface CommonConst {

    /**
     * 正则匹配符
     */
    interface Regexp {

        /**
         * 匹配 2020-02-21
         */
        String DATE_REGEXP_YYYY_MM_DD = "^\\d{4}-\\d{1,2}-\\d{1,2}";

        /**
         * 匹配 20200203
         */
        String DATE_REGEXP_YYYYMMDD = "^\\d{4}\\d{1,2}\\d{1,2}";

        /**
         * 格式化 2020-02-21
         */
        String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

        /**
         * 格式化 2020-02-21 12:00:00
         */
        String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    }

    /**
     * 微信用户
     */
    interface WeChatUser {
        /**
         * 取关用户
         */
        Integer UN_SUBSCRIPTION_USER = 0;

        /**
         * 净增粉丝
         */
        Integer SUBSCRIPTION_USER = 1;

        /**
         * 老用户
         */
        Integer OLD_USER = -1;

    }

}
