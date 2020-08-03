package com.backend.form;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:通知单参数表单
 */
import java.sql.Date;

public class RpBusinessFeeRecordTSelectForm {
   private String cityCode;
   private String productCode;
   private String businessFeeTypeCode;
   private Date businessRecordDate;

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

    public String getBusinessFeeTypeCode() {
        return businessFeeTypeCode;
    }

    public void setBusinessFeeTypeCode(String businessFeeTypeCode) {
        this.businessFeeTypeCode = businessFeeTypeCode;
    }

    public Date getBusinessRecordDate() {
        return businessRecordDate;
    }

    public void setBusinessRecordDate(Date businessRecordDate) {
        this.businessRecordDate = businessRecordDate;
    }
}
