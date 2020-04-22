package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WPF
 * @version demo
 * @date 2019-05-09.
 * 消息传输的工具类
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageParamsDTO extends BaseDTO {

    /**
     * appId 必填的appId
     */
    private String appId;

    private String msgType;

    private String toUser;

    private String title;

    private String pagePath;

    private String thumbMediaId;

    private String mediaId;

    private String description;

    private String musicUrl;

    private String hqMusicUrl;

    private String content;

    private String cardId;

    private String url;

    private String picUrl;

    private String createBy;

    private String recordId;
}
