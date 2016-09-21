package com.lyne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by nn_liu on 2016/9/19.
 */
@RestController
public class HomeController {
    @Autowired
    private DiscoveryClient client;

    /*通过Ribbon提供的负载均衡调用相关服务*/
    @Autowired
    RestTemplate restTemplate;

    /**
     * Eureka Client服务消费者
     * @return
     */
    @RequestMapping("/sentence")
    public String getSentence() {
        /* 调用不同的服务构造sentence */
        return getWord("eureka-subject") + " "
                + getWord("eureka-verb") + " "
                + getWord("eureka-article") + " "
                + getWord("eureka-adjective") + " "
                + getWord("eureka-noun") + ".";
    }

    /**
     * Ribbon，客户端的负载均衡，实现Eureka Server中已注册的服务消费
     * @return
     */
    @RequestMapping(value = "/ribbon",method = RequestMethod.GET)
    @ResponseBody
    public String getRibbonService(){
        return restTemplate.getForEntity("http://eureka-client/word",String.class).getBody();
    }

    private String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            /* 指定调用的URL */
            String url = uri.toString() + "/word";
            if (uri != null) {
                /*获取host和port信息*/
                //String word = (new RestTemplate()).getForObject(url, String.class);
                //return "host:" + list.get(0).getHost()+",port:"+list.get(0).getPort()+",word:"+word;
                return (new RestTemplate()).getForObject(url, String.class);
            }
        }

        return null;
    }
}

