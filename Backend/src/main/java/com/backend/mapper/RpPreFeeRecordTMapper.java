package com.backend.mapper;

import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import com.backend.form.RpPreFeeRecordTSelectFrom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:万宇成
 * date:2020-8-1
 * purpose:预存转收入Mapper
 */

@Mapper
public interface RpPreFeeRecordTMapper {

    // 根据查询条件来获取查询结果
    public List<RpPreFeeRecordT> selectAllRpPreFeeRecordT(RpPreFeeRecordTSelectFrom rpPreFeeRecordTSelectFrom);

    //增加一条预存转收入记录
    public void addRpPreFeeRecordT(RpPreFeeRecordT rpPreFeeRecordT);

    //批量删除预存转收入
    public void  deleteRpPreFeeRecordT(int[] ids);

    //更新预存转收入
    public void updateRpPreFeeRecordT(RpPreFeeRecordT rpPreFeeRecordT);


}
