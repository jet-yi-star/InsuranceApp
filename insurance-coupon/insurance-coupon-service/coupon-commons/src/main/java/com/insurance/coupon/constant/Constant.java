package com.insurance.coupon.constant;

/**
 * <h1>常用常量定义</h1>
 * Created by Qinyi.
 */
public class Constant {

    /** Kafka 消息的 Topic */
    public static final String TOPIC = "insurance_user_coupon_op";

    /**
     * <h2>Redis Key 前缀定义</h2>
     * */
    public static class RedisPrefix {

        /** 优惠券码 key 前缀 */
        public static final String COUPON_TEMPLATE =
                "insurance_coupon_template_code_";

        /** 用户当前所有可用的优惠券 key 前缀 */
        public static final String USER_COUPON_USABLE =
                "insurance_user_coupon_usable_";

        /** 用户当前所有已使用的优惠券 key 前缀 */
        public static final String USER_COUPON_USED =
                "insurance_user_coupon_used_";

        /** 用户当前所有已过期的优惠券 key 前缀 */
        public static final String USER_COUPON_EXPIRED =
                "insurance_user_coupon_expired_";
    }
}
