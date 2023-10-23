package com.example.blog_project.service;
import com.example.blog_project.domain.Custom;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface CustomService {
    boolean Save(Custom custom);
    boolean Delete(Integer ID);

    boolean Update(Custom custom);


    List<Custom> DataList();
}
