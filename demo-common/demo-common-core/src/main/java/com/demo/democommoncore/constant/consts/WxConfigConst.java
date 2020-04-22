package com.demo.democommoncore.constant.consts;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 * 微信config的常量池
 */
public interface WxConfigConst {

    /**
     * 渠道码
     */
    interface Source {
        /**
         * 关注状态扫码
         */
        String EVENT_KEY_PREFIX = "source_";

        /**
         * 取关状态下扫码
         */
        String EVENT_KEY_PREFIX_ALL = "qrscene_source_";
    }

}
