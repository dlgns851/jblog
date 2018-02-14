<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


			
			
			
			
			
			<!-- 블로그 해더 -->
		<div id="header">
			<h1>${blogVo.blogTitle }</h1>
			<ul>
				<!-- 로그인 전 메뉴 -->
				<c:if test="${authUser==null}">
			
				<li><a href="">로그인</a></li>
					</c:if>
					
				<!-- 로그인 후 메뉴 -->
				<c:if test="${authUser!=null}">
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/basic">내블로그 관리</a></li>
				<li><a href="${pageContext.request.contextPath }/${authUser.id}">내블로그</a></li> 
				</c:if>
			</ul>
		</div>
		<!-- /블로그 해더 -->