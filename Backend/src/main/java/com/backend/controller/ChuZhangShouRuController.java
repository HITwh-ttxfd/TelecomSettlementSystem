package com.backend.controller;

import com.backend.entity.RpCityCodeT;
import com.backend.mapper.RpCityCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ChuZhangShouRuController {
//    @Autowired
//    private RpCityCodeTMapper rpCityCodeTMapper;
//
////    @RequestMapping("/test")
////    public List<RpCityCodeT> list() {
////        System.out.println("测试成功1");
////        List<RpCityCodeT> list = rpCityCodeTMapper.selectAll();
////        return  list;
////    }
//
//    @RequestMapping(value = "/hello")
//    public String HelloController() {
//        System.out.println("测试成功");
//        return "hello wx";
//    }
//
//    @RequestMapping(value = "/search",method = {RequestMethod.GET})
//    public List<RpCityCodeT> HelloController1(@RequestParam(required=false) String cityCode,@RequestParam(required=false) String cityName) {
//        RpCityCodeT rpCityCodeT = new RpCityCodeT();
//        rpCityCodeT.setCityCode(cityCode);
//        rpCityCodeT.setCityName(cityName);
//        System.out.println("输出成功2");
//
//        return rpCityCodeTMapper.selectAll();
//
//    }


}
