package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:出账收入类型编码参数管理表
 */

public class RpAccountTypeCodeT {
    private String accountTypeCode;//出账收入类型编码
    private String accountTypeName;//出账收入名称

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
