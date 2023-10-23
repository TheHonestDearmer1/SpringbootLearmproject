package com.example.blog_project.dao;
import com.example.blog_project.domain.Banners;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BannersDao {
    @Insert(value = "INSERT INTO banner_table(title,description,href) values (#{title},#{description},#{href})")
    boolean Save(Banners banners);

    @Delete(value = "DELETE FROM banner_table WHERE ID = #{ID}")
    boolean Delete(Integer ID);

    boolean Update(Banners banners);

    @Select(value = "SELECT * FROM banner_table")
    List<Banners> DataList();
}
