package com.example.blog_project.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.blog_project.domain.User;
import com.example.blog_project.domain.respone;
import com.example.blog_project.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class UserController{
    private final UserService userService;
    private final User user;
    @Autowired
    public UserController(UserService userService, User user) {
        this.userService = userService;
        this.user = user;
    }
   respone respone = new respone();
    //注册
    @PostMapping("/register")
    public Object register(@RequestBody JSONObject jsonObject) {
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("username");
        String repassword = jsonObject.getString("repassword");
        if(Objects.equals(password, repassword)){
            User Olduser = userService.SearchUser(username,null);
            if(Olduser != null && Olduser.getUsername().isEmpty()){
                respone.setStatus_code(-1);
                respone.setStatus_msg("用户已存在");
                return respone;
            }
            respone.setStatus_code(0);
            respone.setStatus_msg("注册成功");
            respone.setToken(password);
            user.setUsername(username);
            user.setPassword(password);
            Integer userID = userService.saveUser(user);
            respone.setUser_id(userID);
            return respone;
        }else{
            respone.setStatus_code(-1);
            respone.setStatus_msg("两次输入的密码不相同");
            return respone;
        }
    }
    //登录
    @GetMapping("/login")
    public Object login(String username,String password){
        if (username.isEmpty() || password.isEmpty()){
            respone.setStatus_code(-1);
            respone.setStatus_msg("用户或密码不能为空");
            return respone;
        }
     User login_user = userService.SearchUser(username,password);
       if (login_user == null){
           respone.setStatus_code(-1);
           respone.setStatus_msg("用户或密码错误");
           return respone;
       }
        respone.setStatus_code(0);
       respone.setStatus_msg("用户"+username+"登录成功");
       return  respone;
    }
    // 其他请求处理方法...
}