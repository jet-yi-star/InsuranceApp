package com.insurance.coupon.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
/**
 * <h1>定制 HTTP 消息转换器</h1>
 * Created by Qinyi.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {

        converters.clear();
        converters.add(new MappingJackson2HttpMessageConverter());
        //java实体类输出为JSON字符串格式
        //多个转换器可用，根据消息类型和内容类型选择最合适的转换器使用 java object<->http输入/输出请求的转换
    }
}
