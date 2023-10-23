package com.example.blog_project.service;
import com.example.blog_project.domain.User;

public interface UserService {
    Integer saveUser(User user);
    User SearchUser(String username,String password);
}
