<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 메인해더 -->
		<a href="${pageContext.request.contextPath }">
			<img class="logo" src="/jblog/assets/images/logo.jpg">

		</a>
		<ul class="menu">
			
			
				
					
			<!-- 로그인 전 메뉴 -->
			<c:if test="${authUser==null}">
			<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
			<li><a href="${pageContext.request.contextPath }/user/joinform">회원가입</a></li>
		</c:if>
			<!-- 로그인 후 메뉴 -->
			<c:if test="${authUser!=null}">
			 <li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath }/${authUser.id}">내블로그</a></li> 
			</c:if>
				
 		</ul>
 		<!-- /메인해더 -->