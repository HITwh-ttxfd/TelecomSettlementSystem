package com.backend.form;

import org.springframework.web.bind.annotation.RequestParam;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:网间收入查询参数表单
 */
import java.sql.Date;

public class RpNetBalanceRecordTSelectForm {
    private Date balanceMonth;
    private String cityCode;
    private String productCode;
    private String balanceSpCode;
    private String balanceTypeCode;
    private String checkStatus;

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
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
}
