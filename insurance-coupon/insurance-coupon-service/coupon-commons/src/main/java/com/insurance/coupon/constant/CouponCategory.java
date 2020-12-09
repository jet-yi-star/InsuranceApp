package com.insurance.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>优惠券分类</h1>
 * Created by Qinyi.
 */
@Getter
@AllArgsConstructor
public enum CouponCategory {

    MANJIAN("满减券", "001"),
    ZHEKOU("折扣券", "002"),
    LIJIAN("立减券", "003");

    /** 优惠券描述(分类) */
    private String description;

    /** 优惠券分类编码 */
    private String code;
    //根据Code 返回枚举
    public static CouponCategory of(String code) {

        Objects.requireNonNull(code);//否则抛出异常

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code)) //true才保存
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));//要么返回对应枚举，要么抛出异常（找不到该枚举）
    }
}
