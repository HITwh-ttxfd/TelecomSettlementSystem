package com.backend.controller;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:销账类型编码
 */
import com.backend.entity.RpProductCodeT;
import com.backend.entity.RpWriteOffTypeCodeT;
import com.backend.mapper.RpWriteOffTypeCodeTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RpWriteOffTypeCodeT")
public class RpWriteOffTypeCodeTController {
    @Autowired
    RpWriteOffTypeCodeTMapper rpWriteOffTypeCodeTMapper;

    @RequestMapping(value = "/selectRpWriteOffTypeCodeT",method = {RequestMethod.GET})
    public List<RpWriteOffTypeCodeT> selectAllRpProductCodeT(){
        System.out.println("成功找到所有销账类型编码");
        return rpWriteOffTypeCodeTMapper.selectAllRpWriteOffTypeCodeT();
    }

}
