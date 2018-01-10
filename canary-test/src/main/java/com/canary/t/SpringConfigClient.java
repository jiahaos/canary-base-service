package com.canary.t;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) 默认不加载datasource
public class SpringConfigClient {

    @Value("${fortress.mybatis.enabled}")
    private String value;

    @GetMapping("getValue")
    private String getValue() {
        System.out.print("spring.enabled=" + value);
        return value;
    }
}
