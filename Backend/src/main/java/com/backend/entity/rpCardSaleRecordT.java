package com.backend.entity;

import java.util.Date;

/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:卡销售统一表
 */
public class rpCardSaleRecordT {
    String ID;                //序号
    String cityCode;           //城市编码
    String productCode;       //产品编码
    Date saleDate;            //录入日期
    double discountRate;      //折扣率
    double cardSaleAmount;    //卡销售数量
    double cardParValueFee;   //面值金额
    String recordOperator;    //录入人员
    String checkStatus;       //稽核状态
    String checkPerson;       //稽核人
    Date checkTime;           //稽核时间
    String totalFee;          //卡总金额
    Double discountFee;       //折扣后总金额

    public rpCardSaleRecordT() {
    }

    public rpCardSaleRecordT(String ID, String cityCode, String productCode, Date saleDate, double discountRate, double cardSaleAmount, double cardParValueFee, String recordOperator, String checkStatus, String checkPerson, Date checkTime, String totalFee, Double discountFee) {
        this.ID = ID;
        this.cityCode = cityCode;
        this.productCode = productCode;
        this.saleDate = saleDate;
        this.discountRate = discountRate;
        this.cardSaleAmount = cardSaleAmount;
        this.cardParValueFee = cardParValueFee;
        this.recordOperator = recordOperator;
        this.checkStatus = checkStatus;
        this.checkPerson = checkPerson;
        this.checkTime = checkTime;
        this.totalFee = totalFee;
        this.discountFee = discountFee;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getCardSaleAmount() {
        return cardSaleAmount;
    }

    public void setCardSaleAmount(double cardSaleAmount) {
        this.cardSaleAmount = cardSaleAmount;
    }

    public double getCardParValueFee() {
        return cardParValueFee;
    }

    public void setCardParValueFee(double cardParValueFee) {
        this.cardParValueFee = cardParValueFee;
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

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public Double getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    @Override
    public String toString() {
        return "rpCardSaleRecordT{" +
                "ID='" + ID + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", saleDate=" + saleDate +
                ", discountRate=" + discountRate +
                ", cardSaleAmount=" + cardSaleAmount +
                ", cardParValueFee=" + cardParValueFee +
                ", recordOperator='" + recordOperator + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime=" + checkTime +
                ", totalFee='" + totalFee + '\'' +
                ", discountFee=" + discountFee +
                '}';
    }

}
