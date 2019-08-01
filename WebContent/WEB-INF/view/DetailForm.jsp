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
	table{
		border-collapse: collapse;
		width: 500px;
		text-align: center; 
		margin: 0 auto;
	}
	tr,td{
		border:1px solid black;
	}
	.a11{
		text-decoration: none;
		color: black;
	}
	#d10{ 
		text-align: center;
	} 
</style> 
</head>
<body>
	<form action="${pageContext.request.contextPath }/project/read.do" method="post">
	<header>
		<div id="d1">
			SPMS(Simple Project Management System)
		</div>
	</header>
		<table>
			<tr>
				<th>프로젝트 이름</th>
				<td>${project.p_name }</td>
			</tr>
			
			<tr>
				<th>프로젝트 내용</th>
				<td>${project.p_txt }</td>
			</tr>
			
			<tr>
				<th>시작 날짜</th>
				<td><fmt:formatDate value="${project.p_start }"/></td>
			</tr>
			
			<tr>
				<th>종료 날짜</th>
				<td><fmt:formatDate value="${project.p_end }"/></td>
			</tr>
			
			<tr>
				<th>상태</th>
				<td>${project.p_ing }</td>
			</tr>
		</table>
		
		<div id="d10">
			<a href="update.do?p_no=${project.p_no }" class="a11">[수정]</a>
			<a href="#" class="a11">[삭제]</a>
			<a href="list.do" class="a11">[돌아가기]</a>
		</div>
	<footer>
		<div id="d2">
			SPMS @ 2019
		</div>
	</footer>
	</form>
</body>
</html>