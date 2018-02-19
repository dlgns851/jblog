package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	
	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/{userid}")
	public String login(@ModelAttribute UserVo userVo,@PathVariable(value="userid") String userId,Model model,@RequestParam(value="selectedPostNo", required=false) String selectedPostNo,
			@RequestParam(value="selectedCategoryNo", required=false) String selectedCategoryNo) {
		
		System.out.println("선택된 카테고리"+selectedCategoryNo);
		
		int userNo =userService.getUserNo(userId);
		System.out.println(userNo+"userno임 ");
		PostVo postVo = blogService.getPostTitleContent(userNo,selectedCategoryNo,selectedPostNo); 
		BlogVo blogVo = blogService.getBlogTitlelogo(userNo);
		
		List<CategoryVo> categoryList = blogService.getCategoryList(userNo);
		List<PostVo> postList = blogService.getPostList(userNo,selectedCategoryNo);
		System.out.println(userId+"aaaaaaaaaaaa");
		model.addAttribute("userId",userId);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("postVo", postVo);
		System.out.println(postList.toString());
		model.addAttribute("postList", postList);
		
		
		return "blog/blog-main";
	}
	@RequestMapping("/{userid}/admin/basic")
	public String basicForm(HttpSession session,Model model,@PathVariable(value="userid") String userId) {
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/user/loginform";
		}
		else {		
			BlogVo blogVo = blogService.getBlogTitlelogo(authUser.getUserNo());
			model.addAttribute("blogVo", blogVo);
			model.addAttribute("userId",userId);

		return "blog/admin/blog-admin-basic";
		}
	}
	
	@RequestMapping("{userid}/admin/category")
	public String categoryForm(HttpSession session,Model model,@PathVariable(value="userid") String userId) {
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/user/loginform";
		}
		else {		
			BlogVo blogVo = blogService.getBlogTitlelogo(authUser.getUserNo());

			model.addAttribute("blogVo", blogVo);
			model.addAttribute("userId",userId);
		return "blog/admin/blog-admin-cate";
		}
	}
	
	@ResponseBody
	@RequestMapping("category/add")
	public CategoryVo categoryForm(@ModelAttribute CategoryVo categoryVo,HttpSession session) {
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		
		CategoryVo categoryVo1= blogService.addNewCategory(categoryVo,userVo.getUserNo());    //모델어트리뷰트와 categoryvo가 중복되는이름이라 1 추가  
		
		return categoryVo1;
	}
	
	@RequestMapping("{userid}/admin/write")
	public String writeForm(HttpSession session,Model model,@PathVariable(value="userid") String userId) {
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/user/loginform";
		}
		else {		
			int userNo =userService.getUserNo(userId);
			BlogVo blogVo = blogService.getBlogTitlelogo(authUser.getUserNo());
			List<CategoryVo> categoryList = blogService.getCategoryList(userNo);
			model.addAttribute("blogVo", blogVo);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("userId",userId);

		return "blog/admin/blog-admin-write";
		}
	}
	
	@RequestMapping("/post/write")
	public String postWrite(HttpSession session,Model model,@ModelAttribute PostVo postVo,@RequestParam("category") String cateTitle) {
		UserVo authUser= (UserVo)session.getAttribute("authUser");
		
		
		//postvo에넣을 카테고리 넘버값을 catetitle을 이용하여 넣기 
		
		//1.카테고리 넘버값 구하는 거 구현 
		//2.넘버값을 postVo에 넣는거
		//3postvo를 인설트 
		
		
		postVo.setCateNo(blogService.getCategoryNo(cateTitle,authUser.getUserNo() ));  //1,2
		
		System.out.println(postVo.getCateNo());
		blogService.addNewPost(postVo);

		return "redirect:/"+authUser.getId();
		}
	
	@ResponseBody
	@RequestMapping("category/list")
	public List<CategoryVo> categoryList(HttpSession session) {
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		int userNo =userService.getUserNo(userVo.getId());
		List<CategoryVo> categoryList = userService.getCategoryListAll(userNo);
		
	
		
		
		return categoryList;
	}





}










	
	
	
	

