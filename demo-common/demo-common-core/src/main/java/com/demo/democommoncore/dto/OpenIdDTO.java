package com.demo.democommoncore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WPF
 * @version demo
 * @date 2019-05-10.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenIdDTO extends BaseDTO {

    private String appId;

    private List<String> openIdList;

}
