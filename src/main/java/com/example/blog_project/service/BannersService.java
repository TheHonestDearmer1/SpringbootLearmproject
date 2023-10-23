package com.example.blog_project.service;

import com.example.blog_project.domain.Banners;

import java.util.List;

public interface BannersService {
  boolean Save(Banners banners);
  boolean Delete(Integer ID);

  boolean Update(Banners banners);

  List<Banners> DataList();
}
