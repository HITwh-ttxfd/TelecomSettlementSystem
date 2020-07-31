package com.backend.controller;


import com.backend.entity.RpCityCodeT;
import com.backend.mapper.RpCityCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RpCityCodeT")
public class RpCityCodeTController {
    @Autowired
    private RpCityCodeTMapper rpCityCodeTMapper;

    //返回所有城市编码和城市名称
    @RequestMapping(value = "/selectRpCityCodeT",method = {RequestMethod.GET})
    public List<RpCityCodeT> selectAllCity(){
        System.out.println("成功找到所有城市编码和城市名称");
        return rpCityCodeTMapper.selectAll();
    }

}
