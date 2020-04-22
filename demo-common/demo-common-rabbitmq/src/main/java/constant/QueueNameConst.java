package constant;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/8.
 * 消息队列名称的常量池
 */
public interface QueueNameConst {

    /**
     * 默认消息交换器
     */
    String DEFAULT_EXCHANGE = "default";

    /**
     * 延时队列
     */
    String DELAY_EXCHANGE = "x-delayed-message";


    /**
     * 开放平台
     */
    interface WechatOpen {

        /**
         * 推送公众号客服消息
         * {@link QueueNameConst.Old#DEFAULT_EVENT_PUSH_MESSAGE}
         */
        String WECHAT_OPEN_PUSH_MESSAGE = "wechat.open.push.message";

    }

    /**
     * 公众号
     */
    interface WechatMp {

    }

    /**
     * 支付
     */
    interface WechatPay {

    }

    /**
     * 公众号
     */
    interface WxSys {
        /**
         * 锁定活动排行榜
         * {@link QueueNameConst.Old#WX_SYS_RANK_HANDLER}
         */
        String LOCK_EVENT_RANK = "wx.sys.lock.event.rank";

        /**
         * 推送兑换码
         * {@link QueueNameConst.Old#WX_SYS_RANK_HANDLER}
         */
        String REDEMPTION_PUSH = "wx.sys.redemption.push";

    }

    /**
     * 微信账户
     */
    interface WxConfig {
        /**
         * 同步用户数据到数据库
         * {@link QueueNameConst.Old#WX_SYS_USER_INFO}
         */
        String WECHAT_USER_INFO_INSERT = "wx.config.wechat.user.info.insert";

        /**
         * 绑定用户标签
         * {@link QueueNameConst.Old#WX_SYS_TAG_BIND}
         */
        String WECHAT_USER_BIND_TAG = "wx.config.wechat.user.tag.bind";

        /**
         * 渠道二维码
         */
        String WX_CONFIG_SOURCE = "wx.sys.source.scan";

        /**
         * 渠道二维码取关
         */
        String WX_CONFIG_SOURCE_UNSUBSCRIPTION = "wx.sys.source.unsubscription";
    }

    /**
     * 有赞
     */
    interface Youzan {

    }


    @Deprecated
    interface Old {
        /**
         * 有赞的更新队列
         */
        String YOUZAN_TOKEN_REFRESH = "YOUZAN_TOKEN_REFRESH";

        /**
         * 微信支付回调
         */
        String WECHAT_PAY_CALLBACK_HANDLER = "WECHAT_PAY_CALLBACK_HANDLER";

        /**
         * 第三方支付回调
         */
        String WECHAT_PAY_THIRD_CALLBACK_HANDLER = "WECHAT_PAY_THIRD_CALLBACK_HANDLER";

        /**
         * 用户数据同步
         */
        String WX_SYS_USER_INFO = "WX_SYS_USER_INFO";

        /**
         * 店铺海报队列
         */
        String SHOP_IMAGE_LISTENER = "SHOP_IMAGE_LISTENER";

        /**
         * 核销员扫码
         */
        String EVENT_WRITEOFF_CALLBACK_HANDLER = "EVENT_WRITEOFF_CALLBACK_HANDLER";

        /**
         * 绑定核销员
         */
        String EVENT_WRITEOFF_BINDING_CALLBACK_HANDLER = "EVENT_WRITEOFF_BINDING_CALLBACK_HANDLER";

        /**
         * 默认的消息推送服务
         */
        String DEFAULT_EVENT_PUSH_MESSAGE = "DEFAULT_EVENT_PUSH_MESSAGE";

        /**
         * 初始化模板消息发送队列
         */
        String QUEEN_MA_TEMPLATE_INIT_HANDLE = "QUEEN_MA_TEMPLATE_INIT_HANDLE";

        /**
         * 发送模板消息
         */
        String QUEEN_MA_TEMPLATE_SEND_HANDLE = "QUEEN_MA_TEMPLATE_SEND_HANDLE";


        /**
         * 初始化订阅消息发送队列
         */
        String QUEEN_MA_SUBSCRIPTION_INIT_HANDLE = "QUEEN_MA_SUBSCRIPTION_INIT_HANDLE";

        /**
         * 发送订阅消息
         */
        String QUEEN_MA_SUBSCRIPTION_SEND_HANDLE = "QUEEN_MA_SUBSCRIPTION_SEND_HANDLE";

        /**
         * 客服消息处理
         */
        String MA_CUSTOMER_MSG_HANDLER = "MA_CUSTOMER_MSG_HANDLER";

        /**
         * 小程序手机号码
         */
        String API_PHONE_HANDLER = "MA_API_PHONE_HANDLER";

        /**
         * 海报队列
         */
        String MA_IMAGE_LISTENER = "MA_IMAGE_LISTENER";

        /**
         * 微信消息
         */
        String WECHAT_MESSAGE = "WECHAT_MESSAGE";

        /**
         * 公众号关键词处理类
         */
        String WX_CONFIG_KEYWORD_HANDLER = "WX_KEYWORD_HANDLER";

        /**
         * 活动关键词处理类
         */
        String WX_EVENT_KEYWORD_HANDLER = "WX_EVENT_HANDLER";

        /**
         * 节日签处理类
         */
        String WX_FESTIVAL_KEYWORD_HANDLER = "FESTIVAL_EVENT_KEYWORD_HANDLER";

        /**
         * 订阅号活动邀请码形式的处理
         */
        String WX_EVENT_INVITE_CODE_HANDLER = "WX_EVENT_SUBSCRIPTION_INVITE_CODE_HANDLER";

