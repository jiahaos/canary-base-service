package com.canary.security.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ComponentScan({
        "com.canary",
        "com.jaf",
        "org.jaf"
})
@EntityScan({
        "com.canary.biz.acl.enti",
})
@MapperScan({
        "com.canary.biz.acl.repo"
})
@EnableJpaRepositories({
        "com.canary.biz.acl.repo"
})
@Controller
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}

