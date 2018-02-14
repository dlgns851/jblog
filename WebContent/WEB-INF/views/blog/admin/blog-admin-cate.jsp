<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog3332323</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js?a=3"></script>

</head>
<body>

	<div id="container">

		<!-- 블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blogheader.jsp"></c:import>

		<!-- /블로그 해더 -->


		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/basic">기본설정</a></li>
					<li class="selected"><a
						href="${pageContext.request.contextPath}/${authUser.id }/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/write">글작성</a></li>
				</ul>

				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<tr>
						<td>3</td>
						<td>미분류</td>
						<td>10</td>
						<td>카테고리를 지정하지 않은 경우</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>2</td>
						<td>스프링 스터디</td>
						<td>20</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>1</td>
						<td>스프링 프로젝트</td>
						<td>15</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<table id="admin-cat-add">
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="desc" id="desc"></td>
					</tr>
					<tr>
						<td class="s">&nbsp;</td>
						<td><input type="submit" value="카테고리 추가" id="btn_addCategory"></td>
					</tr>
				</table>
			</div>
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

<script type="text/javascript">


						

						$("#btn_addCategory").on("click",function() {
							var name =$("#name").val();
							console.log(name);
							
							
							console.log("asdfasdfasd");
											var newWriting = {
												cateName : $("#name").val(),
												description : $("#desc").val()
												}
											
									
									
									
								 $.ajax({
														//줄때
														url : "${pageContext.request.contextPath }/category/add",
														type : "post",
														data : newWriting,
														//contentType : "application/json",  
														//contentType : "text",
														//data : JSON.stringify(userVo),     //이렇게 보낼경우 리퀘스트? 리스폰스? 헤더영역에 들어감 

														//받을때 데이터타입 
														dataType : "json",
														success : function(){
																
															console.alert("새카테고리생성성공");
														

															
														},
														
														error : function(XHR,
																status, error) {
															console	.error(status+ " : "
																			+ error);
														}
													}); 

										});

				

	function render(guestVo, updown) { //글이 위에서 붙을 수 있게 flag 로 updown 넣어놈 

		var str = "";
		str += "<li id='"+guestVo.no+"'>";
		str += "	<table>";
		str += "     <tr>";
		str += "		<td>[" + guestVo.no + "]</td>";
		str += "		<td>" + guestVo.name + "</td>";
		str += "		<td>" + guestVo.regDate + "</td>";
		str += " 		<td><input type='button' class='btnDel' value='삭제' data-no='"+ guestVo.no+"'>"; //원래의 "" 는 '' 로 바꿔준다
		str += "     </tr>";
		str += "     <tr>";
		str += "     <td colspan=4>" + guestVo.content + "</td>";
		str += "     </tr>";
		str += "	</table>";
		str += "	<br>";
		str += "</li>";

		if (updown == "up") {
			$("#listArea").prepend(str);
		} else if (updown == "down") {
			$("#listArea").append(str);
		} else {
			console.log("updown 오류");
		}

	}
</script> 
</html>