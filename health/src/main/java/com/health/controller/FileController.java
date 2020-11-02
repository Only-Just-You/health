package com.health.controller;

import com.health.common.ServerResponse;
import com.health.service.impl.FoodServiceImpl;
import com.health.service.impl.SportServiceImpl;
import com.health.service.impl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SportServiceImpl sportService;

//    String fileDiskPath = "D://Downloads//";
    @RequestMapping(value = "/user_image", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Boolean> fileUpload(@RequestParam(value = "file")MultipartFile file, HttpSession session) {
        ServerResponse<Boolean> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null) {
            if (file.isEmpty()) {
                response = new ServerResponse<Boolean>(20, "文件夹为空");
                return response;
            }
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = "C://health//user//";
            fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            }catch (IOException e) {
                e.printStackTrace();
            }
            String filename = filePath + fileName;
            userService.addImage(filename, id);
            response = new ServerResponse<Boolean>(200, true);
            response.setMessage("成功");
            response.setResult(true);

        }else{
            response = new ServerResponse<Boolean>(10, "用户未登录");
        }
        return response;
    }
    @RequestMapping(value = "/sport_image", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Boolean> fileUpload01(@RequestParam(value = "file")MultipartFile file, HttpSession session) {
        ServerResponse<Boolean> response = null;
        Integer id = (Integer)session.getAttribute("id");

        if (id != null) {
            if (file.isEmpty()) {
                response = new ServerResponse<Boolean>(20, "文件夹为空");
                return response;
            }
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = "C://health//sport//";
            fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            }catch (IOException e) {
                e.printStackTrace();
            }
            String filename = filePath + fileName;
            sportService.addImage(filename, id);
            response = new ServerResponse<Boolean>(200, true);
            response.setMessage("成功");
            response.setResult(true);

        }else{
            response = new ServerResponse<Boolean>(10, "用户未登录");
        }
        return response;
    }
}
