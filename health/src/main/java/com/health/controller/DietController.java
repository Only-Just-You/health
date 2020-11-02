package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Diet;
import com.health.entity.User;
import com.health.service.IDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@RestController
@RequestMapping("diet")
public class DietController {
    @Autowired
    public IDietService dietServiceimpl;
    @RequestMapping(value = "/today",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Diet> today(HttpSession session){
        ServerResponse<Diet> response=null;
//        User user = (User)session.getAttribute("user");

        Integer id =(Integer)session.getAttribute("id");


        if(id!=null)
        {
           Diet diet = dietServiceimpl.getDiet(id).get(0);


            response = new ServerResponse<Diet>(200,diet);
            response.setMessage("成功");
            response.setResult(true);


        }
        else {
            response = new ServerResponse<Diet>(10,"用户未登录,请登录");
        }


        return response;
    }

}
