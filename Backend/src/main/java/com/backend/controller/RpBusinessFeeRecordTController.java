package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:通知单收入Mapper
 */

import com.backend.entity.RpBusinessFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import com.backend.form.RpBusinessFeeRecordTSelectForm;
import com.backend.mapper.RpBusinessFeeRecordTMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/RpBusinessFeeRecordT")
public class RpBusinessFeeRecordTController {
    @Autowired
    RpBusinessFeeRecordTMapper rpBusinessFeeRecordTMapper;

    //找到通知单收入
    @RequestMapping(value = "/selectAllRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public List<RpBusinessFeeRecordT> selectAllRpBusinessFeeRecordT(@RequestParam(required = false) String cityCode, @RequestParam(required = false) String productCode, @RequestParam(required = false) String businessFeeTypeCode, @RequestParam(required = false) Date businessRecordDate,@RequestParam(required = false) String checkStatus){
        RpBusinessFeeRecordTSelectForm rpBusinessFeeRecordTSelectForm=new RpBusinessFeeRecordTSelectForm();
        rpBusinessFeeRecordTSelectForm.setBusinessFeeTypeCode(businessFeeTypeCode);
        rpBusinessFeeRecordTSelectForm.setBusinessRecordDate(businessRecordDate);
        rpBusinessFeeRecordTSelectForm.setCityCode(cityCode);
        rpBusinessFeeRecordTSelectForm.setProductCode(productCode);
        rpBusinessFeeRecordTSelectForm.setCheckStatus(checkStatus);
        System.out.println("成功找到网间通知单收入");
        return rpBusinessFeeRecordTMapper.selectAllRpBusinessFeeRecordT(rpBusinessFeeRecordTSelectForm);
    }

    //删除通知单收入
    @RequestMapping(value = "/deleteRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public void deleteRpBusinessFeeRecordT(@RequestParam int[] ids){
        rpBusinessFeeRecordTMapper.deleteRpBusinessFeeRecordT(ids);
        System.out.println("成功删除通知单收入");

    }

    //增加一条通知单
    @RequestMapping(value = "/addRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public void addRpBusinessFeeRecordT(@RequestParam String cityCode, @RequestParam String productCode, @RequestParam String businessFeeTypeCode,
                                   @RequestParam Date businessRecordDate, @RequestParam Double businessFee,@RequestParam String recordOperator ){

        RpBusinessFeeRecordT rpBusinessFeeRecordT=new RpBusinessFeeRecordT();
        rpBusinessFeeRecordT.setCityCode(cityCode);
        rpBusinessFeeRecordT.setProductCode(productCode);
        rpBusinessFeeRecordT.setBusinessFeeTypeCode(businessFeeTypeCode);
        rpBusinessFeeRecordT.setBusinessRecordDate(businessRecordDate);
        rpBusinessFeeRecordT.setBusinessFee(businessFee);
        rpBusinessFeeRecordT.setRecordOperator(recordOperator);
        rpBusinessFeeRecordTMapper.addRpBusinessFeeRecordT(rpBusinessFeeRecordT);

        System.out.println("成功添加一条通知单");
        System.out.println(rpBusinessFeeRecordT);

    }

    //更新通知单 更新稽核状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @RequestMapping(value = "/updateRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public void updateRpBusinessFeeRecordT(@RequestParam(required = false) int ID,@RequestParam(required = false) String cityCode, @RequestParam(required = false) String productCode, @RequestParam(required = false) String businessFeeTypeCode,
                                        @RequestParam(required = false) Date businessRecordDate, @RequestParam(required = false) Double businessFee,@RequestParam(required = false) String recordOperator,
                                         @RequestParam(required = false) String checkStatus ,@RequestParam(required = false) String checkPerson,@RequestParam(required = false) Date checkTime){

        RpBusinessFeeRecordT rpBusinessFeeRecordT=new RpBusinessFeeRecordT();
        rpBusinessFeeRecordT.setID(ID);
        rpBusinessFeeRecordT.setCityCode(cityCode);
        rpBusinessFeeRecordT.setProductCode(productCode);
        rpBusinessFeeRecordT.setBusinessFeeTypeCode(businessFeeTypeCode);
        rpBusinessFeeRecordT.setBusinessRecordDate(businessRecordDate);
        rpBusinessFeeRecordT.setBusinessFee(businessFee);
        rpBusinessFeeRecordT.setRecordOperator(recordOperator);
        rpBusinessFeeRecordT.setCheckStatus(checkStatus);
        rpBusinessFeeRecordT.setCheckTime(checkTime);
        rpBusinessFeeRecordT.setCheckPerson(checkPerson);
        System.out.println(checkTime);
        System.out.println(rpBusinessFeeRecordT.getCheckTime());
        rpBusinessFeeRecordTMapper.updateRpBusinessFeeRecordT(rpBusinessFeeRecordT);


        System.out.println("成功更新一条通知单");
        System.out.println(checkTime);


    }
}
