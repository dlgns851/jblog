package com.javaex.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.FileUploadService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private BlogService blogService;
	/*@RequestMapping("/form")
	public String form(Model model) {
		List<FileUploadVo> fileUploadList = fileUploadService.getListAll();
		model.addAttribute("fileUploadList",fileUploadList );
		System.out.println(fileUploadList.toString());
		return "fileupload/form";
	}
	*/
	@RequestMapping("/upload")
	public String upload(@RequestParam(value="logo-file", required=false) MultipartFile file,@ModelAttribute BlogVo blogVo, Model model,HttpSession session){
		
		
		System.out.println("upload진입");
		//프로젝트 끝나면 아래부분 비지니스 분리하는거 해보셈
		if(!file.isEmpty()) {
			System.out.println("file not null 진입");
		System.out.println(file.toString());
		String saveName=fileUploadService.restore(file); 
		
		UserVo userVo = (UserVo)session.getAttribute("authUser"); 
		blogVo.setUserNo(userVo.getUserNo());
		
		
		blogVo.setLogoFile(saveName);
		
		blogService.updateBlogTitle(blogVo); //블로그 타이틀,로고파일 업데이트
		
		System.out.println("컨트롤러에서saveNAme:"+saveName);
		String url = "/upload/" + saveName;
	//	model.addAttribute("url", url);
		return "redirect:/"+userVo.getId()+"/admin/basic" ;}
		
		else {
			
			UserVo userVo = (UserVo)session.getAttribute("authUser"); 
			blogVo.setUserNo(userVo.getUserNo());
			blogService.updateBlogTitle2(blogVo); //블로그 타이틀,로고파일 업데이트
			return "redirect:/"+userVo.getId()+"/admin/basic";
			
		}
			
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no,Model model){
		
		
		fileUploadService.deleteFile(no);
		
		
	
		return "redirect:/fileupload/form";
	}
}
