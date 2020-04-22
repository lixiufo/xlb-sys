package com.demo.democommoncore.constant;

import java.math.BigDecimal;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2019/7/10.
 */
public class SystemConst {

    /**
     * 内部接口
     */
    public static final String INNER_FROM = "inner";

    /**
     * 接口调用TOKEN
     */
    public static final String INNER_TOKEN = "03743acaba36ade849a7522e00957986";


    /**
     * 文件目录
     */
    public static final String BASE_DIR = "/file";

    /**
     * TODO 导出目录 -> 定时任务清理
     */
    public static final String EXPORT_DIR = BASE_DIR + "/excel";

    /**
     * 最低提现金额
     */
    public static final BigDecimal MIN_INCOME = new BigDecimal("100");

    /**
     * 最低提现金额
     */
    public static final Integer MIN_INCOME_INTEGER = 100;
}
