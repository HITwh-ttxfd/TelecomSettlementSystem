package com.backend.entity;
/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:网间结算统一表
 */
import java.util.Date;

public class rpNetBalanceRecordT {
    String ID;         //序号
    Date balanceMonth; //结算月份
    String cityCode;   //城市编码
    String productCode;//产品编码
    String balanceSpCode;//结算运营商编码
    String balanceTypeCode;//结算类型编码
    String recordOperator;//录入人员
    double balanceFee;  //结算金额
    String checkStatus; //稽核状态
    String checkPerson; //稽核人
    Date checkTime;     //稽核时间

    public rpNetBalanceRecordT() {
    }

    public rpNetBalanceRecordT(String ID, Date balanceMonth, String cityCode, String productCode, String balanceSpCode, String balanceTypeCode, String recordOperator, double balanceFee, String checkStatus, String checkPerson, Date checkTime) {
        this.ID = ID;
        this.balanceMonth = balanceMonth;
        this.cityCode = cityCode;
        this.productCode = productCode;
        this.balanceSpCode = balanceSpCode;
        this.balanceTypeCode = balanceTypeCode;
        this.recordOperator = recordOperator;
        this.balanceFee = balanceFee;
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

    public Date getBalanceMonth() {
        return balanceMonth;
    }

    public void setBalanceMonth(Date balanceMonth) {
        this.balanceMonth = balanceMonth;
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

    public String getBalanceSpCode() {
        return balanceSpCode;
    }

    public void setBalanceSpCode(String balanceSpCode) {
        this.balanceSpCode = balanceSpCode;
    }

    public String getBalanceTypeCode() {
        return balanceTypeCode;
    }

    public void setBalanceTypeCode(String balanceTypeCode) {
        this.balanceTypeCode = balanceTypeCode;
    }

    public String getRecordOperator() {
        return recordOperator;
    }

    public void setRecordOperator(String recordOperator) {
        this.recordOperator = recordOperator;
    }

    public double getBalanceFee() {
        return balanceFee;
    }

    public void setBalanceFee(double balanceFee) {
        this.balanceFee = balanceFee;
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
        return "rpNetBalanceRecordT{" +
                "ID='" + ID + '\'' +
                ", balanceMonth=" + balanceMonth +
                ", cityCode='" + cityCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", balanceSpCode='" + balanceSpCode + '\'' +
                ", balanceTypeCode='" + balanceTypeCode + '\'' +
                ", recordOperator='" + recordOperator + '\'' +
                ", balanceFee=" + balanceFee +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkTime=" + checkTime +
                '}';
    }
}
