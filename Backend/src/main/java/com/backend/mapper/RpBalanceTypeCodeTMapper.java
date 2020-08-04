package com.backend.mapper;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:结算类型编码类型参数管理表
 */
import com.backend.entity.RpBalanceSpCodeT;
import com.backend.entity.RpBalanceTypeCodeT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpBalanceTypeCodeTMapper {
    public List<RpBalanceTypeCodeT> selectAllRpBalanceTypeCodeT();
}
