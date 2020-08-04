package com.backend.controller;
import com.backend.entity.RpCardSaleRecordT;
import com.backend.mapper.RpCardSaleRecordTMapper;
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
 * date:8-3
 * purpose:卡销售收入表
 * tips:
 * functions:卡销售收入的录入、修改、删除、批量删除、导出、导入、查询、分页显示、JS校验
 *
 */
@RestController
@RequestMapping("/RpCardSaleRecordT")
public class RpCardSaleRecordTController {
    @Autowired
    RpCardSaleRecordTMapper rpCardSaleRecordT;

    //新建卡销售收入  除了ID，其他都需要  v  ***注意日期传的格式为string类型，形如2020-01-20
    @RequestMapping(value = "/createRpCardSaleRecordT",method = {RequestMethod.GET})
    public void createAllRpCardSaleRecordT(@RequestParam String cityCode, @RequestParam String productCode
            , @RequestParam String saleDate,@RequestParam double discountRate,@RequestParam double cardSaleAmount
            ,@RequestParam double cardParValueFee,@RequestParam String recordOperator,@RequestParam String totalFee,@RequestParam Double discountFee) throws ParseException {
        //修改日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date temp = sf.parse(saleDate);

        RpCardSaleRecordT Rp=new RpCardSaleRecordT(cityCode,productCode,temp, discountRate,cardSaleAmount,cardParValueFee,recordOperator,totalFee,discountFee);
        rpCardSaleRecordT.addRpCardSaleRecordT(Rp);
        System.out.println("成功新建出账收入");
    }


    //修改卡销售收入记录  需要ID，别的随意
    //可以通过这个修改值，也可以通过这个修改稽核状态
    @RequestMapping(value = "/changeRpCardSaleRecordT",method = {RequestMethod.GET})
    public void changeRpCardSaleRecordT(@RequestParam  int ID,@RequestParam(required=false) String cityCode, @RequestParam(required=false) String productCode
            ,@RequestParam(required=false) String saleDate,@RequestParam(required=false) String discountRate,
            @RequestParam(required=false) String cardSaleAmount,@RequestParam(required=false) String cardParValueFee,
            @RequestParam(required=false) String recordOperator,@RequestParam(required=false) String totalFee,
            @RequestParam(required=false) String discountFee,
            @RequestParam(required=false) String checkStatus,@RequestParam(required=false) String checkPerson,@RequestParam(required=false) String checkTime) throws ParseException {
        RpCardSaleRecordT Rp=new RpCardSaleRecordT();
        Rp.setID(ID);
        //修改日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        if(cityCode != null&&cityCode != "")
            Rp.setCityCode(cityCode);
        if(productCode != null&&productCode != "")
            Rp.setProductCode(productCode);
        if(saleDate != null)
        {
            Date temp1 = sf.parse(saleDate);
            Rp.setSaleDate(temp1);
        }
        if(discountRate != null)
            Rp.setDiscountRate(Double.parseDouble(discountRate));
        if(cardSaleAmount != null)
            Rp.setCardSaleAmount(Double.parseDouble(cardSaleAmount));
        if(cardParValueFee != null)
            Rp.setCardParValueFee(Double.parseDouble(cardParValueFee));
        if(recordOperator != null&&recordOperator != "")
            Rp.setRecordOperator(recordOperator);
        if(totalFee != null&&totalFee != "")
            Rp.setTotalFee(totalFee);
        if(discountFee != null)
            Rp.setDiscountFee(Double.parseDouble(discountFee));
        if(checkStatus != null&&checkStatus != "")
            Rp.setCheckStatus(checkStatus);
        if(checkPerson != null&&checkPerson != "")
            Rp.setCheckPerson(checkPerson);
        if(checkTime != null)
        {
            Date temp2 = sf.parse(checkTime);
            Rp.setCheckTime(temp2);
        }
        rpCardSaleRecordT.changeRpCardSaleRecordT(Rp);
        System.out.println("成功修改出账收入");
    }

    //批量删除卡销售收入  需要一个ID数组，这个数组就是要删的ID数
    @RequestMapping(value = "/deleteRpCardSaleRecordT",method = {RequestMethod.GET})
    public void deleteRpCardSaleRecordT(@RequestParam int[] ids){
        rpCardSaleRecordT.deleteRpCardSaleRecordT(ids);
        System.out.println("成功批量删除出账收入");
    }

    //根据查询条件来获取查询结果  随便传条件，需要啥传啥
    @RequestMapping(value = "/selectAllRpCardSaleRecordT",method = {RequestMethod.GET})
    public List<RpCardSaleRecordT> selectAllRpCardSaleRecordT(@RequestParam(required=false) String ID,@RequestParam(required=false) String cityCode, @RequestParam(required=false) String productCode
            ,@RequestParam(required=false) String saleDate,@RequestParam(required=false) String discountRate,
                                                                  @RequestParam(required=false) String cardSaleAmount,@RequestParam(required=false) String cardParValueFee,
                                                                  @RequestParam(required=false) String recordOperator,@RequestParam(required=false) String totalFee,
                                                                  @RequestParam(required=false) String discountFee,
                                                                  @RequestParam(required=false) String checkStatus,@RequestParam(required=false) String checkPerson,@RequestParam(required=false) String checkTime) throws ParseException {
        RpCardSaleRecordT Rp=new RpCardSaleRecordT();
        //修改日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        if(ID != null)
            Rp.setID(Integer.parseInt( ID ));
        if(cityCode != null&&cityCode != "")
            Rp.setCityCode(cityCode);
        if(productCode != null&&productCode != "")
            Rp.setProductCode(productCode);
        if(saleDate != null)
        {
            Date temp1 = sf.parse(saleDate);
            Rp.setSaleDate(temp1);
        }
        if(discountRate != null)
            Rp.setDiscountRate(Double.parseDouble(discountRate ));
        if(cardSaleAmount != null)
            Rp.setCardSaleAmount(Double.parseDouble(cardSaleAmount));
        if(cardParValueFee != null)
            Rp.setCardParValueFee(Double.parseDouble(cardParValueFee));
        if(recordOperator != null&&recordOperator != "")
            Rp.setRecordOperator(recordOperator);
        if(totalFee != null&&totalFee != "")
            Rp.setTotalFee(totalFee);
        if(discountFee != null)
            Rp.setDiscountFee(Double.parseDouble(discountFee));
        if(checkStatus != null&&checkStatus != "")
            Rp.setCheckStatus(checkStatus);
        if(checkPerson != null&&checkPerson != "")
            Rp.setCheckPerson(checkPerson);
        if(checkTime != null)
        {
            Date temp2 = sf.parse(checkTime);
            Rp.setCheckTime(temp2);
        }
        return rpCardSaleRecordT.selectAllRpCardSaleRecordT(Rp);
    }

    //获取全部信息——数据归集用
    @RequestMapping(value = "/getAllRpCardSaleRecordT",method = {RequestMethod.GET})
    public List<RpCardSaleRecordT> getAllRpCardSaleRecordT()  {
        return rpCardSaleRecordT.getAllRpCardSaleRecordT();
    }

    //测试
    @RequestMapping(value = "/test",method = {RequestMethod.GET})
    public int test(){
        System.out.println("成功找到卡销售通知单收入");
        return 1;
    }
}
