package com.demo.demooperation.vo;

import com.demo.democommoncore.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/10/15.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RandomCodeInfoVO extends BaseVO {

    /**
     * 总扫描人数
     */
    private long totalConfigCount;

    /**
     * 今日扫描人数
     */
    private long todayConfigCount;

    /**
     * 二维码扫描人数
     */
    private long totalTagConfigCount;

    /**
     * 今日二维码扫描人数
     */
    private long todayTagConfigCount;

    /**
     * 总流失人数
     */
    private long totalLost;

    /**
     * 今日流失人数
     */
    private long todayLost;

    public long getTotalLost() {
        return Math.max(totalConfigCount - totalTagConfigCount, 0);
    }

    public long getTodayLost() {
        return Math.max(todayConfigCount - todayTagConfigCount, 0);
    }
}
