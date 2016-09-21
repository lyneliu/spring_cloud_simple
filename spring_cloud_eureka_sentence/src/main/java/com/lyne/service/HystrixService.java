package com.lyne.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nn_liu on 2016/9/21.
 */
@Service
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String wordService() {
        return restTemplate.getForEntity("http://eureka-client/word", String.class).getBody();
    }
    public String addServiceFallback() {
        return "this is hystrix error！";
    }
}
