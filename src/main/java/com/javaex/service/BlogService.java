package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
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

	public CategoryVo addNewCategory(CategoryVo categoryVo, int userNo) {
		// TODO Auto-generated method stub
		categoryVo.setUserNo(userNo);
		return blogDao.addNewCategory(categoryVo);   //하나 추가하고 추가한녀석 반환 
		
	}

	public int getCategoryNo(String cateTitle,int userNo) {
		// TODO Auto-generated method stub
		
		return blogDao.getCategoryNo(cateTitle,userNo);
		 
	}

	public void addNewPost(PostVo postVo) {
		// TODO Auto-generated method stub
		blogDao.addNewPost(postVo);
		
	}

	public List<PostVo> getPostList(int userNo) {
		// TODO Auto-generated method stub
		return blogDao.getPostList(userNo);
	}
	
}
