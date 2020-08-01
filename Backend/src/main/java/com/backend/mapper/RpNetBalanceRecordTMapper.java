package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:网间结算录入Mapper
 */

import com.backend.entity.RpNetBalanceRecordT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpNetBalanceRecordTMapper {
    //增加一条网间收入记录
    public void addRpNetBalanceRecordT(RpNetBalanceRecordT rpNetBalanceRecordT);

    // 根据查询条件来获取查询结果
    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT();

}