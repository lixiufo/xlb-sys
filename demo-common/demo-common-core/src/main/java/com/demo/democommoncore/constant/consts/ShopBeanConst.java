package com.demo.democommoncore.constant.consts;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/3/30.
 * 店铺的常量
 */
public interface ShopBeanConst {

    interface RedPackage {

        /**
         * 使用
         */
        Integer USED = 1;

        /**
         * 正常
         */
        Integer NORMAL = 0;

        /**
         * 绑定中
         */
        Integer BINDING = 2;
    }

    /**
     * 订单
     */
    interface Order {

        /**
         * 创建订单
         */
        Integer ORDER_CREATE = 0;

        /**
         * 支付订单
         */
        Integer ORDER_PAID = 1;

        /**
         * 关闭订单
         */
        Integer ORDER_END = 2;
    }

    /**
     * 用户类型
     */
    interface User {

        /**
         * 老用户
         */
        Integer OLDER = 0;

        /**
         * 新用户
         */
        Integer NEW = 1;
    }

    /**
     * 拼团
     */
    interface Assemble {

        /**
         * 团员类型
         */
        interface User {

            /**
             * 团员
             */
            Integer MEMBER = 0;

            /**
             * 团长
             */
            Integer LEADER = 1;
        }


        /**
         * 团类型
         */
        interface Team {

            /**
             * 临时团
             */
            Integer TEMP = 0;

            /**
             * 进行中
             */
            Integer RUNNING = 1;

            /**
             * 结束
             */
            Integer END = 2;

        }
    }
}
