package com.lyne.controller;

import com.lyne.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nn_liu on 2016/9/21.
 */
@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/hystrix", method = RequestMethod.GET)
    public String add() {
        return hystrixService.wordService();
    }
}
