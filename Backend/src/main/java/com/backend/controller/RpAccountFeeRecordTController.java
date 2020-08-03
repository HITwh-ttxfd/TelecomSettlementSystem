package com.backend.controller;

import com.backend.entity.RpAccountFeeRecordT;
import com.backend.mapper.RpAccountFeeRecordTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author:孙宝臻
 * date:8-2
 * purpose:出账收入表
 * tips:xml里面有测试用url，可以参考
 * functions:出账收入的录入、修改、删除、批量删除、导出、导入、查询、分页显示、JS校验
 * 出账收入归集、出账收入查询、稽核通过、稽核失败
 * 分析：
 * 录入1条以及多条   v
 * 查询多条    v
 * 删除1条以及多条   v
 * 修改1条   v
 * 分页显示
 */
@RestController

@RequestMapping("/RpAccountFeeRecordT")
public class RpAccountFeeRecordTController {
    @Autowired
    RpAccountFeeRecordTMapper rpAccountFeeRecordT;

//@RequestParam(required=false)
    //新建出账收入  除了ID，其他都需要  v  ***注意日期传的格式为string类型，形如2020-01-20
    @RequestMapping(value = "/createRpAccountFeeRecordT",method = {RequestMethod.GET})
    public void createRpAccountFeeRecordT(@RequestParam String cityCode, @RequestParam String productCode
            ,@RequestParam String accountFeeTypeCode,@RequestParam String accountRecordMonttemp,
            @RequestParam double accountFee,@RequestParam String accountOperator) throws ParseException {
        //修改日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date accountRecordMonth = sf.parse(accountRecordMonttemp);

        RpAccountFeeRecordT Rp=new RpAccountFeeRecordT(cityCode,productCode,accountFeeTypeCode,accountRecordMonth,accountFee,accountOperator);
        Rp.toString();
        rpAccountFeeRecordT.addRpAccountFeeRecordT(Rp);
        System.out.println("成功新建出账收入");
    }



    //修改出账收入记录  需要ID，别的随意
    //可以通过这个修改值，也可以通过这个修改稽核状态   v
    @RequestMapping(value = "/changeRpAccountFeeRecordT",method = {RequestMethod.GET})
    public void changeRpBusinessFeeRecordT(@RequestParam int ID,@RequestParam(required=false) String cityCode, @RequestParam(required=false) String productCode
            ,@RequestParam(required=false) String accountFeeTypeCode,@RequestParam(required=false) Date accountRecordMonth,
            @RequestParam(required=false) String accountFee,@RequestParam(required=false) String accountOperator,
            @RequestParam(required=false) String checkStatus,@RequestParam(required=false) String checkPerson,@RequestParam(required=false) Date checkTime){
        RpAccountFeeRecordT Rp=new RpAccountFeeRecordT();
        Rp.setID(ID);
        if(cityCode != null&&cityCode != "")
            Rp.setCityCode(cityCode);
        if(productCode != null&&productCode != "")
            Rp.setProductCode(productCode);
        if(accountFeeTypeCode != null&&accountFeeTypeCode != "")
            Rp.setAccountFeeTypeCode(accountFeeTypeCode);
        if(accountRecordMonth != null)
            Rp.setAccountRecordMonth(accountRecordMonth);
        if(accountFee != null )
            Rp.setAccountFee(Double.parseDouble( accountFee  ));
        if(accountOperator != null &&accountOperator != "")
            Rp.setAccountOperator(accountOperator);
        if(checkStatus != null&&checkStatus != "")
            Rp.setCheckStatus(checkStatus);
        if(checkPerson != null&&checkPerson != "")
            Rp.setCheckPerson(checkPerson);
        if(checkTime != null)
            Rp.setCheckTime(checkTime);
        rpAccountFeeRecordT.changeRpAccountFeeRecordT(Rp);
        System.out.println("成功修改出账收入");
    }

    //批量删除出账收入  需要一个ID数组，这个数组就是要删的ID数   v
    @RequestMapping(value = "/deleteRpNetBalanceRecordT",method = {RequestMethod.GET})
    public void deleteRpNetBalanceRecordT(@RequestParam int[] ids){
        rpAccountFeeRecordT.deleteRpNetBalanceRecordT(ids);
        System.out.println("成功批量删除出账收入");
    }

    //根据查询条件来获取查询结果  随便传条件，需要啥传啥  v
    @RequestMapping(value = "/selectAllRpAccountFeeRecordT",method = {RequestMethod.GET})
    public List<RpAccountFeeRecordT> selectAllRpAccountFeeRecordT(@RequestParam(required=false) String ID,@RequestParam(required=false) String cityCode, @RequestParam(required=false) String productCode
            ,@RequestParam(required=false) String accountFeeTypeCode,@RequestParam(required=false) Date accountRecordMonth,
                                              @RequestParam(required=false) String accountFee,@RequestParam(required=false) String accountOperator,
                                              @RequestParam(required=false) String checkStatus,@RequestParam(required=false) String checkPerson,@RequestParam(required=false) Date checkTime){
        RpAccountFeeRecordT Rp=new RpAccountFeeRecordT();
        if(ID != null&&ID != "")
            Rp.setID(Integer.parseInt(ID));
        if(cityCode != null&&cityCode != "")
            Rp.setCityCode(cityCode);
        if(productCode != null&&productCode != "")
            Rp.setProductCode(productCode);
        if(accountFeeTypeCode != null&&accountFeeTypeCode != "")
            Rp.setAccountFeeTypeCode(accountFeeTypeCode);
        if(accountRecordMonth != null)
            Rp.setAccountRecordMonth(accountRecordMonth);
        if(accountFee != null && accountFee!= "")
            Rp.setAccountFee(Double.parseDouble(accountFee));
        if(accountOperator != null &&accountOperator != "")
            Rp.setAccountOperator(accountOperator);
        if(checkStatus != null&&checkStatus != "")
            Rp.setCheckStatus(checkStatus);
        if(checkPerson != null&&checkPerson != "")
            Rp.setCheckPerson(checkPerson);
        if(checkTime != null)
            Rp.setCheckTime(checkTime);
        return rpAccountFeeRecordT.selectAllRpAccountFeeRecordT(Rp);
    }


    //查询所有出账收入，数据归集用
    @RequestMapping(value = "/getAllRpAccountFeeRecordT",method = {RequestMethod.GET})
    public List<RpAccountFeeRecordT> getAllRpAccountFeeRecordT(){
        return rpAccountFeeRecordT.getAllRpAccountFeeRecordT();
    }

    //测试
    @RequestMapping(value = "/test",method = {RequestMethod.GET})
    public int test(){
        System.out.println("成功找到出账通知单收入");
        return 1;
    }

}
