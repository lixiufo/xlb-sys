package com.demo.demooperation.controller.web.v1;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.demooperation.entity.DemoOperationSysUpdateLog;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class V1SysUpdateLogControllerTest {


    @Test
    void name() {
        // select * from a where icon in ('21','22') and createTime between '2020-02-14 12:00:00' and '2020-02-14 12:00:00' and create_by!='dds'

        Wrappers.<DemoOperationSysUpdateLog>lambdaQuery()
                .in(DemoOperationSysUpdateLog::getIcon, new Object[]{"21", "22"})
                .between(DemoOperationSysUpdateLog::getCreateTime, LocalDateTime.now(), LocalDateTime.now().plusDays(2))
                .ne(DemoOperationSysUpdateLog::getCreateBy, "dds");

        //select create_by from a where dr=0 or title LIKE '%测试' ORDER BY create_time ASC


        Wrappers.<DemoOperationSysUpdateLog>lambdaQuery()
                .select(DemoOperationSysUpdateLog::getCreateBy)
                .eq(DemoOperationSysUpdateLog::getDr, 0)
                .or()
                .likeLeft(DemoOperationSysUpdateLog::getTitle, "测试")
                .orderByAsc(DemoOperationSysUpdateLog::getCreateTime);


        // select * from a where (title like ? or create_by like ?) and dr = 0


        Wrappers.<DemoOperationSysUpdateLog>lambdaQuery()
                .eq(DemoOperationSysUpdateLog::getDr, 0)
                .and(j -> j
                        .like(DemoOperationSysUpdateLog::getCreateBy, "")
                        .or()
                        .like(DemoOperationSysUpdateLog::getTitle, "")
                );

    }
}