package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FileUploadDao {

	@Autowired
	private SqlSession sqlSession;
	
/*	public List<FileUploadVo> getListAll() {
		
		
		
		
		return sqlSession.selectList("fileupload.selectListAllImgFile");
	}*/
	
/*public void insertImgFile(FileUploadVo fileUploadVo) {
		
		sqlSession.insert("fileupload.insertImgFile", fileUploadVo);
	}*/



public void deleteFile(int no) { // 삭제에 해당하는 번호의 테이블의 비밀번호와 사용자입력비밀번호가 맞을경우 삭제
	
	sqlSession.delete("fileupload.deleteFileByNo", no);

}
}
