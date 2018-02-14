package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {

	
	@Autowired
	BlogDao blogDao;
	
	public void createBlog(int userNo) {
		blogDao.createBlog(userNo);
	}
	
	public void createCategory(int userNo) {
		blogDao.createCategory(userNo);
	}
	
	public BlogVo getBlogTitlelogo(int userNo) {
		return blogDao.getBlogTitlelogo(userNo);
	}
	
	public List<CategoryVo>  getCategoryList(int userNo) {
		return blogDao.getCategoryList(userNo);
	}
	
	public void updateBlogTitle(BlogVo blogVo) {
		blogDao.updateBlogTitle(blogVo);
	}

	public void addNewCategory(CategoryVo categoryVo, int userNo) {
		// TODO Auto-generated method stub
		categoryVo.setUserNo(userNo);
		blogDao.addNewCategory(categoryVo);
		
	}
	
}
