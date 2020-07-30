package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:销账类型编码参数管理表
 */

public class RpWriteOffTypeCodeT {
    private  String writeOffTypeCode;//销售类型ID
    private  String writeOffTypeName;//销售类型名称

    public String getWriteOffTypeCode() {
        return writeOffTypeCode;
    }

    public void setWriteOffTypeCode(String writeOffTypeCode) {
        this.writeOffTypeCode = writeOffTypeCode;
    }

    public String getWriteOffTypeName() {
        return writeOffTypeName;
    }

    public void setWriteOffTypeName(String writeOffTypeName) {
        this.writeOffTypeName = writeOffTypeName;
    }
}
