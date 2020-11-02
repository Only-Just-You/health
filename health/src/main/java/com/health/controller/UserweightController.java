package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Userweight;
import com.health.service.impl.UserweightServiceImpl;
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
@RequestMapping("/pojo/userweight")
public class UserweightController {
    @Autowired
    private UserweightServiceImpl userweightService;
    @RequestMapping(value = "getWeight",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Userweight> getWeight(HttpSession session) {
        ServerResponse<Userweight> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null) {
            List<Userweight> userweights = userweightService.getWeight(id);

            response = new ServerResponse<Userweight>(200, userweights.get(0));
            response.setMessage("成功");
            response.setResult(true);
        }else{
            response = new ServerResponse<Userweight>(10, "用户未登录");
        }
        return response;
    }
}
