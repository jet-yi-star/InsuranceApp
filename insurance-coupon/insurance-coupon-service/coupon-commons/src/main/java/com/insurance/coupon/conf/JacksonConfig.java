package com.insurance.coupon.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
/**
 * <h1>Jackson 的自定义配置</h1>
 * Created by Qinyi.
 */
// http json格式配置
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper getObjectMapper() {

        ObjectMapper mapper = new ObjectMapper();
        //将Date 类型 转成我们要的时间格式
        mapper.setDateFormat(new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
        ));
        return mapper;
    }
}
