package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Record;
import com.health.service.impl.RecordServiceImpl;
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
@RequestMapping("api")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;
    @RequestMapping(value = "add_record",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Record> addRecord(HttpSession session, @RequestBody Record record) {
        ServerResponse<Record> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null){
            recordService.addRecord(record, id);
            response = new ServerResponse<Record>(200, record);
            response.setMessage("成功");
            response.setResult(true);
        }else{
            response = new ServerResponse<Record>(10, "用户未登录");
        }
        return response;
    }
//    public ServerResponse<Record> setRecord(HttpSession session, @RequestBody Record record) {
//        ServerResponse<Record> response = null;
//        Integer id = (Integer)session.getAttribute("id");
//
//        if (id != null){
//            recordService.setRecord(record);
//            response = new ServerResponse<Record>(200, record);
//            response.setMessage("成功");
//            response.setResult(true);
//        }else{
//            response = new ServerResponse<Record>(10, "用户未登录");
//        }
//        return response;
//    }
}
