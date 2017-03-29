package com.kdy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by user on 2017-03-23.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
