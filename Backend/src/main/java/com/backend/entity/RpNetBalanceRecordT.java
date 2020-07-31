package com.backend.entity;
/**
 * author:孙宝臻
 * date:2020-7-30
 * purpose:网间结算统一表
 */
import java.util.Date;

public class RpNetBalanceRecordT {
    private int ID;         //序号
    private Date balanceMonth; //结算月份
    private String cityCode;   //城市编码
    private String productCode;//产品编码
    private String balanceSpCode;//结算运营商编码
    private String balanceTypeCode;//结算类型编码
    private String recordOperator;//录入人员
    private double balanceFee;  //结算金额
    private String checkStatus; //稽核状态
    private String checkPerson; //稽核人
    private Date checkTime;     //稽核时间

    private RpCityCodeT rpCityCodeT;
    private RpProductCodeT rpProductCodeT;
    private  RpBalanceTypeCodeT rpBalanceTypeCodeT;
    private  RpBalanceSpCodeT rpBalanceSpCodeT;


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

    public RpBalanceTypeCodeT getRpBalanceTypeCodeT() {
        return rpBalanceTypeCodeT;
    }

    public void setRpBalanceTypeCodeT(RpBalanceTypeCodeT rpBalanceTypeCodeT) {
        this.rpBalanceTypeCodeT = rpBalanceTypeCodeT;
    }

    public RpBalanceSpCodeT getRpBalanceSpCodeT() {
        return rpBalanceSpCodeT;
    }

    public void setRpBalanceSpCodeT(RpBalanceSpCodeT rpBalanceSpCodeT) {
        this.rpBalanceSpCodeT = rpBalanceSpCodeT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
