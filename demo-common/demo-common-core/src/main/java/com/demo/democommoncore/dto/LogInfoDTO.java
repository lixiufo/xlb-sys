package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/2/23.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogInfoDTO extends BaseDTO {

    /**
     * url路径
     */
    private String url;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 参数
     */
    private String data;

    /**
     * 归属系统
     */
    private String sysType;

    private String className;

    private String method;

    /**
     * 消息日志
     */
    private String msg;

}
