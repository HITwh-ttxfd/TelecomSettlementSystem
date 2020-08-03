package com.backend.entity;
/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:出帐统一表
 */

import java.util.Date;

public class RpAccountFeeRecordT {
    private int ID;                  //序号
    private String cityCode;           //城市编码
    private String productCode;        //产品编码
    private String accountFeeTypeCode;//出账类型编码
    private Date accountRecordMonth;   //出账月份
    private double accountFee;          //出账金额
    private  String accountOperator;     //录入员工用户名
    private String checkStatus;         //稽核状态
    private String checkPerson;         //稽核人
    private  Date checkTime;           //稽核时间

    public RpAccountFeeRecordT() {
    }

    public RpAccountFeeRecordT(int ID, String cityCode, String productCode, String accountFeeTypeCode, Date accountRecordMonth, double accountFee, String accountOperator, String checkStatus, String checkPerson, Date checkTime) {
        this.ID = ID;
        this.cityCode = cityCode;
        this.productCode = productCode;
        this.accountFeeTypeCode = accountFeeTypeCode;
        this.accountRecordMonth = accountRecordMonth;
        this.accountFee = accountFee;
        this.accountOperator = accountOperator;
        this.checkStatus = checkStatus;
        this.checkPerson = checkPerson;
        this.checkTime = checkTime;
    }

    public RpAccountFeeRecordT(String cityCode, String productCode, String accountFeeTypeCode, Date accountRecordMonth, double accountFee, String accountOperator) {
        this.cityCode = cityCode;
        this.productCode = productCode;
        this.accountFeeTypeCode = accountFeeTypeCode;
        this.accountRecordMonth = accountRecordMonth;
        this.accountFee = accountFee;
        this.accountOperator = accountOperator;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAccountFeeTypeCode() {
        return accountFeeTypeCode;
    }

    public void setAccountFeeTypeCode(String accountFeeTypeCode) {
        this.accountFeeTypeCode = accountFeeTypeCode;
    }

    public Date getAccountRecordMonth() {
        return accountRecordMonth;
    }

    public void setAccountRecordMonth(Date accountRecordMonth) {
        this.accountRecordMonth = accountRecordMonth;
    }

    public double getAccountFee() {
        return accountFee;
    }

    public void setAccountFee(double accountFee) {
        this.accountFee = accountFee;
    }

    public String getAccountOperator() {
        return accountOperator;
    }

    public void setAccountOperator(String accountOperator) {
        this.accountOperator = accountOperator;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public String toString() {
        return "rpAccountFeeRecordT{" +
                "ID='" + ID + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", accountFeeTypeCode='" + accountFeeTypeCode + '\'' +
                ", accountRecordMonth=" + accountRecordMonth +
                ", accountFee=" + accountFee +
                ", accountOperator='" + accountOperator + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime='" + checkTime + '\'' +
                '}';
    }
}
