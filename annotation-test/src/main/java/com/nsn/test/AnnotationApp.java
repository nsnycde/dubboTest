package com.nsn.test;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.nsn.test")
public class AnnotationApp {
    public static void main( String[] args ) {
        SpringApplication.run(AnnotationApp.class, args);
    }
}
