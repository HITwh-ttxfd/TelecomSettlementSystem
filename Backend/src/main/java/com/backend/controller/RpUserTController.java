package com.backend.controller;

/**
 * author:孙宝臻
 * date:8-2
 * purpose:用户类服务
 * tips:测试用url在xml里面
 */

import com.backend.entity.RpUserT;
import com.backend.mapper.RpUserTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/RpUserT")
public class RpUserTController {
    @Autowired
    RpUserTMapper rpUserTMapper;

    //新建用户    除了uesrID，其他都要传 ,返回1表明成功创建账号
    @RequestMapping(value = "/createRpUserT",method = {RequestMethod.GET})
    public int createRpUserT( @RequestParam String userName, @RequestParam String passWord,
                              @RequestParam String tureName,@RequestParam String sex, @RequestParam double age ,
                              @RequestParam int roleRight,@RequestParam String locationNo, @RequestParam String dept,
                              @RequestParam String email, @RequestParam String vipRight){
        RpUserT rpUserT = new RpUserT();
        String userID;
        do {
            //首先，生成随机ID
            userID = getRandom2(8);
            System.out.println(userID);
            rpUserT.setUserID(userID);
            //查询数据库里面是否有，有就继续随机生成，没有就应用
            rpUserT = rpUserTMapper.loginRpUserT(rpUserT);
        }while(rpUserT!=null);
        //赋值
        RpUserT rpUserT1=new RpUserT(userID, userName,passWord,tureName, sex, age, roleRight,  locationNo, dept,email,vipRight);
        rpUserTMapper.createRpUserT(rpUserT1);
        System.out.println("成功创建帐户");
        return 1;
    }

    //密码校验   检验成功返回1，密码错误返回0，无此帐号返回-1
    @RequestMapping(value = "/loginRpUserT",method = {RequestMethod.GET})
    public int loginRpUserT(@RequestParam String userID, @RequestParam String passWord){
        RpUserT rpUserT=new RpUserT();
        rpUserT.setUserID(userID);
        rpUserT=rpUserTMapper.loginRpUserT(rpUserT);
        System.out.println("成功密码校验");
        if(rpUserT==null)
            return -1;
        System.out.println("密码为："+rpUserT.getPassWord());
        System.out.println("传输的密码为："+passWord);
        System.out.println(rpUserT.getPassWord()==passWord);
        if(rpUserT.getPassWord().equals(passWord))
            return 1;
        return 0;
    }

    //获取用户权限信息       需要传入userID   权限信息在改后的“改-数据库详细设计”
    @RequestMapping(value = "/roleRight",method = {RequestMethod.GET})
    public int getRoleRight(@RequestParam String userID){
        RpUserT rpUserT=new RpUserT();
        rpUserT.setUserID(userID);
        rpUserT=rpUserTMapper.loginRpUserT(rpUserT);
        return rpUserT.getRoleRight();
    }

    //获取用户信息       需要传入userID
    @RequestMapping(value = "/getRpUserT",method = {RequestMethod.GET})
    public RpUserT getRpUserT(@RequestParam String userID){
        RpUserT rpUserT=new RpUserT();
        rpUserT.setUserID(userID);
        rpUserT=rpUserTMapper.loginRpUserT(rpUserT);
        System.out.println("结果："+rpUserT.toString());
        return rpUserT;
    }

    //测试
    @RequestMapping(value = "/test",method = {RequestMethod.GET})
    public int test(){
        System.out.println("成功找到网间通知单收入");
        return 1;
    }

    //用于产生随机数，也就是ID，8位
    public static String getRandom2(int len) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }
}
