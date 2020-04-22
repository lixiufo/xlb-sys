package com.demo.democommoncore.constant;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/25.
 * 系统错误异常返回码
 */
@SuppressWarnings("all")
public enum ReturnCode {


    SUCCESS(200, "操作成功"),

    ERROR_DEFAULT(500, "操作失败，请重新登录后重试"),

    ERROR_FEIGN_ERROR(50000, "api error"),
    ERROR_AUTH_ERROR(50001, "auth error"),
    ERROR_METHOD_NOT_SUPPORT(50002, "method not support"),
    ERROR_LIMIT(50003, "权限到期，请联系客服处理"),
    ERROR_PARAM(50004, "参数错误"),
    ERROR_TIMESSTAMP_ERROR(50005, "参数错误"),
    ERROR_MSGSIGNATURE(50006, "参数错误"),
    ERROR_API_LIMIT(50007, "操作过于频繁，请稍后重试"),
    ERROR_API_RUNNING(50007, "数据正在加载，请稍后刷新网页"),


    ERROR_PRODUCT_NOT_FOUND(50101, "产品不存在"),
    ERROR_APPID_NOT_FOUNT(50102, "请先授权公众号/小程序"),
    ERROR_TEMPLATE_NOT_EDIT(50103, "示例活动不可操作，请复制后操作"),
    ERROR_EVENT_NOT_FOUND(50104, "活动不存在"),
    ERROR_EVENT_STILL_RUNNING(50105, "活动开启中"),
    ERROR_ID_NOT_FOUNT(50106, "id不存在"),
    ERROR_ID_FOUNT(50107, "id存在"),
    ERROR_DISTRIBUTION_GRADE_NOT_FOUND(50108, "分销返现阶梯未设置"),
    ERROR_DISTRIBUTE_PRICE_OVER_90_PERCENT(50109, "分销价格超过总价90%"),
    ERROR_DISTRIBUTE_PRICE_LESS_THAN_1(50110, "分销价格小于1元"),
    ERROR_FILE_TYPE(50111, "上传文件类型有误"),
    ERROR_FILE_NOT_FOUND(50112, "文件不存在"),
    ERROR_FILE_OVERSIZE(50113, "图片尺寸过大，请压缩"),
    ERROR_FILE_ERROR(50114, "上传图片错误，请重新上传"),
    ERROR_WECHAT_USER_NOT_FOUND(50115, "微信用户不存在"),
    ERROR_SHOP_FORMAT_ERROR(50116, "规格配置有误"),
    ERROR_SHOP_ASSEMBLE_DOUBLE(50117, "已经拼过团"),
    ERROR_SHOP_ASSEMBLE_NOT_FOUND(50118, "团不存在"),
    ERROR_SHOP_ASSEMBLE_USER_OVER_LIMIT(50119, "该团已满，请另开新团"),
    ERROR_SHOP_ASSEMBLE_TIME_OVER_LIMIT(50120, "该团已结束，请另开新团"),
    ERROR_INVITE_CODE_ERROR(50121, "邀请码有误"),
    ERROR_SHOP_DISTRIBUTION_POSTER_LIMIT(50122, "购买之后方可生成海报"),
    ERROR_SHOP_POSTER_PROCESSING(50123, "海报生成中，请稍候"),
    ERROR_TEMPLATE_ID_NOT_FOUND(50124, "微信模板配置不存在"),

    ERROR_USER_CHECK_PWD_ERROR(50125, "两次密码不一致"),
    ERROR_USER_CHECK_CODE_ERROR(50126, "短信验证码不正确"),
    ERROR_USER_USERNAME_EXISTS(50127, "用户名已存在"),
    ERROR_USER_PHONE_EXISTS(50128, "手机号码已存在"),
    ERROR_USER_LOGIN_ERROR(50129, "账号或密码错误，请重试"),
    ERROR_USERNAME_NOT_FOUND(50130, "用户名或手机号码不存在，请先注册"),
    ERROR_TEL_CODE_OVER_LIMIT(50131, "短信已发送"),

    ERROR_PUB_RUNTIME_OVER_CURRENT(50132, "执行时间必须大于当前时间"),

    ERROR_TIME_FORMAT_YYYY_MM_DD(50133, "日期取件有误"),

    ERROR_WECHAT_USER_BAN(50134, "用户已经被拉黑了"),
    ERROR_SHOP_NOT_FOUND(50135, "店铺不存在"),
    ERROR_WITHDRAWALS_NOT_FOUND(50137, "提现记录不存在"),
    ERROR_WITHDRAWALS_HANDLED(50138, "提现记录已处理"),
    ERROR_RANDOM_CODE_NOT_FOUND(50139, "活码配置不存在"),
    ERROR_TAG_NOT_FOUND(50140, "活码标签不存在"),
    ERROR_QR_NOT_FOUND(50141, "标签下没有群二维码"),

    ERROR_DRAW_NOT_RUNNING(50142, "活动未开启"),
    ERROR_DRAW_INVITE_CODE_NOT_FOUND(50143, "您还没有参与活动，请先参与活动"),
    ERROR_DRAW_NOT_BINDING(50144, "抽奖没有关联活动"),
    ERROR_DRAW_POSTER_OVERTIME(50145, "海报过期，请重新扫描海报"),
    ERROR_DRAW_NO_PRIZE(50146, "奖品剩余数量不足，请联系客服"),
    ERROR_DRAW_NO_TIME(50147, "抽奖次数不足"),
    ERROR_EVENT_PAUSE_OR_END(50148, "活动未开始或已结束"),
    ERROR_FORM_NOT_FOUND(50149, "表单不存在"),
    ERROR_FORM_NOT_AUTH(50150, "本表单只有达成用户才能填写"),
    ERROR_MINIAPP_LIMIT_AREA(50151, "抱歉，本次活动您所在的地区无法参与"),
    ERROR_MINIAPP_PHONE_ERROR(50152, "手机号码授权失败"),

    ERROR_SHOP_EVENT_NOT_FOUND(50152, "商品不存在"),

    ERROR_SHOP_EVENT_NOT_UP(50153, "商品未上架"),

    ERROR_SHOP_WRITE_OFF_NOT_FOUND(50154, "该商品不存在核销码"),
    ERROR_SHOP_WRITE_OFF_NOT_RUNNING(50155, "活动已经暂停，请持续关注！"),
    ERROR_SHOP_ASSEMBLE_END(50156, "拼团已结束，请单独付费购买！"),

    ERROR_MEDIA_ERROR(50157, "图片上传失败，请重新上传"),

    ERROR_EVENT_NOT_FINISH(50158, "未完成活动");

    private Integer code;

    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
