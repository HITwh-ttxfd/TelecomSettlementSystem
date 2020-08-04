package com.backend.mapper;
import com.backend.entity.RpAccountTypeCodeT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:孙宝臻
 * date:2020-8-4
 * purpose:出帐收入编码
 * requirement: 传回对应关系
 */
@Repository
@Mapper
public interface RpAccountTypeCodeTMapper {
    public List<RpAccountTypeCodeT>  selectAllRpAccountTypeCodeT();
}
