package com.lyne.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nn_liu on 2016/9/19.
 */

@RestController
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${words}")
    private String words;

    @RequestMapping("/word")
    public String getWord() {
        logger.info("support the service");
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
