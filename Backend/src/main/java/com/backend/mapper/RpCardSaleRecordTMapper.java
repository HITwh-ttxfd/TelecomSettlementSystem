package com.backend.mapper;
import com.backend.entity.RpCardSaleRecordT;
import com.backend.entity.RpPreFeeRecordT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:孙宝臻
 * date:2020-8-3
 * purpose:卡销售统一表mapper
 * requirement: 卡销售收入的批量导入、录入、修改、删除和查询
 */
@Repository
@Mapper
public interface RpCardSaleRecordTMapper {
    //增加一条卡销售收入记录（也可以通过循环完成批量导入）
    public void addRpCardSaleRecordT(RpCardSaleRecordT rpCardSaleRecordT);

    // 修改卡销售收入记录
    public void changeRpCardSaleRecordT(RpCardSaleRecordT rpCardSaleRecordT);

    //批量删除卡销售收入
    public void  deleteRpCardSaleRecordT(int[] ids);

    // 根据查询条件来获取查询结果
    public List<RpCardSaleRecordT> selectAllRpCardSaleRecordT(RpCardSaleRecordT rpCardSaleRecordT);

    // 根据查询条件来获取查询结果
    public List<RpCardSaleRecordT> getAllRpCardSaleRecordT();
}
