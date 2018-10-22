package com.nsn.test;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author donghao
 * @Description:
 * @Date: 2018/10/22 13:39
 */
@Component
public class XmlSayImpl implements Say{

    private Random random = new Random();

    @Override
    public String say(String name) {
        try {
            Thread.sleep(random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("XML:Hello," + name);
        return "XML:nice to meet you!";
    }
}
