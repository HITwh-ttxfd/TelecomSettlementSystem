package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:产品编号参数管理表
 */


public class RpProductCodeT {
    private String productCode;//产品编码
    private String productName;//产品名称
    private String useFlag;//是否使用
    private String useAccount;//是否出账收入
    private String useCardSale;//是否卡销售
    private String useBalance;//是否网间结算
    private String usePreFee;//是否预存转收
    private String useBusinessFee;//是否通知单

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    public String getUseAccount() {
        return useAccount;
    }

    public void setUseAccount(String useAccount) {
        this.useAccount = useAccount;
    }

    public String getUseCardSale() {
        return useCardSale;
    }

    public void setUseCardSale(String useCardSale) {
        this.useCardSale = useCardSale;
    }

    public String getUseBalance() {
        return useBalance;
    }

    public void setUseBalance(String useBalance) {
        this.useBalance = useBalance;
    }

    public String getUsePreFee() {
        return usePreFee;
    }

    public void setUsePreFee(String usePreFee) {
        this.usePreFee = usePreFee;
    }

    public String getUseBusinessFee() {
        return useBusinessFee;
    }

    public void setUseBusinessFee(String useBusinessFee) {
        this.useBusinessFee = useBusinessFee;
    }
}
