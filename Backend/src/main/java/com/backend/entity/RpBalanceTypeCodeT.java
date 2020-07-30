package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:结算类型编码类型参数管理表
 */
public class RpBalanceTypeCodeT {
    private String balanceTypeCode;//结算类型编码
    private String balanceTypeName;//结算类型名称

    public String getBalanceTypeCode() {
        return balanceTypeCode;
    }

    public void setBalanceTypeCode(String balanceTypeCode) {
        this.balanceTypeCode = balanceTypeCode;
    }

    public String getBalanceTypeName() {
        return balanceTypeName;
    }

    public void setBalanceTypeName(String balanceTypeName) {
        this.balanceTypeName = balanceTypeName;
    }
}
