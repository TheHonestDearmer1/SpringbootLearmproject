package com.example.blog_project.service.impl;
import com.example.blog_project.dao.BannersDao;
import com.example.blog_project.domain.Banners;
import com.example.blog_project.service.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BannersServiceImpl implements BannersService {
    private final BannersDao bannersDao;
    @Autowired
    public BannersServiceImpl(BannersDao bannersDao){
        this.bannersDao =bannersDao;
    }
    @Override
    public boolean Save(Banners banners) {
        if (banners.getDescription() == null){
            banners.setDescription("");
        }
        if (banners.getHref() == null){
            banners.setHref("");
        }
        return bannersDao.Save(banners);
    }

    @Override
    public boolean Delete(Integer ID){
      return bannersDao.Delete(ID);
    }

    @Override
    public boolean Update(Banners banners){
        return bannersDao.Update(banners);
    }

    @Override
    public List<Banners> DataList(){
        return bannersDao.DataList();
    }
}
