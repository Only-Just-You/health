package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.entity.Meal;
import com.health.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@RestController
@RequestMapping("/food")

public class FoodController {
    @Autowired
    public IFoodService foodServiceimpl;
    @RequestMapping(value="/diet",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List> getDiet(HttpSession session){

        ServerResponse<List> response=null;
//        User user = (User)session.getAttribute("user");
        Integer id =(Integer)session.getAttribute("id");


        if(id!=null)
        {
            List<Meal> meals = new ArrayList<Meal>();
            for(int i = 0 ; i < 3 ; i++){
                Meal meal = new Meal();
                this.getFoods(meal);

                meals.add(meal);
            }
            System.out.println(meals);


            response = new ServerResponse<List>(200,meals);
            response.setMessage("成功");
            response.setResult(true);


        }
        else {
            response = new ServerResponse<List>(10,"用户未登录,请登录");
        }
        return response;
    }
    @RequestMapping(value = "/show",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Food> getFood(HttpSession session){
        ServerResponse<Food> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null) {
            List<Food> foods = foodServiceimpl.getFood(id);

            response = new ServerResponse<Food>(200, foods.get(0));
            response.setMessage("成功");
            response.setResult(true);

        }else{
            response = new ServerResponse<Food>(10, "用户未登录");
        }
        return response;
    }
    @RequestMapping(value = "add_self",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Food> addFood(HttpSession session, @RequestBody Food food) {
        ServerResponse<Food> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null) {
            foodServiceimpl.addFood(food, id);

            response = new ServerResponse<Food>(200, food);
            response.setMessage("成功");
            response.setResult(true);

        }else{
            response = new ServerResponse<Food>(10, "用户未登录");
        }
        return response;
    }
    void getFoods(Meal meal){  //生成随机食物
        meal.foods =new ArrayList<>();

        for(int  i = 0 ; i < 4 ; i ++)
        {
            int id = getRanFood();
            List<Food> list = foodServiceimpl.getFood(id);
            if (list.size() == 0 ) // 防止随机的食物的ID没有，进行判断
                continue;
            Food food = list.get(0);

            meal.foods.add(food);
            meal.tolCol+=food.getCol();
        }
    }
    static int getRanFood (){  //生成随机食物id
        Random rand = new Random();
        int i = rand.nextInt(1100)+1;
        return i;
    }

}

