package com.example.blog_project.service.impl;
import com.example.blog_project.dao.UserDao;
import com.example.blog_project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blog_project.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public Integer saveUser(User user) {
        System.out.println(user.getUsername());
        return userDao.save(user);
    }
    @Override
    public User SearchUser(String username,String password){
        return userDao.SearchUser(username,password);
    }
}
