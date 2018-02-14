package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	
	@Autowired
	UserDao userDao;
	@Autowired
	BlogDao blogDao;
	
	public void join(UserVo userVo) {
		userDao.join(userVo);
		
		int userNo=userDao.getUserNo(userVo.getId());
		blogDao.createBlog(userNo);
		blogDao.createCategory(userNo);
	}
	
	public UserVo login(UserVo userVo) {
		return userDao.login(userVo);
	}
	
	public int getUserNo(String userId) {

		return userDao.getUserNo(userId);
	}

	public List<CategoryVo> getCategoryListAll(int userNo) {
		// TODO Auto-generated method stub
		
		
		return blogDao.getCategoryListAll(userNo);
	}
}
