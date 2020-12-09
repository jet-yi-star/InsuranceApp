package com.insurance.coupon.service;

import com.alibaba.fastjson.JSON;
import com.insurance.coupon.constant.CouponCategory;
import com.insurance.coupon.constant.DistributeTarget;
import com.insurance.coupon.constant.PeriodType;
import com.insurance.coupon.constant.ProductLine;
import com.insurance.coupon.vo.TemplateRequest;
import com.insurance.coupon.vo.TemplateRule;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 * <h1>构造优惠券模板服务测试</h1>
 * Created by Qinyi.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BuildTemplateTest {

    @Autowired
    private IBuildTemplateService buildTemplateService;

    @Test
    public void testBuildTemplate() throws Exception {

        System.out.println(JSON.toJSONString(
                buildTemplateService.buildTemplate(fakeTemplateRequest())
        ));
        //buildTemplate包含异步服务，但调用该异步服务的方法会直接返回，测试用例结束，导致异步服务异常，（主线程结束，让主线程睡眠5s））
        //WEb 服务一直运行，只有测试需要这样
        Thread.sleep(5000);
    }

    @Test
    public void testBuildTemplate2() throws Exception {

        System.out.println(JSON.toJSONString(
                buildTemplateService.buildTemplate(fakeTemplateRequest())
        ));
        //buildTemplate包含异步服务，但调用该异步服务的方法会直接返回，测试用例结束，导致异步服务异常，（主线程结束，让主线程睡眠5s））
        //WEb 服务一直运行，只有测试需要这样
        Thread.sleep(5000);
    }

    /**
     * <h2>fake TemplateRequest</h2>
     * */
    private TemplateRequest fakeTemplateRequest() {

        TemplateRequest request = new TemplateRequest();
        request.setName("优惠券模板-" + new Date().getTime());
        request.setLogo("http://www.insurance.com");
        request.setDesc("这是一张优惠券模板");
        request.setCategory(CouponCategory.MANJIAN.getCode());
        request.setProductLine(ProductLine.DAMAO.getCode());
        request.setCount(10000);
        request.setUserId(10001L);  // fake user id/ L - long type
        request.setTarget(DistributeTarget.SINGLE.getCode());

        TemplateRule rule = new TemplateRule();
        //set 内部类
        rule.setExpiration(new TemplateRule.Expiration(
                PeriodType.SHIFT.getCode(),
                1, DateUtils.addDays(new Date(), 60).getTime()
        ));
        rule.setDiscount(new TemplateRule.Discount(5, 1));
        rule.setLimitation(1);
        rule.setUsage(new TemplateRule.Usage(
                "安徽省", "桐城市",
                JSON.toJSONString(Arrays.asList("文娱", "家居"))
        ));
        rule.setWeight(JSON.toJSONString(Collections.EMPTY_LIST));

        request.setRule(rule);

        return request;
    }


}
