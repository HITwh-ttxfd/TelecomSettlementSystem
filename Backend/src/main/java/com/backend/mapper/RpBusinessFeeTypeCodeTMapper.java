package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:通知单类型编码
 */
import com.backend.entity.RpBusinessFeeTypeCodeT;
import com.backend.entity.RpProductCodeT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RpBusinessFeeTypeCodeTMapper {

    public List<RpBusinessFeeTypeCodeT> selectAllRpBusinessFeeTypeCodeT();
}
