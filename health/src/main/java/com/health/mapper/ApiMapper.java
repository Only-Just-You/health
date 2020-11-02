package com.health.mapper;

import com.health.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiMapper {
    List<User> getUser(@Param("user") User user);
    void setUser(@Param("user") User user);
    List<Integer> getUserName(@Param("user") User user);
}
