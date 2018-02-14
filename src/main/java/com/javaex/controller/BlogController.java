package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	
	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/{userid}")
	public String login(@ModelAttribute UserVo userVo,@PathVariable(value="userid") String userId,Model model) {
		
		System.out.println(userId);
		
		int userNo =userService.getUserNo(userId);
		System.out.println(userNo+"userno임 ");
		BlogVo blogVo = blogService.getBlogTitlelogo(userNo);
		List<CategoryVo> categoryList = blogService.getCategoryList(userNo);
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
	
		
		
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
		return "blog/admin/blog-admin-cate";
		}
	}
	
	@ResponseBody
	@RequestMapping("category/add")
	public String categoryForm(@ModelAttribute CategoryVo categoryVo,HttpSession session) {
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		
		blogService.addNewCategory(categoryVo,userVo.getUserNo());
		System.out.println(categoryVo.toString());
		return "";
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

		return "blog/admin/blog-admin-write";
		}
	}
	
	
	
	
}
