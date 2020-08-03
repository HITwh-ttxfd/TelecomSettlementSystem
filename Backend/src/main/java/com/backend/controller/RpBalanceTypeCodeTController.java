package com.backend.controller;

import com.backend.entity.RpBalanceSpCodeT;
import com.backend.entity.RpBalanceTypeCodeT;
import com.backend.mapper.RpBalanceSpCodeTMapper;
import com.backend.mapper.RpBalanceTypeCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author:万宇成
 * date:2020-8-1
 * purpose:结算类型参数管理表
 */

@RestController
@RequestMapping("/RpBalanceTypeCodeT")
public class RpBalanceTypeCodeTController {
    @Autowired
    RpBalanceTypeCodeTMapper rpBalanceTypeCodeTMapper;


    @RequestMapping(value = "/selectRpBalanceSpCodeT",method = {RequestMethod.GET})
    public List<RpBalanceTypeCodeT> selectAllRpBalanceSpCodeT(){
        System.out.println("成功找到结算类型编码");
        return rpBalanceTypeCodeTMapper.selectAllRpBalanceTypeCodeT();
    }
}
