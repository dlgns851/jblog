package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping("loginform")
	public String loginform() {
		
		return "user/loginForm";
		
	}
	
	@RequestMapping("joinform")
	public String joingform() {
		
		return "user/joinForm";
	}
	
	@RequestMapping("join")
	public String join(@ModelAttribute UserVo userVo) {
		
		userService.join(userVo);
		//셀렉트 해서 유저no 받아온뒤 
			
		
		return "user/joinSuccess";
	}
	
	@RequestMapping(value="login")
	public String login(@ModelAttribute UserVo userVo,HttpSession session) {
		
		System.out.println(userVo.toString());
		//로그인 구현 
		UserVo authUser = userService.login(userVo);
		
		if(authUser != null) { //로그인성공
			
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}
		else {
			
			return "redirect:/user/loginform?flag=1";
		}
				
	}
	
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck")
	public boolean idCheck(@RequestParam("userId") String userId) {//리퀘스트바디로 객체 받아오기
		/*@RequestParam("userId") String userId*/
	boolean flag = userService.idCheck(userId);
		
		
		return flag;   
	}
	
	
	
	
}
