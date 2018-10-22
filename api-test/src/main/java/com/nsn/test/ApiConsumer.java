package com.nsn.test;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * @author donghao
 * @Description:  消费者
 * @Date: 2018/10/16 10:03
 */
public class ApiConsumer {

    public static void main(String[] args) {

        //应用
        ApplicationConfig applicationConfig = new ApplicationConfig("api-dubbo");

        //注册中心
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");

        //监控
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");

        //消费者
        ReferenceConfig<Say> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(Say.class);

        referenceConfig.setMonitor(monitorConfig);

        //获取消费者代理
        Say say = referenceConfig.get();
        //EchoService echoService = (EchoService) say;

        try {
            while(true){
                String echo = say.say("nsn");
                System.out.println(echo);
                //System.out.println(echoService.$echo("heheda"));
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
