package com.nsn.test;

import com.alibaba.dubbo.config.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author donghao
 * @Description:  提供者
 * @Date: 2018/10/16 10:03
 */
public class ApiProvider {

    public static void main(String[] args) {

        //应用
        ApplicationConfig applicationConfig = new ApplicationConfig("api-dubbo");

        //注册中心
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        registryConfig.setClient("zkclient");

        //通讯协议---dubbo
        ProtocolConfig dubboProtocolConfig = new ProtocolConfig("dubbo");
        //dubbo协议通讯端口
        dubboProtocolConfig.setPort(20880);
        //线程池线程数
        dubboProtocolConfig.setThreads(55);

        //通讯协议---hessian
        ProtocolConfig hessianProtocolConfig = new ProtocolConfig("hessian");
        //dubbo协议通讯端口
        hessianProtocolConfig.setPort(8888);
        //设置服务器
        //hessianProtocolConfig.setServer("tomcat");
        hessianProtocolConfig.setServer("jetty");
        //线程池线程数
        hessianProtocolConfig.setThreads(55);

        //通讯协议列表
        List<ProtocolConfig> protocolConfigList = new ArrayList<>();
        protocolConfigList.add(dubboProtocolConfig);
        protocolConfigList.add(hessianProtocolConfig);

        //监控
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");


        //提供者  此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<Say> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);

        //serviceConfig.setProtocol(dubboProtocolConfig);

        serviceConfig.setProtocols(protocolConfigList);

        serviceConfig.setInterface(Say.class);
        serviceConfig.setRef(new ApiSayImpl());

        serviceConfig.setMonitor(monitorConfig);

        //设置只订阅不注册
        //serviceConfig.setRegister(false);

        //暴露服务
        serviceConfig.export();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
