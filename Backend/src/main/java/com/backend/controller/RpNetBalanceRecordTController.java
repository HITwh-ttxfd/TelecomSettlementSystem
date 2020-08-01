package com.backend.controller;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:网间结算录入Mapper
 */

import com.backend.entity.RpNetBalanceRecordT;
import com.backend.mapper.RpNetBalanceRecordTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/RpNetBalanceRecordT")
public class RpNetBalanceRecordTController {
    @Autowired
    RpNetBalanceRecordTMapper rpNetBalanceRecordTMapper;

    //增加网间结算
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping(value = "/addRpNetBalanceRecordT",method = {RequestMethod.GET})
    public void addRpNetBalanceRecordT(@RequestParam Date balanceMonth, @RequestParam String cityCode, @RequestParam String productCode, @RequestParam String balanceSpCode,
                                       @RequestParam String balanceTypeCode, @RequestParam String recordOperator, @RequestParam Double balanceFee  ){
        RpNetBalanceRecordT rpNetBalanceRecordT=new RpNetBalanceRecordT();
        rpNetBalanceRecordT.setBalanceMonth(balanceMonth);
        rpNetBalanceRecordT.setCityCode(cityCode);
        rpNetBalanceRecordT.setProductCode(productCode);
        rpNetBalanceRecordT.setBalanceSpCode(balanceSpCode);
        rpNetBalanceRecordT.setBalanceTypeCode(balanceTypeCode);
        rpNetBalanceRecordT.setRecordOperator(recordOperator);
        rpNetBalanceRecordT.setBalanceFee(balanceFee);
        rpNetBalanceRecordTMapper.addRpNetBalanceRecordT(rpNetBalanceRecordT);
        System.out.println("成功添加一条网间结算");


    }


    //找到网间结算收入
    @RequestMapping(value = "/selectAllRpNetBalanceRecordT",method = {RequestMethod.GET})
    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT(){
        System.out.println("成功找到网间通知单收入");
        return rpNetBalanceRecordTMapper.selectAllRpNetBalanceRecordT();
    }


}
