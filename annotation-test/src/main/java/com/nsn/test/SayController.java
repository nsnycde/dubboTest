package com.nsn.test;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author donghao
 * @Description:
 * @Date: 2018/10/22 14:35
 */
@RestController
public class SayController {

    @Reference(check = false)
    private Say say;

    @RequestMapping("say")
    public String say(){
        return say.say("nsn");
    }
}
