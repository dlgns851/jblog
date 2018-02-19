<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
			<c:import url="/WEB-INF/views/includes/mainheader.jsp"></c:import>
	
 		<!-- /메인해더 -->
 		
		<form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label>
			<input type="text" name="userName"  value="" />
			
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="id" id="user-id" value="" />
			<input id="btn-checkid" type="button" value="id 중복체크">
			
			<div id="checkMsg"> </div>
			
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			<p class="form-error">
			</p>

			<label class="block-label" for="password">패스워드</label>
			<input type="password" name="password"  value="" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>

</body>

<script type="text/javascript">
//리퀘스트바디로 받을때
$("#btn-checkid").on("click",function(){
	var userId = $("#user-id").val();

	
	console.log(userId);
	
	
	$.ajax({
		//줄때
		url : "${pageContext.request.contextPath }/user/idcheck",
		type : "post",
		//contentType : "application/json",  
		//contentType : "text",
		data : {userId:userId},    
		
		
		//받을때 데이터타입 
		dataType : "json",
		success : function(flag){
			
			 if(flag==true){
				$("#checkMsg").text("사용할 수 있는 아이디입니다.");
			}
			else{
				$("#checkMsg").text("다른 아이디로 가입해주세요."); 
				
			}
		/*성공시 처리해야될 코드 작성*/
		},
		/*연결실패시 */
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
		});
	
});
</script>
</html>