package com.health.mapper;

import com.health.entity.Userinf;
import org.apache.ibatis.annotations.Mapper;
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
public interface UserinfMapper {

    List<Userinf> getInf(@Param("id")Integer id);
}
