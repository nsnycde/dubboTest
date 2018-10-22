package com.nsn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author donghao
 * @Description:
 * @Date: 2018/10/22 14:35
 */
@RestController
public class SayController {

    @Autowired
    @Qualifier("xmlReferenceSay")
    private Say say;

    @RequestMapping("say")
    public String say(){
        return say.say("nsn");
    }
}
