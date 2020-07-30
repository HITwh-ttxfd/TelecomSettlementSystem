package com.backend.entity;

import java.util.Date;

/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:通知单统一表
 */
public class rpBusinessFeeRecordT {
    String ID;                   //序号
    String productCode;          //产品编码
    String cityCode;             //城市编码
    String businessTypeCode;     //通知单类型编码
    Date business_record_date;   //营业收款日期
    double businessFee;          //营业收入金额
    String recordOperator;       //录入人员
    String checkPerson;          //稽核人员
    Date checkTime;              //稽核时间
    String checkStatus;          //稽核状态

    public rpBusinessFeeRecordT() {
    }

    public rpBusinessFeeRecordT(String ID, String productCode, String cityCode, String businessTypeCode, Date business_record_date, double businessFee, String recordOperator, String checkPerson, Date checkTime, String checkStatus) {
        this.ID = ID;
        this.productCode = productCode;
        this.cityCode = cityCode;
        this.businessTypeCode = businessTypeCode;
        this.business_record_date = business_record_date;
        this.businessFee = businessFee;
        this.recordOperator = recordOperator;
        this.checkPerson = checkPerson;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getBusinessTypeCode() {
        return businessTypeCode;
    }

    public void setBusinessTypeCode(String businessTypeCode) {
        this.businessTypeCode = businessTypeCode;
    }

    public Date getBusiness_record_date() {
        return business_record_date;
    }

    public void setBusiness_record_date(Date business_record_date) {
        this.business_record_date = business_record_date;
    }

    public double getBusinessFee() {
        return businessFee;
    }

    public void setBusinessFee(double businessFee) {
        this.businessFee = businessFee;
    }

    public String getRecordOperator() {
        return recordOperator;
    }

    public void setRecordOperator(String recordOperator) {
        this.recordOperator = recordOperator;
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

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "rpBusinessFeeRecordT{" +
                "ID='" + ID + '\'' +
                ", productCode='" + productCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", businessTypeCode='" + businessTypeCode + '\'' +
                ", business_record_date=" + business_record_date +
                ", businessFee=" + businessFee +
                ", recordOperator='" + recordOperator + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime=" + checkTime +
                ", checkStatus='" + checkStatus + '\'' +
                '}';
    }
}
