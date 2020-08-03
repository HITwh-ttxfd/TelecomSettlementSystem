package com.backend.mapper;

/**
 * author:万宇成
 * date:2020-8-1
 * purpose:结算运营商编码类型参数管理表
 */

import com.backend.entity.RpBalanceSpCodeT;
import com.backend.entity.RpBusinessFeeTypeCodeT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpBalanceSpCodeTMapper {
    public List<RpBalanceSpCodeT>  selectAllRpBalanceSpCodeT();

}
