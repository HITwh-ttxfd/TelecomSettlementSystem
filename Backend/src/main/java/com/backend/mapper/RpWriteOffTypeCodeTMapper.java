package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-8-03
 * purpose:销账类型编码
 */
import com.backend.entity.RpProductCodeT;
import com.backend.entity.RpWriteOffTypeCodeT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpWriteOffTypeCodeTMapper {
    public List<RpWriteOffTypeCodeT> selectAllRpWriteOffTypeCodeT();
}
