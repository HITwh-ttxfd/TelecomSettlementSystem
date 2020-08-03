package com.backend.mapper;
/**
 * author:万宇成
 * date:2020-8-3
 * purpose:产品编码
 */
import com.backend.entity.RpCityCodeT;
import com.backend.entity.RpProductCodeT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpProductCodeTMapper {

    public List<RpProductCodeT> selectAllRpProductCodeT();


}
