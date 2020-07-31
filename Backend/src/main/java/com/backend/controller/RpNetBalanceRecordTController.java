package com.backend.controller;


import com.backend.entity.RpNetBalanceRecordT;
import com.backend.mapper.RpNetBalanceRecordTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RpNetBalanceRecordTController")
public class RpNetBalanceRecordTController {
    @Autowired
    RpNetBalanceRecordTMapper rpNetBalanceRecordTMapper;


    @RequestMapping(value = "/selectAllRpNetBalanceRecordT",method = {RequestMethod.GET})
    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT(){
        return rpNetBalanceRecordTMapper.selectAllRpNetBalanceRecordT();
    }


}
