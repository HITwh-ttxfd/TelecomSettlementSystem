package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:通知单收入参数管理表
 */


public class RpBusinessFeeTypeCodeT {
    private  String businessFeeTypeCode;//通知单类型ID
    private  String businessFeeTypeName;//通知单类型名称

    public String getBusinessFeeTypeCode() {
        return businessFeeTypeCode;
    }

    public void setBusinessFeeTypeCode(String businessFeeTypeCode) {
        this.businessFeeTypeCode = businessFeeTypeCode;
    }

    public String getBusinessFeeTypeName() {
        return businessFeeTypeName;
    }

    public void setBusinessFeeTypeName(String businessFeeTypeName) {
        this.businessFeeTypeName = businessFeeTypeName;
    }
}
