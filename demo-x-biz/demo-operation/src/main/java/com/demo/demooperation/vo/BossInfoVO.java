package com.demo.demooperation.vo;

import com.demo.democommoncore.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WPF
 * @version demo-operation
 * @date 2019/11/6.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BossInfoVO extends BaseVO {

    /**
     * 业务名称
     */
    private String sellerName;

    /**
     * 公众号数量
     */
    private String appNum;

    /**
     * 总粉丝数量
     */
    private String fansNum;

    /**
     * 参与活动粉丝数量
     */
    private Long eventFansNum;

}
