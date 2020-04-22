package com.demo.democommoncore.constant.cache;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/12/18.
 */
public class ShopConst {

    /**
     * 店铺PV
     */
    public static final String SHOP_PV_CACHE = "spc";

    /**
     * 店铺UV
     */
    public static final String SHOP_UV_CACHE = "suc";

    /**
     * 店铺UV的检测 prefix+shopId+openId,1
     */
    public static final String SHOP_UV_LIMIT_PREFIX = "suclp:";

    /**
     * 活动PV Zset -> key+username eventId score
     */
    public static final String EVENT_PV_CACHE = "epc:";

    /**
     * 活动UV Zset -> key+username eventId score
     */
    public static final String EVENT_UV_CACHE = "euc:";

    /**
     * 活动订单 Zset -> key+username eventId score
     */
    public static final String EVENT_ORDER_CACHE = "eoc:";

    /**
     * 店铺分销活动缓存
     */
    public static final String SHOP_DISTRIBUTION_CACHE = "sdc";

    /**
     * 店铺分销缓存
     */
    public static final String SHOP_DISTRIBUTION_ID_CACHE = "sdic:";

    /**
     * 核销员信息前缀
     */
    public static final String WRITE_OFF_USER_CACHE_PREFIX = "woucp:";

    /**
     * 临时二维码 核销员前缀
     */
    public static final String WRITE_OFF_USER_SCAN_PREFIX = "wousp_";

    /**
     * 临时二维码 核销员前缀
     */
    public static final String WRITE_OFF_USER_SCAN_NEW_PREFIX = "qrscene_wousp_";

    /**
     * 核销二维码
     */
    public static final String WRITE_OFF_PREFIX = "wo_";

    /**
     * 核销二维码
     */
    public static final String WRITE_OFF_NEW_PREFIX = "qrscene_wo_";

    /**
     * 店铺 用户名 对应 店铺id
     */
    public static final String INFO_CACHE_PREFIX = "dsicp:";

    /**
     * 微信支付对应的前缀 (hash) key:shopId:value
     */
    public static final String PAY_CACHE = "dspac";

    /**
     * 微信证书的缓存
     */
    public static final String PAY_KEY_CACHE = "dspakc";

    /**
     * banner缓存配置
     */
    public static final String BANNER_CACHE_PREFIX = "dsbcp:";

    /**
     * 店铺邀请码缓存 prefix+eventId+appId+openId:value（邀请码id）
     */
    public static final String SHOP_INVITE_CODE_PREFIX = "sicp:";

    /**
     * 工作号活动对应的id
     */
    public static final String SHOP_INVITE_CODE_ID_PREFIX = "sicip:";

    /**
     * 邀请记录缓存 prefix
     */
    public static final String SHOP_INVITE_INFO_PREFIX = "siip:";


    /**
     * 活动用户缓存 key -> APPID，openId  value -> 用户数据
     */
    public static final String WX_USER_INFO_CACHE_PREFIX = "eventWechatUserInfoCachePrefix:";

    /* --------------------- 前台接口缓存 ---------------------------*/

    /**
     * 用户收益缓存（锁）
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_INCOME = "fsuci:";

    /**
     * 用户订单
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_ORDER = "fsuco:";

    /**
     * 用户收货地址查询缓存（锁）
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_ADDRESS = "fsuca:";


    /**
     * 用户收货地址新增缓存（锁）
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_ADDRESS_SAVE = "fsucas:";


    /**
     * 用户收货地址修改缓存（锁）
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_ADDRESS_UPDATE = "fsucau:";


    /**
     * 用户收货地址删除缓存（锁）
     */
    public static final String FRONT_SHOP_USER_CONTROLLER_ADDRESS_DELETE = "fsucad:";

    /**
     * 拼团列表 prefix+eventId
     */
    public static final String SHOP_ASSEMBLE_ONLINE_LIST = "dd:saol:";
}
