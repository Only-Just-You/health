package com.health.mapper;

import com.health.entity.Userweight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface UserweightMapper{
    List<Userweight> getWeight(@Param("id") Integer id);
}
