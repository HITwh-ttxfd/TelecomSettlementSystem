package com.backend.form;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:预存转收入查询参数表单
 */
import java.sql.Date;

public class RpPreFeeRecordTSelectFrom {
    private  Date recordDate;
    private  String cityCode;
    private  String productCode;
    private  String writeOffTypeCode;

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
}
