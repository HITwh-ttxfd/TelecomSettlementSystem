package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:网间结算录入Mapper
 */

import com.backend.entity.RpBusinessFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import com.backend.form.RpNetBalanceRecordTSelectForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpNetBalanceRecordTMapper {
    //增加一条网间收入记录
    public void addRpNetBalanceRecordT(RpNetBalanceRecordT rpNetBalanceRecordT);

    // 根据查询条件来获取查询结果
    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT(RpNetBalanceRecordTSelectForm rpNetBalanceRecordTSelectForm);

    //批量删除网间收入
    public void  deleteRpNetBalanceRecordT(int[] ids);

    //更新网间收入
    public void updateRpNetBalanceRecordT(RpNetBalanceRecordT rpNetBalanceRecordT);

}
