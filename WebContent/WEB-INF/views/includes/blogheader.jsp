<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


			
			
			
			
			
			<!-- 블로그 해더 -->
		<div id="header">
			<a href="${pageContext.request.contextPath }/${userId}">  <h1>${blogVo.blogTitle }</h1></a>
			<ul>
				<!-- 로그인 전 메뉴 -->
				<c:if test="${authUser==null}">
			
				<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
					</c:if>
					
				<!-- 로그인 후 메뉴 -->
				<c:if test="${authUser!=null}">
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<c:if test="${userId==authUser.id}">
				<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/basic">내블로그 관리</a></li>
				</c:if>
				<li><a href="${pageContext.request.contextPath }/${authUser.id}">내블로그</a></li> 
				</c:if>
			</ul>
		</div>
		<!-- /블로그 해더 -->