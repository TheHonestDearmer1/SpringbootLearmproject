package com.example.blog_project.controller;
import com.example.blog_project.domain.Banners;
import com.example.blog_project.domain.respone;
import com.example.blog_project.service.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class BannersController {

    private final BannersService bannersService;

    @Autowired
    public BannersController(BannersService bannersService) {
        this.bannersService = bannersService;
    }

    respone respone = new respone();

    //添加banners
    @PostMapping("/banners/action")
    public Object Add_banners(@RequestBody Banners banners) {
        if (banners.getTitle().isEmpty()) {
            respone.setStatus_code(-1);
            respone.setStatus_msg("标题不能为空");
            return respone;
        }
        if(bannersService.Save(banners)){
            respone.setStatus_code(0);
            respone.setStatus_msg("添加成功");
            return respone;
        }
        respone.setStatus_code(-1);
        respone.setStatus_msg("添加失败,请重试");
        return respone;
    }

    //删除
    @GetMapping("/banners/action/delete")
    public Object Delete(Integer ID) {
        if (bannersService.Delete(ID)) {
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
    @PostMapping("/banners/action/change")
    public Object Update(@RequestBody Banners banners) {
        if (banners.getTitle() == null && banners.getDescription() == null && banners.getHref() == null) {
            respone.setStatus_code(-1);
            respone.setStatus_msg("至少修改一项");
            return respone;
        }
        if(bannersService.Update(banners)){
            respone.setStatus_code(0);
            respone.setStatus_msg("修改成功");
            return respone;
        }
        respone.setStatus_code(-1);
        respone.setStatus_msg("修改失败,请重试");
        return respone;
    }
    //请求列表
    @GetMapping("/banners/action")
    public Object DataList(){
        respone.setDataList(bannersService.DataList());
        respone.setStatus_code(0);
        respone.setStatus_msg("获取列表成功");
        return respone;
    }

}