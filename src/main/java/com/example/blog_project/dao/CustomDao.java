package com.example.blog_project.dao;
import com.example.blog_project.domain.Custom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomDao {
    @Insert(value = "INSERT INTO custom_table(title,description,src) values (#{title},#{description},#{src})")
    boolean Save(Custom custom);

    @Delete(value = "DELETE FROM custom_table WHERE ID = #{ID}")
    boolean Delete(Integer ID);

    boolean Update(Custom custom);

    @Select(value = "SELECT * FROM custom_table")
    List<Custom> DataList();



}
