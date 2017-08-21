package com.zsh.controller;

import com.zsh.service.CompanyBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    CompanyBasicService companyBasicService;

    @RequestMapping("/")
    public String thing() {
        return "/hello";
    }

}
