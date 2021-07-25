package com.edu.bearjay.dongbao.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.edu.bearjay.dongbao.ums.mapper")
@SpringBootApplication(scanBasePackages = {"com.edu"})
public class BearjayDongbaoUmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BearjayDongbaoUmsApplication.class, args);
	}

}
