package com.watermelon.jtarget.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "hello, world!");
        return "Test";
    }
}
