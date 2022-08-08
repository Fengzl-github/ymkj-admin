package com.ym.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zaiAdmin
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ym.admin.mapper")
public class YmkjAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkjAdminApplication.class, args);
    }

}
