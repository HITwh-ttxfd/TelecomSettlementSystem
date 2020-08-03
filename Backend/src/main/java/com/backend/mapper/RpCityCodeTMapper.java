package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-7-31
 * purpose:网间结算录入Mapper
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
