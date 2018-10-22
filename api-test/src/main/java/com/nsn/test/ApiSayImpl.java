package com.nsn.test;

import java.util.Random;

/**
 * @author donghao
 * @Description:
 * @Date: 2018/10/16 10:04
 */

public class ApiSayImpl implements Say{

    private Random random = new Random();

    @Override
    public String say(String name) {
        try {
            Thread.sleep(random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("API:Hello," + name);
        return "API:nice to meet you!";
    }
}
