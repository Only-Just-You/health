package com.health.mapper;

import com.health.entity.Food;
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
public interface FoodMapper {

    List<Food> getFood(@Param("id")Integer id);
    void addFood(@Param("food") Food food, @Param("id")Integer id);
    void addImage(@Param("path") String path, @Param("id") Integer id);
}
