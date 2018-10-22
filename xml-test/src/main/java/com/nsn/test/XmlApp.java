package com.nsn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class XmlApp {
    public static void main( String[] args ) {
        SpringApplication.run(XmlApp.class, args);
    }
}
