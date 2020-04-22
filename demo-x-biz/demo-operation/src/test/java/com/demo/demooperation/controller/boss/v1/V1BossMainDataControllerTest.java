package com.demo.demooperation.controller.boss.v1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/7.
 */
@Slf4j
class V1BossMainDataControllerTest {

    @Test
    void name() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String begin = "2020-03-01";
        String end = "2020-03-31";
        var startObj = new Object() {
            LocalDateTime startTime = null;

            LocalDateTime endTime = null;
        };
        if (StringUtils.isNotEmpty(begin)) {
            startObj.startTime = LocalDate.parse(begin, dateTimeFormatter).atStartOfDay();
        }
        if (StringUtils.isNotEmpty(end)) {
            startObj.endTime = LocalDate.parse(end, dateTimeFormatter).atStartOfDay();
        }
        List<String> dateString = new ArrayList<>();
        while (!startObj.endTime.isBefore(startObj.startTime)) {
            dateString.add(dateTimeFormatter.format(startObj.startTime));
            startObj.startTime = startObj.startTime.plusDays(1);
        }
        log.info("{}", dateString.size());
        log.info(dateString.toString());
    }
}