package com.demo.demooperation.vo;

import com.demo.democommoncore.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author WPF
 * @version demo-operation
 * @date 2019/11/7.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventOrUserOrOrderOrDistributionInfoVO extends BaseVO {

    /**
     * id
     */
    private String id;

    /**
     * appId
     */
    private String appId;

    /**
     * yyyy-MM
     */
    private String date;

    /**
     * 指定的业务
     */
    private String seller;

    /**
     * 计数
     */
    private Long count;

    /**
     * 求和
     */
    private BigDecimal sum;

    /**
     * pv
     */
    private Integer pv;

    /**
     * uv
     */
    private Integer uv;

    public EventOrUserOrOrderOrDistributionInfoVO add(EventOrUserOrOrderOrDistributionInfoVO eventOrUserOrOrderOrDistributionInfoVO) {
        if (this.count == null) {
            this.count = eventOrUserOrOrderOrDistributionInfoVO.getCount();
        } else {
            this.count += eventOrUserOrOrderOrDistributionInfoVO.getCount();
        }
        if (this.pv == null) {
            this.pv = eventOrUserOrOrderOrDistributionInfoVO.getPv();
        } else {
            this.pv += eventOrUserOrOrderOrDistributionInfoVO.getPv();
        }
        if (this.uv == null) {
            this.uv = eventOrUserOrOrderOrDistributionInfoVO.getUv();
        } else {
            this.uv += eventOrUserOrOrderOrDistributionInfoVO.getUv();
        }
        if (this.sum == null) {
            this.sum = Optional.ofNullable(eventOrUserOrOrderOrDistributionInfoVO.getSum()).orElse(new BigDecimal("0"));
        } else {
            this.sum = this.sum.add(Optional.ofNullable(eventOrUserOrOrderOrDistributionInfoVO.getSum()).orElse(new BigDecimal("0")));
        }
        return this;
    }
}
