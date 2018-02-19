<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog3332323</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>

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
				
					
				</table> 
				<ul id="listArea">
					</ul>

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
$(document)
.ready(
		function() {

			var page = 1;

			$.ajax({
						//줄때
						url : "${pageContext.request.contextPath }/category/list",
						type : "post",
						//data : 
						//contentType : "application/json",  
						//contentType : "text",
						//data : JSON.stringify(userVo),     //이렇게 보낼경우 리퀘스트? 리스폰스? 헤더영역에 들어감 

						//받을때 데이터타입 
						dataType : "json",
						success : function(categoryList) {

							console.log(categoryList);
							for (var i = 0; i < categoryList.length; i++) {
								render(categoryList[i], "down");
							}
							/* for (var i = 0; i < guestList.length; i++) {
								render(guestList[i], "down");
							} */

							/*성공시 처리해야될 코드 작성*/
						},
						/*연결실패시 */
						error : function(XHR, status, error) {
							console.error(status + " : " + error);
						}
					});
			
			
			
			
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
											success : function(categoryVo1){
													
												
												render(categoryVo1, "down");

												
											},
											
											error : function(XHR,
													status, error) {
												console	.error(status+ " : "
																+ error);
											}
										}); 

							});
			
			
			
		});

						

						

				

	function render(CategoryVo, updown) { //글이 위에서 붙을 수 있게 flag 로 updown 넣어놈 

		
		var str = "";
		str+= "<tr>";
			str+="<td>"+CategoryVo.cateNo+"</td>";
			str+="<td>"+CategoryVo.cateName+"</td>";
			str+="<td>"+CategoryVo.postCount+"</td>";
			str+="<td>"+CategoryVo.description+"</td>";
			str+="<td><img ";
			str+=	"src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>";
			
			str+="</tr>";
	
		
		/* str += "<li id='"+CategoryVo.cateNo+"'>";
		str += "	<table>";
		str += "     <tr>";
		str += "		<td>[" + CategoryVo.cateNo + "]</td>";
		str += "		<td>" + CategoryVo.cateName + "</td>";
		str += "		<td>" + CategoryVo.regDate + "</td>";
		str += " 		<td><input type='button' class='btnDel' value='삭제' data-no='"+ CategoryVo.cateNo+"'>"; //원래의 "" 는 '' 로 바꿔준다
		str += "     </tr>";
		str += "     <tr>";
		str += "     <td colspan=4>" + CategoryVo.description +CategoryVo.postCount+ "</td>";
		str += "     </tr>";
		str += "	</table>";
		str += "	<br>";
		str += "</li>"; */

		if (updown == "up") {
			$(".admin-cat").prepend(str);
		} else if (updown == "down") {
			$(".admin-cat").append(str);
		} else {
			console.log("updown 오류");
		}

	}
</script> 
</html>