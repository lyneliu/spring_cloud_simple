package com.lyne.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nn_liu on 2016/9/18.
 */

/**
 * index controller
 */
@Controller
public class HomeController {

    @Value("${lucky-word}")
    private String luckyWord;

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "Hello World!";
    }

    @RequestMapping(value = "/config")
    @ResponseBody
    public String getConfig(){
        return luckyWord;
    }
}
