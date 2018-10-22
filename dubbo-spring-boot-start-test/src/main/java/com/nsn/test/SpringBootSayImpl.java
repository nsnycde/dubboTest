package com.nsn.test;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author donghao
 * @Description:
 * @Date: 2018/10/22 13:39
 */
@Component
@Service
public class SpringBootSayImpl implements Say{

    private Random random = new Random();

    @Override
    public String say(String name) {
        try {
            Thread.sleep(random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SpringBoot:Hello," + name);
        return "SpringBoot:nice to meet you!";
    }
}
