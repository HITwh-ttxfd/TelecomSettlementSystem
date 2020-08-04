package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:城市编码
 */
import com.backend.entity.RpCityCodeT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpCityCodeTMapper {
    public List<RpCityCodeT> selectAll();

}
