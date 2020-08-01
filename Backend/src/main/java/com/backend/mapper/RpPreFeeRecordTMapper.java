package com.backend.mapper;

import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:万宇成
 * date:2020-8-1
 * purpose:网间结算录入Mapper
 */

@Mapper
public interface RpPreFeeRecordTMapper {

    // 根据查询条件来获取查询结果
    public List<RpPreFeeRecordT> selectAllRpPreFeeRecordT();

    //增加一条预存转录记录
    public void addRpPreFeeRecordT(RpPreFeeRecordT rpPreFeeRecordT);


}