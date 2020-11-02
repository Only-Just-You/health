package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Userinf;
import com.health.service.IUserinfService;
import com.health.service.impl.UserinfServiceImpl;
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
@RequestMapping("/user")
public class UserinfController {
    @Autowired
    public IUserinfService userinfServiceimpl;

    @RequestMapping(value="/mine",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Userinf> getInf(HttpSession session){

        ServerResponse<Userinf> response;
//        User user = (User)session.getAttribute("user");
        Integer id =(Integer)session.getAttribute("id");

        if(id!=null)
        {
            List<Userinf> userinf = userinfServiceimpl.getInf(id);

            response = new ServerResponse<Userinf>(200,userinf.get(0));
            response.setMessage("成功");
            response.setResult(true);


        }
        else {
            response = new ServerResponse<Userinf>(10,"用户未登录,请登录");
        }
        return response;
    }


}
