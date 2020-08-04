package com.backend.controller;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:通知单类型编码
 */
import com.backend.entity.RpBusinessFeeTypeCodeT;
import com.backend.entity.RpProductCodeT;
import com.backend.mapper.RpBusinessFeeTypeCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RpBusinessFeeTypeCodeT")
public class RpBusinessFeeTypeCodeTController {
    @Autowired
    RpBusinessFeeTypeCodeTMapper rpBusinessFeeTypeCodeTMapper;

    @RequestMapping(value = "/selectRpBusinessFeeTypeCodeT",method = {RequestMethod.GET})
    public List<RpBusinessFeeTypeCodeT> selectAllRpBusinessFeeTypeCodeT(){
        System.out.println("成功找到所有通知单类型编码");
        return rpBusinessFeeTypeCodeTMapper.selectAllRpBusinessFeeTypeCodeT();
    }
}
