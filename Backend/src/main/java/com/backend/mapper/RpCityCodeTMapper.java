package com.backend.mapper;

import com.backend.entity.RpCityCodeT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpCityCodeTMapper {
    public List<RpCityCodeT> selectAll();

}
