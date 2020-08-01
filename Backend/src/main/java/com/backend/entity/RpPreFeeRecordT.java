package com.backend.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:预存转统一表
 */
public class RpPreFeeRecordT {
    private int ID;                //序号
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date recordDate;          //销账日期
    private String cityCode;          //城市编码
    private String productCode;       //产品编码
    private String writeOffTypeCode;  //销账类型编码
    private Double writeOffFee;       //销帐金额
    private String recordOperator;    //录入人员
    private String checkStatus;        //稽核状态
    private String checkPerson;       //稽核人
    private Date checkTime;            //稽核时间

    private RpCityCodeT rpCityCodeT;
    private RpProductCodeT rpProductCodeT;
    private RpWriteOffTypeCodeT rpWriteOffTypeCodeT;

    public void setWriteOffFee(Double writeOffFee) {
        this.writeOffFee = writeOffFee;
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

    public RpWriteOffTypeCodeT getRpWriteOffTypeCodeT() {
        return rpWriteOffTypeCodeT;
    }

    public void setRpWriteOffTypeCodeT(RpWriteOffTypeCodeT rpWriteOffTypeCodeT) {
        this.rpWriteOffTypeCodeT = rpWriteOffTypeCodeT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
