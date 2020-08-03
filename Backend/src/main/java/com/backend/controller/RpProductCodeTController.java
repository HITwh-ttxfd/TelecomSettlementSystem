package com.backend.controller;


import com.backend.entity.RpCityCodeT;
import com.backend.entity.RpProductCodeT;
import com.backend.mapper.RpProductCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:产品编码
 */
@RestController
@RequestMapping("/RpProductCodeTController")
public class RpProductCodeTController {
    @Autowired
    RpProductCodeTMapper rpProductCodeTMapper;

    @RequestMapping(value = "/selectRpProductCodeT",method = {RequestMethod.GET})
    public List<RpProductCodeT> selectAllRpProductCodeT(){
        System.out.println("成功找到所有产品编码和城市名称");
        return rpProductCodeTMapper.selectAllRpProductCodeT();
    }



}
