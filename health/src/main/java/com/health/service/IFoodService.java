package com.health.service;

import com.health.entity.Food;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IFoodService {
    List<Food> getFood(Integer id);
    void addFood(Food food, Integer id);
    void addImage(String path, Integer id);
}
