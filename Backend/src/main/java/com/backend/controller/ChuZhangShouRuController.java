package com.backend.controller;

import com.backend.entity.RpCityCodeT;
import com.backend.mapper.RpCityCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ChuZhangShouRuController {
//    @Autowired
//    private RpCityCodeTMapper rpCityCodeTMapper;
//
//    @RequestMapping("/test")
//    public List<RpCityCodeT> list() {
//
//        List<RpCityCodeT> list = rpCityCodeTMapper.selectAll();
//        return  list;
//    }

    @RequestMapping(value = "/hello")
    public String HelloController() {
        System.out.println("测试成功");
        return "hello wx";
    }


}
