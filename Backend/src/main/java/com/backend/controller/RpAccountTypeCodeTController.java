package com.backend.controller;

import com.backend.entity.RpAccountTypeCodeT;
import com.backend.mapper.RpAccountTypeCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author:孙宝臻
 * date:2020-8-4
 * purpose:出账收入编码表
 * function：提供返回所有编码对照关系的一个表
 */

@RestController
@RequestMapping("/RpAccountTypeCodeT")
public class RpAccountTypeCodeTController {
    @Autowired
    RpAccountTypeCodeTMapper rpAccountTypeCodeTMapper;



    @RequestMapping(value = "/selectRpAccountTypeCodeT",method = {RequestMethod.GET})
    public List<RpAccountTypeCodeT> selectAllRpAccountTypeCodeT(){
        System.out.println("成功找到出账收入编码类型参数管理表");
        return rpAccountTypeCodeTMapper.selectAllRpAccountTypeCodeT();
    }
}
