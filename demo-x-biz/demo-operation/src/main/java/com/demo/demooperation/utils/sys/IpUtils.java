package com.demo.demooperation.utils.sys;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WPF
 * @version distribution
 * @date 2019-04-04.
 */

public class IpUtils {

    /**
     * @Description: 获取客户端IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception ignored) {
                }
                if (inet != null) {
                    ip = inet.getHostAddress();
                }
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }


    /**
     * Long转ip
     *
     * @param number
     *         nn
     *
     * @return nn
     */
    public static String longToIp(Long number) {
        StringBuilder ip = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            ip.append((number & 0xff));
            if (i != 0) {
                ip.append(".");
            }
            number = number >> 8;
        }

        return ip.toString();
    }

    public static void main(String[] args) {
        System.out.println(IpUtils.ipToLong("117.136.66.150"));
    }

    /**
     * IP转换为Long
     *
     * @param ip
     *         nn
     *
     * @return nn
     */
    public static long ipToLong(String ip) {
        String[] ipArray = ip.split("\\.");
        List<Long> ipNums = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            ipNums.add(Long.parseLong(ipArray[i].trim()));
        }

        return ipNums.get(0) * 256L * 256L * 256L
                + ipNums.get(1) * 256L * 256L + ipNums.get(2) * 256L
                + ipNums.get(3);
    }
}
