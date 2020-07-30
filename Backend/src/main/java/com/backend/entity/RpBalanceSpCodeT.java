package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:结算运营商编码类型参数管理表
 */
public class RpBalanceSpCodeT {
    private String balanceSpCode;//结算运营商编码
    private String balanceSpName;//结算运营商名称

    public String getBalanceSpCode() {
        return balanceSpCode;
    }

    public void setBalanceSpCode(String balanceSpCode) {
        this.balanceSpCode = balanceSpCode;
    }

    public String getBalanceSpName() {
        return balanceSpName;
    }

    public void setBalanceSpName(String balanceSpName) {
        this.balanceSpName = balanceSpName;
    }
}
