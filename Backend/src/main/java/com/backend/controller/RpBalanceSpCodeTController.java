package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:结算运营商编码类型参数管理表
 */
import com.backend.entity.RpBalanceSpCodeT;
import com.backend.entity.RpCityCodeT;
import com.backend.mapper.RpBalanceSpCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/RpBalanceSpCodeT")
public class RpBalanceSpCodeTController {
    @Autowired
    RpBalanceSpCodeTMapper rpBalanceSpCodeTMapper;



    @RequestMapping(value = "/selectRpBalanceSpCodeT",method = {RequestMethod.GET})
    public List<RpBalanceSpCodeT> selectAllRpBalanceSpCodeT(){
        System.out.println("成功找到结算运营商编码类型参数管理表");
        return rpBalanceSpCodeTMapper.selectAllRpBalanceSpCodeT();
    }

}
