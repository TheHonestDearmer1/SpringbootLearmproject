package com.example.blog_project.service.impl;
import com.example.blog_project.dao.CustomDao;
import com.example.blog_project.domain.Custom;
import com.example.blog_project.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CustomServiceImpl implements CustomService {
    private final CustomDao customDao;
    @Autowired
    public CustomServiceImpl(CustomDao customDao){
        this.customDao =customDao;
    }

    @Override
    public boolean Save(Custom custom) {
        if (custom.getDescription() == null){
            custom.setDescription("");
        }
       if(custom.getFile() == null){
          custom.setSrc("");
       }else{
           try {
               String staticFolderPathURL = ResourceUtils.getFile("classpath:static/").getAbsolutePath();
               String staticFolderPath = staticFolderPathURL.replace("\\", "/"); // 修正 Windows 上的路径分隔符

               String originalFileName = custom.getFile().getOriginalFilename();

               // 文件名安全性检查和生成唯一文件名
               String fileName = UUID.randomUUID() + "_" + originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

               String filePath = staticFolderPath + "/" + fileName;
               Path targetPath = Paths.get(filePath);

               Files.write(targetPath, custom.getFile().getBytes());

               custom.setSrc("http://localhost:5000/" + fileName);
           } catch (IOException e) {
               // 处理文件写入异常
               e.printStackTrace();
               // 添加适当的异常处理逻辑，例如设置响应状态码为 500，返回错误信息等
           }

       }
        return customDao.Save(custom);
    }

    @Override
    public boolean Delete(Integer ID){
        return customDao.Delete(ID);
    }

    @Override
    public boolean Update(Custom custom){
        if (custom.getDescription().isEmpty()){
            custom.setDescription("");
        }
        if (custom.getTitle().isEmpty()){
            custom.setTitle("");
        }
        if(custom.getFile() == null){
            custom.setSrc("");
        }else{
            try {
                String staticFolderPathURL = ResourceUtils.getFile("classpath:static/").getAbsolutePath();
                String staticFolderPath = staticFolderPathURL.replace("\\", "/"); // 修正 Windows 上的路径分隔符

                String originalFileName = custom.getFile().getOriginalFilename();

                // 文件名安全性检查和生成唯一文件名
                String fileName = UUID.randomUUID() + "_" + originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

                String filePath = staticFolderPath + "/" + fileName;
                Path targetPath = Paths.get(filePath);

                Files.write(targetPath, custom.getFile().getBytes());

                custom.setSrc("http://localhost:5000/" + fileName);
            } catch (IOException e) {
                // 处理文件写入异常
                e.printStackTrace();
                // 添加适当的异常处理逻辑，例如设置响应状态码为 500，返回错误信息等
            }

        }
        return customDao.Update(custom);
    }

    @Override
    public List<Custom> DataList(){
        return customDao.DataList();
    }
}
