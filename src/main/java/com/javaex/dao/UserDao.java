package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	SqlSession sqlSession;
	
	
	
	public void join(UserVo userVo) {
		sqlSession.insert("user.insertUser", userVo);
	}
	public UserVo login(UserVo userVo) {
		
		return sqlSession.selectOne("user.selectUserByIdAndPass", userVo);
	}
	
	public int getUserNo(String userId) {
		return sqlSession.selectOne("user.selectUserNoById", userId);
	}
	public UserVo idCheck(String userId) {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectOne("user.selectForIdCheck",userId);
	}
	
	
}
