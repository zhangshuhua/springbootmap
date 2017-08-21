package com.zsh.controller;

import com.zsh.mapper.CompanyBasicMapper;
import com.zsh.model.CompanyBasic;
import com.zsh.service.CompanyBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsh7040 on 2017-8-21.
 */
@RestController
public class MyController {

    @Autowired
    CompanyBasicService companyBasicService;

    @RequestMapping("/")
    public String thing() {
        return companyBasicService.selectOne().toString();
    }
}
