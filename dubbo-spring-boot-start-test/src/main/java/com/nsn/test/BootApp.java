package com.nsn.test;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@EnableDubboConfiguration
@SpringBootApplication
public class BootApp {

    public static void main( String[] args ) {
        SpringApplication.run(BootApp.class, args);
    }
}
