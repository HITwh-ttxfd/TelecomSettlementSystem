package com.backend.mapper;


import com.backend.entity.RpNetBalanceRecordT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpNetBalanceRecordTMapper {

    public List<RpNetBalanceRecordT> selectAllRpNetBalanceRecordT();

}
