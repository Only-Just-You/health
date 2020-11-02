package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.User;
import com.health.entity.Userinf;
import com.health.service.IUserService;
import com.health.service.impl.UserinfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userServiceimpl;

    @RequestMapping(value="/setup",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUser(HttpSession session, @RequestBody User user){

        ServerResponse<User> response=null;
//        User user = (User)session.getAttribute("user");
        Integer id =(Integer)session.getAttribute("id");

        if(id!=null)
        {
            userServiceimpl.setUser(user, id);

            response = new ServerResponse<User>(200,user);
            response.setMessage("成功");
            response.setResult(true);

        }
        else {
            response = new ServerResponse<User>(10,"用户未登录,请登录");
        }
        return response;
    }


}
