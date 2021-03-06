package com.backend.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:通知单统一表
 */
public class RpBusinessFeeRecordT {
    private int ID;                   //序号
    private  String productCode;          //产品编码
    private  String cityCode;             //城市编码
    private String businessFeeTypeCode;     //通知单类型编码
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date businessRecordDate;   //营业收款日期
    private Double businessFee;          //营业收入金额
    private String recordOperator;       //录入人员
    private String checkPerson;          //稽核人员
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date checkTime;              //稽核时间
    private  String checkStatus;          //稽核状态

    private RpCityCodeT rpCityCodeT;
    private RpProductCodeT rpProductCodeT;
    private RpBusinessFeeTypeCodeT rpBusinessFeeTypeCodeT;


    public Date getBusinessRecordDate() {
        return businessRecordDate;
    }

    public void setBusinessRecordDate(Date businessRecordDate) {
        this.businessRecordDate = businessRecordDate;
    }

    public RpCityCodeT getRpCityCodeT() {
        return rpCityCodeT;
    }

    public void setRpCityCodeT(RpCityCodeT rpCityCodeT) {
        this.rpCityCodeT = rpCityCodeT;
    }

    public RpProductCodeT getRpProductCodeT() {
        return rpProductCodeT;
    }

    public void setRpProductCodeT(RpProductCodeT rpProductCodeT) {
        this.rpProductCodeT = rpProductCodeT;
    }

    public RpBusinessFeeTypeCodeT getRpBusinessFeeTypeCodeT() {
        return rpBusinessFeeTypeCodeT;
    }

    public void setRpBusinessFeeTypeCodeT(RpBusinessFeeTypeCodeT rpBusinessFeeTypeCodeT) {
        this.rpBusinessFeeTypeCodeT = rpBusinessFeeTypeCodeT;
    }

    public String getBusinessFeeTypeCode() {
        return businessFeeTypeCode;
    }

    public void setBusinessFeeTypeCode(String businessFeeTypeCode) {
        this.businessFeeTypeCode = businessFeeTypeCode;
    }

    public void setBusinessFee(Double businessFee) {
        this.businessFee = businessFee;
    }

    public Double getBusinessFee() {
        return businessFee;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
                ", businessTypeCode='" + businessFeeTypeCode + '\'' +
                ", businessRecordDate" + businessRecordDate +
                ", businessFee=" + businessFee +
                ", recordOperator='" + recordOperator + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime=" + checkTime +
                ", checkStatus='" + checkStatus + '\'' +
                '}';
    }
}
