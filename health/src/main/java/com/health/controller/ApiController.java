package com.health.controller;

import com.health.common.ServerResponse;
import com.health.entity.User;
import com.health.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api")
@ResponseBody
public class ApiController {
    @Autowired
    private IApiService iApiService;
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public ServerResponse<User> login(HttpSession session, @RequestBody User user){
        ServerResponse<User> response = null;

        List<User> list = iApiService.login(user);
        if (list.size() == 1) {
            User i_user = list.get(0);
            Integer id = i_user.getId();
            session.setAttribute("id", id);
            response = new ServerResponse<User>(200, i_user);
            response.setMessage("成功");
            response.setResult(true);
        }else {
            response = new ServerResponse<>(10, "该用户还未注册");
        }
        return response;
    }
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public ServerResponse<User> register(HttpSession session, @RequestBody User user) {
        ServerResponse<User> response = null;

        List<Integer> list = iApiService.queryByName(user);
        if (list.size() != 0) {
            response = new ServerResponse<>(10, "该用户已注册");
        }else {
            iApiService.register(user);
            response = new ServerResponse<User>(200, user);
            response.setMessage("成功");
            response.setResult(true);
        }
        return response;
    }
}
