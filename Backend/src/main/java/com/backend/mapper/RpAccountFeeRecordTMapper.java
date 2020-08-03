package com.backend.mapper;

import com.backend.entity.RpAccountFeeRecordT;
import com.backend.entity.RpNetBalanceRecordT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:孙宝臻
 * date:2020-8-2
 * purpose:出帐统一表mapper
 * requirement: 出帐收入的批量导入、录入、修改、删除和查询
 */
@Repository
@Mapper
public interface RpAccountFeeRecordTMapper {
    //增加一条出帐收入记录（也可以通过循环完成批量导入）
    public void addRpAccountFeeRecordT(RpAccountFeeRecordT rpAccountFeeRecordT);

    // 修改出账收入记录
    public void changeRpAccountFeeRecordT(RpAccountFeeRecordT rpAccountFeeRecordT);

    //批量删除出账收入
    public void  deleteRpNetBalanceRecordT(int[] ids);

    // 根据查询条件来获取查询结果
    public List<RpAccountFeeRecordT> selectAllRpAccountFeeRecordT(RpAccountFeeRecordT rpAccountFeeRecordT);

}
