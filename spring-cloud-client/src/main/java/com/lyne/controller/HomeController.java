package com.lyne.controller;

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

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "Hello World!";
    }
}
