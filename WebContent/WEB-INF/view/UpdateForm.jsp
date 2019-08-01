<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#d1{
		color:white;
		background-color: black;
	}
	#d2{
		color:white;
		background-color: black;
	}
	#wrap{
		width:100%;
	}
</style>
</head>
<body>
	<form action="update.do" method="post">
	<header>
		<div id="d1">
			SPMS(Simple Project Management System)
		</div>
	</header>
	<div id="wrap">
	<p>
		<label>프로젝트이름  </label>
		<input type="text" value="${project.p_name}" name="p_name">
	</p>
	
	<p>
		<label>프로젝트내용  </label><br>
		<textarea rows="10" cols="40" value="${project.p_txt}" name="p_txt">${project.p_txt}</textarea>
	</p>
	
	<p>
		<label>시작날짜 </label>
		<input type="text" value="${project.p_start }" name="p_start">
	</p>
	
	<p>
		<label>마감날짜 </label>
		<input type="text" value="${project.p_end}" name="p_end">
	</p>
	
	<p>
		<label>상태</label><br>
		<select value="${project.p_ing }" name="p_ing">		
			<option>준비</option>
			<option>진행중</option>
		</select>
	</p>
	<p>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</p>
	</div>
	<footer>
		<div id="d2">
			SPMS @ 2019
		</div>
	</footer>
	</form>
</body>
</html>