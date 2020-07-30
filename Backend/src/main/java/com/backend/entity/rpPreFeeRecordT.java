package com.backend.entity;

import java.util.Date;

/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:预存转统一表
 */
public class rpPreFeeRecordT {
    String ID;                //序号
    Date recordDate;          //销账日期
    String cityCode;          //城市编码
    String productCode;       //产品编码
    String writeOffTypeCode;  //销账类型编码
    double writeOffFee;       //销帐金额
    String recordOperator;    //录入人员
    String checkStatus;        //稽核状态
    String checkPerson;       //稽核人
    Date checkTime;            //稽核时间

    public rpPreFeeRecordT() {
    }

    public rpPreFeeRecordT(String ID, Date recordDate, String cityCode, String productCode, String writeOffTypeCode, double writeOffFee, String recordOperator, String checkStatus, String checkPerson, Date checkTime) {
        this.ID = ID;
        this.recordDate = recordDate;
        this.cityCode = cityCode;
        this.productCode = productCode;
        this.writeOffTypeCode = writeOffTypeCode;
        this.writeOffFee = writeOffFee;
        this.recordOperator = recordOperator;
        this.checkStatus = checkStatus;
        this.checkPerson = checkPerson;
        this.checkTime = checkTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
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

    public String getWriteOffTypeCode() {
        return writeOffTypeCode;
    }

    public void setWriteOffTypeCode(String writeOffTypeCode) {
        this.writeOffTypeCode = writeOffTypeCode;
    }

    public double getWriteOffFee() {
        return writeOffFee;
    }

    public void setWriteOffFee(double writeOffFee) {
        this.writeOffFee = writeOffFee;
    }

    public String getRecordOperator() {
        return recordOperator;
    }

    public void setRecordOperator(String recordOperator) {
        this.recordOperator = recordOperator;
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
        return "rpPreFeeRecordT{" +
                "ID='" + ID + '\'' +
                ", recordDate=" + recordDate +
                ", cityCode='" + cityCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", writeOffTypeCode='" + writeOffTypeCode + '\'' +
                ", writeOffFee=" + writeOffFee +
                ", recordOperator='" + recordOperator + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime=" + checkTime +
                '}';
    }
}