        /**
         * 菜单栏点击事件队列
         */
        String WX_CONFIG_MENU_HANDLER = "WX_MENU_CONFIG_HANDLER";

        /**
         * 取关事件队列
         */
        String WX_EVENT_UNSUBSCRIPTION = "WX_EVENT_UNSUBSCRIBE_HANDLER";

        /**
         * 小程序卡片处理
         */
        String WX_MA_MSG_HANDLER = "MA_CUSTOMER_MSG_HANDLER";

        /**
         * 关注自动回复
         */
        String WX_CONFIG_NEW_FOLLOW = "WX_NEW_FOLLOW";

        /**
         * SOP处理
         */
        String WX_CONFIG_SOP_HANDLER = "WX_PUB_SOP_CONFIG";

        /**
         * 未关注状态下扫描节日签二维码
         */
        String WX_FESTIVAL_EVENT_SUBSCRIPTION_HANDLER = "FESTIVAL_EVENT_SUBSCRIPTION_SCAN_HANDLER";

        /**
         * 关注状态扫描节日签二维码
         */
        String FESTIVAL_EVENT_SCAN_HANDLER = "FESTIVAL_EVENT_SCAN_HANDLER";

        /**
         * 未关注状态下扫描带参二维码
         */
        String WX_EVENT_NEW_FOLLOW_FROM_SCAN = "WX_EVENT_NEW_FOLLOW_FROM_SCAN";

        /**
         * 关注状态下扫描带参二维码
         */
        String WX_EVENT_SCAN_EVENT = "WX_EVENT_SCAN_EVENT";

        /**
         * 关注自动回复扫码
         */
        String WX_KEYWORD_SCAN_HANDLER = "WX_KEYWORD_SCAN_HANDLER";

        /**
         * 分享宝活动
         */
        String WX_EVENT_SHARE_IMAGE_HANDLER = "WX_EVENT_SHARE_IMAGE_HANDLER";

        /**
         * 扫码支付回调
         */
        String WECHAT_NATIVE_PAY_NOTIFY_CALLBACK = "WECHAT_NATIVE_PAY_NOTIFY_CALLBACK";

        String QUEEN_INIT_USER_DATA_HANDLE = "QUEEN_INIT_USER_DATA_HANDLE";

        String WX_NEW_FOLLOW = "WX_NEW_FOLLOW";

        String WX_EVENT_DOUBLE_SCAN = "WX_EVENT_DOUBLE_SCAN";

        String WX_EVENT_HANDLER = "WX_EVENT_HANDLER";

        String QUEEN_USER_LIST_HANDLE = "QUEEN_USER_LIST_HANDLE";


        String WX_KEYWORD_HANDLER = "WX_KEYWORD_HANDLER";

        /**
         * 锁定排行榜功能
         */
        String WX_SYS_RANK_HANDLER = "WX_SYS_RANK_HANDLER";

        /**
         * 兑换码
         */
        String REDEMPTION_LISTENER = "REDEMPTION_LISTENER";

        String WX_SYS_TAG_BIND = "WX_SYS_TAG_BIND";


        String WX_EVENT_SUBSCRIPTION_INVITE_CODE_HANDLER = "WX_EVENT_SUBSCRIPTION_INVITE_CODE_HANDLER";

        String WX_MENU_CONFIG_HANDLER = "WX_MENU_CONFIG_HANDLER";


        String FESTIVAL_EVENT_KEYWORD_HANDLER = "FESTIVAL_EVENT_KEYWORD_HANDLER";


        String FESTIVAL_EVENT_SUBSCRIPTION_SCAN_HANDLER = "FESTIVAL_EVENT_SUBSCRIPTION_SCAN_HANDLER";


        String WX_EVENT_UNSUBSCRIBE_HANDLER = "WX_EVENT_UNSUBSCRIBE_HANDLER";


        String API_HANDLER = "API_HANDLER";

        String API_RELATIONSHIP_HANDLER = "API_RELATIONSHIP_HANDLER";

        String POSTER_DOUBLE = "POSTER_DOUBLE";

        String POSTER_DEFAULT = "POSTER_DEFAULT";

        String FESTIVAL_DEFAULT = "FESTIVAL_DEFAULT";

        String FESTIVAL_DOUBLE = "FESTIVAL_DOUBLE";

        String WX_EVENT_REMOVE_UNSUBSCRIPTION_HANDLER = "WX_EVENT_REMOVE_UNSUBSCRIPTION_HANDLER";

        /**
         * 初始化模板消息发送队列
         */
        String QUEEN_TEMPLATE_INIT_HANDLE = "QUEEN_TEMPLATE_INIT_HANDLE";

        /**
         * 发送模板消息
         */
        String QUEEN_TEMPLATE_SEND_HANDLE = "QUEEN_TEMPLATE_SEND_HANDLE";

        /**
         * 初始化客服消息发送队列
         */
        String QUEEN_MESSAGE_INIT_HANDLE = "QUEEN_MESSAGE_INIT_HANDLE";

        /**
         * 初始化客服消息发送队列(文字 + 图片)
         */
        String QUEEN_MESSAGE_SEND_TEXT_HANDLE = "QUEEN_MESSAGE_SEND_TEXT_HANDLE";


        /**
         * 初始化客服消息发送队列(图文)
         */
        String QUEEN_MESSAGE_SEND_MEDIA_HANDLE = "QUEEN_MESSAGE_SEND_MEDIA_HANDLE";


        String WX_PUB_SOP_CONFIG = "WX_PUB_SOP_CONFIG";

        /**
         * 日志
         */
        String SYS_LOG = "SYS_LOG";

        String WECHAT_LOG = "WECHAT_LOG";
    }


}
