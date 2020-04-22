package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WechatAppInfoDTO extends BaseDTO {

    private String userName;

    private String alias;

    private String appId;

    private String headImg;

    private String nickName;

    private String principalName;

    private String qrcodeUrl;

    private Integer serviceTypeInfo;

    private Integer verifyTypeInfo;

    private String wechatOpenTokenId;

    private String createBy;
}