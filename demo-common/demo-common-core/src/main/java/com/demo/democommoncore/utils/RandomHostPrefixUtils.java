package com.demo.democommoncore.utils;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/13.
 */
public class RandomHostPrefixUtils {

    /**
     * 随机域名的盐值
     */
    private static final String SALT_CODE = "abcdefghijklmnopqrstuvwxyz1234567890";


    /**
     * 获取随机域名
     *
     * @return nn
     */
    public static String getRandomCode() {
        int length = RandomUtils.nextInt(12, 24);
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(SALT_CODE.charAt(RandomUtils.nextInt(0, SALT_CODE.length())));
        }
        return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
    }

    /**
     * 获取随机参数
     *
     * @param hostList    主域名
     * @param contentList 应用名称
     * @param url         url
     * @param params      替换参数
     * @return 接口地址
     */
    public static String getRandomUrl(List<String> hostList, List<String> contentList, String url, String... params) {
        return String.format(hostList.get(RandomUtils.nextInt(0, hostList.size() - 1)), RandomHostPrefixUtils.getRandomCode())
                + contentList.get(RandomUtils.nextInt(0, contentList.size() - 1))
                + String.format(url, params);
    }

}
