package com.zsh.service;

import com.zsh.mapper.CompanyBasicMapper;
import com.zsh.model.CompanyBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zsh7040 on 2017-8-21.
 */
@Service
public class CompanyBasicService {

    @Autowired
    CompanyBasicMapper companyBasicMapper;

    public CompanyBasic selectOne(){
        CompanyBasic companyBasic = companyBasicMapper.selectByPrimaryKey(2);
        return companyBasic;
    }
    public String hello(){
        return "hello world1";
    }
}
