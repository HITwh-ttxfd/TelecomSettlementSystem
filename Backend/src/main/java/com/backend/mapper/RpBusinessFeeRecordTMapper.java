package com.backend.mapper;


import com.backend.entity.RpBusinessFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpBusinessFeeRecordTMapper {

    // 根据查询条件来获取查询结果
    public List<RpBusinessFeeRecordT> selectAllRpBusinessFeeRecordT();

    //增加一条网间收入记录
    public void addRpBusinessFeeRecordT(RpBusinessFeeRecordT rpBusinessFeeRecordT);


}
