package com.example.blog_project.dao;
import com.example.blog_project.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
    @Insert(value = "INSERT INTO user(username,password) VALUES(#{username},#{password});")
    @Options(useGeneratedKeys = true,keyProperty = "ID")
    Integer save(User user);

    User SearchUser(@Param("username") String username, @Param("password") String password);
}
