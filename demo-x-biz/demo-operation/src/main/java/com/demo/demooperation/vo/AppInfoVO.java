package com.demo.demooperation.vo;

import com.demo.democommoncore.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author WPF
 * @version demo-operation
 * @date 2019/11/6.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppInfoVO extends BaseVO {

    /**
     * 公众号id
     */
    private String appId;

    /**
     * 粉丝数量
     */
    private Long count;

    /**
     * 所属业务
     */
    private String seller;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
