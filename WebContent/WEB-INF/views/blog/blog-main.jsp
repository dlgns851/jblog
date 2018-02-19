<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>

	<div id="container">

		<!-- 블로그 해더 -->
							<c:import url="/WEB-INF/views/includes/blogheader.jsp"></c:import>

		<!-- /블로그 해더 -->
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postVo.postTitle }</h4>
					<p>${postVo.postContent } </p>
					<c:if test="${postVo.postTitle eq null }">
					등록된 글이없습니다
					</c:if>
				
				</div>
				<ul class="blog-list">
				
				<c:forEach items="${ postList}" var="vo"> 
				<li><a href="${pageContext.request.contextPath }/${authUser.id}?selectedPostNo=${vo.postNo}&selectedCategoryNo=${param.selectedCategoryNo}">${vo.postTitle }</a> <span>${vo.regDate }</span>	</li>
				</c:forEach>
				
				
				
				
				
				
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath }/upload/${blogVo.logoFile}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			




			
			
			<c:forEach items="${categoryList }" var="vo"> 
				<li><a href="${pageContext.request.contextPath }/${authUser.id}?selectedCategoryNo=${vo.cateNo}">${vo.cateName}</a></li>
				
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터 -->
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2018
			</p>
		</div>
		<!-- 푸터 -->
		
	</div>
</body>
</html>