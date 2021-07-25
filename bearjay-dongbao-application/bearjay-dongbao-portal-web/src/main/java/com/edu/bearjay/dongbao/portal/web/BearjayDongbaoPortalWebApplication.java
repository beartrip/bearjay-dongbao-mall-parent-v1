package com.edu.bearjay.dongbao.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.*;

@MapperScan("com.edu.bearjay.dongbao.ums.mapper")
@SpringBootApplication(scanBasePackages = {"com.edu.bearjay"})
public class BearjayDongbaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BearjayDongbaoPortalWebApplication.class, args);
    }

}
