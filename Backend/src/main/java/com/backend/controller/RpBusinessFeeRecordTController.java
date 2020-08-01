package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:网间结算录入Mapper
 */

import com.backend.entity.RpBusinessFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import com.backend.mapper.RpBusinessFeeRecordTMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    //找到网间通知单收入
    @RequestMapping(value = "/selectAllRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public List<RpBusinessFeeRecordT> selectAllRpBusinessFeeRecordT(){
        System.out.println("成功找到网间通知单收入");
        return rpBusinessFeeRecordTMapper.selectAllRpBusinessFeeRecordT();
    }

    //增加一条通知单
    @RequestMapping(value = "/addRpBusinessFeeRecordT",method = {RequestMethod.GET})
    public void addRpBusinessFeeRecordT(@RequestParam String cityCode, @RequestParam String productCode, @RequestParam String businessFeeTypeCode,
                                   @RequestParam Date business_record_date, @RequestParam Double businessFee,@RequestParam String recordOperator ){

        RpBusinessFeeRecordT rpBusinessFeeRecordT=new RpBusinessFeeRecordT();
        rpBusinessFeeRecordT.setCityCode(cityCode);
        rpBusinessFeeRecordT.setProductCode(productCode);
        rpBusinessFeeRecordT.setBusinessFeeTypeCode(businessFeeTypeCode);
        rpBusinessFeeRecordT.setBusiness_record_date(business_record_date);
        rpBusinessFeeRecordT.setBusinessFee(businessFee);
        rpBusinessFeeRecordT.setRecordOperator(recordOperator);
        rpBusinessFeeRecordTMapper.addRpBusinessFeeRecordT(rpBusinessFeeRecordT);

        System.out.println("成功添加一条通知单");

    }
}
