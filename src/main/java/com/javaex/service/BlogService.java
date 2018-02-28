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
	
	public void createBlog(int userNo,String userId) {
		blogDao.createBlog(userNo,userId);
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
	
	public void updateBlogTitle2(BlogVo blogVo) {
		blogDao.updateBlogTitle2(blogVo);
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

	public List<PostVo> getPostList(int userNo,String selectedCategoryNo) {
		// TODO Auto-generated method stub
		if(selectedCategoryNo=="" || selectedCategoryNo==null)
		return blogDao.getPostList(userNo);
		
		return blogDao.getPostList(userNo,selectedCategoryNo);
	}

	public PostVo getPostTitleContent(int userNo,String selectedCategoryNo,String selectedPostNo) {
		// TODO Auto-generated method stub
		if(selectedPostNo !=null)
			return blogDao.getPostTitleContentByPostNo(selectedPostNo); // 유저가 포스트 제목을 클릭햇을경우 
		
		if(selectedCategoryNo==null)
		return blogDao.getPostTitleContent(userNo);   //첫메인화면은 유저 가장 최근 포스트 출력
		
		return blogDao.getPostTitleContentByCategoryNo(userNo,selectedCategoryNo);  //선택된 카테고리의 최신글 출력
	}

	public void deleteCategory(String categoryNo) {
		// TODO Auto-generated method stub
		blogDao.deleteCategory(categoryNo);
		
	}
	
}
