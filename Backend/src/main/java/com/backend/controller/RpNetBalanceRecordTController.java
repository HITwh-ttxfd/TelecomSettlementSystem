package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:网间结算录入Mapper
 */

import com.backend.entity.RpNetBalanceRecordT;
import com.backend.form.RpNetBalanceRecordTSelectForm;
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

    //删除网间结算收入
    @RequestMapping(value = "/deleteRpNetBalanceRecordT",method = {RequestMethod.GET})
    public void deleteRpNetBalanceRecordT(@RequestParam int[] ids){
        rpNetBalanceRecordTMapper.deleteRpNetBalanceRecordT(ids);
        System.out.println("成功删除网间结算收入");

    }


    //找到网间结算收入
    @RequestMapping(value = "/selectAllRpNetBalanceRecordT",method = {RequestMethod.GET})
    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT(@RequestParam(required = false) Date balanceMonth, @RequestParam(required = false) String cityCode, @RequestParam(required = false) String productCode, @RequestParam(required = false) String balanceSpCode,
                                                                  @RequestParam(required = false) String balanceTypeCode,@RequestParam(required = false) String checkStatus){
        RpNetBalanceRecordTSelectForm rpNetBalanceRecordTSelectForm=new RpNetBalanceRecordTSelectForm();
        rpNetBalanceRecordTSelectForm.setBalanceMonth(balanceMonth);
        rpNetBalanceRecordTSelectForm.setBalanceSpCode(balanceSpCode);
        rpNetBalanceRecordTSelectForm.setBalanceTypeCode(balanceTypeCode);
        rpNetBalanceRecordTSelectForm.setProductCode(productCode);
        rpNetBalanceRecordTSelectForm.setCityCode(cityCode);
        rpNetBalanceRecordTSelectForm.setCheckStatus(checkStatus);

        System.out.println("成功找到网间通知单收入");
        return rpNetBalanceRecordTMapper.selectAllRpNetBalanceRecordT(rpNetBalanceRecordTSelectForm);
    }


    //更新网间结算
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping(value = "/updateRpNetBalanceRecordT",method = {RequestMethod.GET})
    public void updateRpNetBalanceRecordT(@RequestParam int ID,@RequestParam(required = false)  Date balanceMonth, @RequestParam(required = false)  String cityCode, @RequestParam(required = false)  String productCode, @RequestParam(required = false)  String balanceSpCode,
                                       @RequestParam(required = false)  String balanceTypeCode, @RequestParam(required = false)  String recordOperator, @RequestParam(required = false)  Double balanceFee,
                                          @RequestParam(required = false) String checkStatus ,@RequestParam(required = false) String checkPerson,@RequestParam(required = false) Date checkTime){
        RpNetBalanceRecordT rpNetBalanceRecordT=new RpNetBalanceRecordT();
        rpNetBalanceRecordT.setID(ID);
        rpNetBalanceRecordT.setBalanceMonth(balanceMonth);
        rpNetBalanceRecordT.setCityCode(cityCode);
        rpNetBalanceRecordT.setProductCode(productCode);
        rpNetBalanceRecordT.setBalanceSpCode(balanceSpCode);
        rpNetBalanceRecordT.setBalanceTypeCode(balanceTypeCode);
        rpNetBalanceRecordT.setRecordOperator(recordOperator);
        rpNetBalanceRecordT.setBalanceFee(balanceFee);
        rpNetBalanceRecordT.setCheckStatus(checkStatus);
        rpNetBalanceRecordT.setCheckPerson(checkPerson);
        rpNetBalanceRecordT.setCheckTime(checkTime);
        rpNetBalanceRecordTMapper.updateRpNetBalanceRecordT(rpNetBalanceRecordT);
        System.out.println("成功更新一条网间结算");
    }


}
