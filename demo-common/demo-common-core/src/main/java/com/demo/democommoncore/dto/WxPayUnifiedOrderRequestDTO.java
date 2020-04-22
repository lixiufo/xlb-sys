package com.demo.democommoncore.dto;

import lombok.Data;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/8/15.
 */
@Data
public class WxPayUnifiedOrderRequestDTO {

    private String body;

    private String detail;

    private String outTradeNo;

    private Integer totalFee;

    private String spbillCreateIp;

    private String tradeType;

    private String productId;

    private String openid;

}
