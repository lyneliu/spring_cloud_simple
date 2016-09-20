package com.lyne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/sentence")
    public String getSentence() {
        /*return getWord("eureka-subject") + " "
                + getWord("eureka-verb") + " "
                + getWord("eureka-article") + " "
                + getWord("eureka-adjective") + " "
                + getWord("eureka-noun") + ".";*/
        return getWord("eureka-client");
    }

    private String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            String url = uri.toString() + "/word";
            if (uri != null) {
                return (new RestTemplate()).getForObject(url, String.class);
            }
        }

        return null;
    }
}

