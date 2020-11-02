package com.health.service.impl;

import com.health.entity.Food;
import com.health.mapper.FoodMapper;
import com.health.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
public class FoodServiceImpl implements IFoodService {
    @Resource
    public FoodMapper foodMapper;
    @Override
    public List<Food> getFood(Integer id) {
        return foodMapper.getFood(id);
    }

    @Override
    public void addFood(Food food, Integer id) {
        foodMapper.addFood(food, id);
    }

    @Override
    public void addImage(String path, Integer id) {
        foodMapper.addImage(path, id);
    }

}
