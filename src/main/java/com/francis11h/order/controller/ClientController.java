package com.francis11h.order.controller;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    //使用 RestTemplate 调用服务端接口
    @GetMapping("/getProductMsg")
    public String getProductMsg() {

//        // 第一种方式 直接用RestTemplate 缺点: url 固定写死了。。。。
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

//        // 第二种方式 spring cloud 提供了 loadBalancerClient  用其获取 host 和 port, 然后再使用 RestTemplate
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = String.format("http://%s:%s", host, port) + "/msg";
//
//
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);

        // 第三种方式 写个 config类 再里头直接使用注解 @LoadBalanced
        // 这里 getForObject 里 不需要写 url 了 直接写 服务的名字
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response = {}", response);
        return response;
    }
}
