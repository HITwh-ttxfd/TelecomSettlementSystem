package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:预存转收入Mapper
 */

import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import com.backend.form.RpPreFeeRecordTSelectFrom;
import com.backend.mapper.RpNetBalanceRecordTMapper;
import com.backend.mapper.RpPreFeeRecordTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/RpPreFeeRecordT")
public class RpPreFeeRecordTController {
    @Autowired
    RpPreFeeRecordTMapper rpPreFeeRecordTMapper;

    //找到预存转录
    @RequestMapping(value = "/selectAllRpPreFeeRecordT",method = {RequestMethod.GET})
    public List<RpPreFeeRecordT> selectAllRpPreFeeRecordT(@RequestParam(required = false) Date recordDate,@RequestParam(required = false) String cityCode, @RequestParam(required = false) String productCode,
                                                          @RequestParam(required = false) String writeOffTypeCode,@RequestParam(required = false) String checkStatus){

        RpPreFeeRecordTSelectFrom rpPreFeeRecordTSelectFrom=new RpPreFeeRecordTSelectFrom();
        rpPreFeeRecordTSelectFrom.setCityCode(cityCode);
        rpPreFeeRecordTSelectFrom.setProductCode(productCode);
        rpPreFeeRecordTSelectFrom.setRecordDate(recordDate);
        rpPreFeeRecordTSelectFrom.setWriteOffTypeCode(writeOffTypeCode);
        rpPreFeeRecordTSelectFrom.setCheckStatus(checkStatus);
        System.out.println("成功找到预存转录");
        return rpPreFeeRecordTMapper.selectAllRpPreFeeRecordT(rpPreFeeRecordTSelectFrom);
    }

    //增加一条预存转录信息
    @RequestMapping(value = "/addRpPreFeeRecordT",method = {RequestMethod.GET})
    public void addRpPreFeeRecordT(@RequestParam Date recordDate,@RequestParam String cityCode, @RequestParam String productCode,@RequestParam String writeOffTypeCode,
                                   @RequestParam Double writeOffFee, @RequestParam String recordOperator ){
        RpPreFeeRecordT rpPreFeeRecordT =new RpPreFeeRecordT();
        rpPreFeeRecordT.setRecordDate(recordDate);
        rpPreFeeRecordT.setCityCode(cityCode);
        rpPreFeeRecordT.setProductCode(productCode);
        rpPreFeeRecordT.setWriteOffFee(writeOffFee);
        rpPreFeeRecordT.setWriteOffTypeCode(writeOffTypeCode);
        rpPreFeeRecordT.setRecordOperator(recordOperator);
        rpPreFeeRecordTMapper.addRpPreFeeRecordT(rpPreFeeRecordT);
        System.out.println("成功添加一条预存转录");
    }

    //删除预存转收入
    @RequestMapping(value = "/deleteRpPreFeeRecordT",method = {RequestMethod.GET})
    public void deleteRpPreFeeRecordT(@RequestParam int[] ids){
        rpPreFeeRecordTMapper.deleteRpPreFeeRecordT(ids);
        System.out.println("成功删除预存转收入");
    }

    //更新一条预存转录信息
    @RequestMapping(value = "/updateRpPreFeeRecordT",method = {RequestMethod.GET})
    public void updateRpPreFeeRecordT(@RequestParam(required = false) int ID,@RequestParam(required = false) Date recordDate,@RequestParam(required = false) String cityCode, @RequestParam(required = false) String productCode,
                                      @RequestParam(required = false) String writeOffTypeCode, @RequestParam(required = false) Double writeOffFee, @RequestParam(required = false) String recordOperator,
                                      @RequestParam(required = false) String checkStatus ,@RequestParam(required = false) String checkPerson,@RequestParam(required = false) Date checkTime
                                      ){
        RpPreFeeRecordT rpPreFeeRecordT =new RpPreFeeRecordT();
        rpPreFeeRecordT.setID(ID);
        rpPreFeeRecordT.setRecordDate(recordDate);
        rpPreFeeRecordT.setCityCode(cityCode);
        rpPreFeeRecordT.setProductCode(productCode);
        rpPreFeeRecordT.setWriteOffFee(writeOffFee);
        rpPreFeeRecordT.setWriteOffTypeCode(writeOffTypeCode);
        rpPreFeeRecordT.setRecordOperator(recordOperator);
        rpPreFeeRecordT.setCheckPerson(checkPerson);
        rpPreFeeRecordT.setCheckTime(checkTime);
        rpPreFeeRecordT.setCheckStatus(checkStatus);
        rpPreFeeRecordTMapper.updateRpPreFeeRecordT(rpPreFeeRecordT);
        System.out.println("成功更新一条预存转录");
    }



}
