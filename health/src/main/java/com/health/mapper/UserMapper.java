package com.health.mapper;

import com.health.entity.User;
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
@Mapper
public interface UserMapper {

    boolean setUser(@Param("user")User user, @Param("id") Integer id);
    void addImage(@Param("path") String path, @Param("id") Integer id);
}
