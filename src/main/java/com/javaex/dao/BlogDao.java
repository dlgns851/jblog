package com.javaex.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;
	
	
	
	public void createBlog(int userNo) {
		sqlSession.insert("blog.insertBlog", userNo);
	}
	public void createCategory(int userNo) {
		 sqlSession.insert("blog.insertCategory", userNo);
	}
	
	public BlogVo getBlogTitlelogo(int userNo) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userNo);
		return sqlSession.selectOne("blog.selectBlogTitleByUserId", userNo);
	}
	
	public List<CategoryVo>  getCategoryList(int userNo) {
		return sqlSession.selectList("blog.selectCategoryByUserId", userNo);
	}
	
	public void updateBlogTitle(BlogVo blogVo) {
		 sqlSession.update("blog.updateBlogTitle", blogVo);
	}
	public void addNewCategory(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		sqlSession.insert("blog.insertNewCategory",categoryVo);
		
	}
	
}
