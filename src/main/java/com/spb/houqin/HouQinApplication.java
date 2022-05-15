package com.spb.houqin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {"com.spb.houqin.admin.mapper"})
public class HouQinApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouQinApplication.class, args);
    }

}
