package com.demo.demooperation.bean.boss;

import com.alibaba.fastjson.JSONArray;
import com.demo.demooperation.vo.EventOrUserOrOrderOrDistributionInfoVO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/2.
 */
class EventOrUserOrOrderOrDistributionInfoVOTest {

    @Test
    void name() throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of("C:\\Users\\qq626\\OneDrive\\桌面\\1.json"));
        List<EventOrUserOrOrderOrDistributionInfoVO> list = JSONArray.parseArray(new String(bytes), EventOrUserOrOrderOrDistributionInfoVO.class);
        long sum = list.stream().mapToLong(EventOrUserOrOrderOrDistributionInfoVO::getCount).sum();
        EventOrUserOrOrderOrDistributionInfoVO reduce = list.parallelStream().reduce(new EventOrUserOrOrderOrDistributionInfoVO(), EventOrUserOrOrderOrDistributionInfoVO::add);
        EventOrUserOrOrderOrDistributionInfoVO reduce1 = list.stream().reduce(new EventOrUserOrOrderOrDistributionInfoVO(), EventOrUserOrOrderOrDistributionInfoVO::add);
        System.out.println(sum);
        System.out.println(reduce);
        System.out.println(reduce1);
    }
}