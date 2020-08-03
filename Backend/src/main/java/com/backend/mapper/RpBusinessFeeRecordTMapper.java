package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-8-1
 * purpose:通知单Mapper
 */

import com.backend.entity.RpBusinessFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import com.backend.entity.RpPreFeeRecordT;
import com.backend.form.RpBusinessFeeRecordTSelectForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpBusinessFeeRecordTMapper {

    // 根据查询条件来获取查询结果
    public List<RpBusinessFeeRecordT> selectAllRpBusinessFeeRecordT(RpBusinessFeeRecordTSelectForm rpBusinessFeeRecordTSelectForm);

    //增加一条通知单记录
    public void addRpBusinessFeeRecordT(RpBusinessFeeRecordT rpBusinessFeeRecordT);

    //批量删除通知单
    public void  deleteRpBusinessFeeRecordT(int[] ids);

    //更新通知单
    public void updateRpBusinessFeeRecordT(RpBusinessFeeRecordT rpBusinessFeeRecordT);



}
