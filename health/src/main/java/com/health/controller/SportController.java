package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Sport;
import com.health.service.impl.SportServiceImpl;
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
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportServiceImpl sportService;
    @RequestMapping(value = "/show",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Sport> getSport(HttpSession session) {
        ServerResponse<Sport> response = null;
        Integer id = (Integer) session.getAttribute("id");

        if (id != null) {
            List<Sport> sports = sportService.getSport(id);

            response = new ServerResponse<Sport>(200, sports.get(0));
            response.setMessage("成功");
            response.setResult(true);

        }else{
            response = new ServerResponse<Sport>(10,"用户未登录,请登录");
        }
        return response;
    }
}
