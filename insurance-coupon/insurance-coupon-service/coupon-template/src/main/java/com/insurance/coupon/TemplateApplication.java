package com.insurance.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h1>模板微服务的启动入口</h1>
 * Created by Qinyi.
 */
@EnableScheduling
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class TemplateApplication {
    // args, java -jar 启动SpringBoot应用，传递参数，如Eureka profiles 多实例
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
