package com.backend.mapper;
/**
 * author:孙宝臻
 * date:2020-8-1
 * purpose:用户mapper
 */

import com.backend.entity.RpUserT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RpUserTMapper {
    //新建用户
    public void createRpUserT(RpUserT rpusert);
    //密码校验
    public RpUserT loginRpUserT(RpUserT rpusert);
}
