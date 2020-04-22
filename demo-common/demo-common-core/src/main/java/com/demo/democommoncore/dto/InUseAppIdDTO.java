package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/7/2.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InUseAppIdDTO extends BaseDTO {

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 正在使用的公众号id
     */
    private String appId;

    /**
     * 正在使用的公众号的username
     */
    private String userName;

    /**
     * 正在使用的公司名称
     */
    private String companyName;

}
