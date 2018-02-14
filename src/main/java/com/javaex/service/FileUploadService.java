package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileUploadDao;



@Service
public class FileUploadService {

	@Autowired
	FileUploadDao fileUploadDao;
	
	
	public String restore(MultipartFile file) {
		String saveDir = "D:\\javastudy\\upload";
		
		//파일 정보 수집
		
		//원파일이름
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		//확장자
		String exName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);
		//저장파일이름
		String saveName=System.currentTimeMillis()+UUID.randomUUID().toString()+exName;//UUID.randomUUID().toString()=랜덤값을 뽑아오는데   겹치는 가능성도 있어서  System.currentTimeMillis()를 더해줌
		System.out.println(saveName);
		//파일위치(패스)
		String filePath = saveDir + "\\"  + saveName;
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		
		//filefath 를  블로그 로그파일 에 넣어주면 됨 
		
		
		
		/*FileUploadVo fileUploadVo = new FileUploadVo();
		fileUploadVo.setOrgName(orgName);
		fileUploadVo.setExName(exName);
		fileUploadVo.setSaveName(saveName);
		fileUploadVo.setFilePath(filePath);
		fileUploadVo.setUserNo(1); //임의값 1
		fileUploadVo.setFileSize(fileSize);
		//vo만들어서 dao통해서 저장 
		fileUploadDao.insertImgFile(fileUploadVo);*/
		
		//파일카피 
		try {
			byte[] filedata = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir+"/"+saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(filedata);
			
			if(bout !=null) {
				bout.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return saveName;
	}
	
	/*public List<FileUploadVo> getListAll() {

	

		List<FileUploadVo> fileImgList = fileUploadDao.getListAll();

		return fileImgList;

	}*/
	public void deleteFile(int no) {

		

		fileUploadDao.deleteFile(no);


	}
	
	
}
