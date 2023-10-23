package com.example.blog_project.controller;
import com.example.blog_project.domain.Custom;
import com.example.blog_project.domain.respone;
import com.example.blog_project.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class CustomController {
    private final CustomService customService;
    private final Custom custom;

    @Autowired
    public CustomController(CustomService customService, Custom custom) {
        this.customService = customService;
        this.custom = custom;
    }
    respone respone = new respone();

    //添加banners
    @PostMapping("/custom")
    public Object Add_custom(@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam("title") String title, @RequestParam("description") String description) {
        if (title.isEmpty()) {
            respone.setStatus_code(-1);
            respone.setStatus_msg("标题不能为空");
            return respone;
        }
        custom.setFile(file);
        custom.setTitle(title);
        custom.setDescription(description);
        if(customService.Save(custom)){
            respone.setStatus_code(0);
            respone.setStatus_msg("添加成功");
            return respone;
        }
        respone.setStatus_code(-1);
        respone.setStatus_msg("添加失败,请重试");
        return respone;
    }

    //删除
    @GetMapping("/custom/action/delete")
    public Object Delete(@PathParam("ID") Integer ID) {
        if (customService.Delete(ID)) {
            respone.setStatus_code(0);
            respone.setStatus_msg("删除成功");
            return respone;
        } else {
            respone.setStatus_code(-1);
            respone.setStatus_msg("删除失败，请重试");
        }
        return respone;
    }
    //修改
    @PostMapping("/custom/action/change")
public Object Update(@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam("ID") Integer ID,@RequestParam("title") String title, @RequestParam("description") String description) {
        if (file == null && title.isEmpty() && description.isEmpty()) {
            respone.setStatus_code(-1);
            respone.setStatus_msg("请至少修改一项");
            return respone;
        }
        if(file != null){
            custom.setFile(file);
        }
        custom.setID(ID);
        custom.setTitle(title);
        custom.setDescription(description);
        if(customService.Update(custom)){
            respone.setStatus_code(0);
            respone.setStatus_msg("修改成功");
            return respone;
        }
        respone.setStatus_code(-1);
        respone.setStatus_msg("修改失败,请重试");
        return respone;
    }
    //请求列表
    @GetMapping("/custom")
    public Object DataList(){
        respone.setDataList(customService.DataList());
        respone.setStatus_code(0);
        respone.setStatus_msg("获取列表成功");
        return respone;
    }

}
