package com.backend.controller;


import com.backend.entity.RpNetBalanceRecordT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RpNetBalanceRecordTController")
public class RpNetBalanceRecordTController {
    @Autowired
    RpNetBalanceRecordT rpNetBalanceRecordT;

    @RequestMapping(value = "/selectAllCity",method = {RequestMethod.GET})


}
