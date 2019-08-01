<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
		width:1000px;     
		text-align: center;   
		margin:0 auto; 
	}
	tr,td{
		border: 1px solid black;   
	}
	#wri1{
		text-decoration: none;
		color:black;
		float: right;
	}
	#d1{
		color:white;
		background-color: black;
	}
	#d2{
		color:white;
		background-color: black;
	}
</style>
</head>
<body>
	<header>
		<div id="d1">
			SPMS(Simple Project Management System)
		</div>
	</header>
	
	<a href="write.do" id="wri1">새 프로젝트 등록</a>
	<table>
		<c:forEach var="pro" items="${list }">
			<tr>
				<td>${pro.p_no }</td>
				<td><a href="read.do?p_no=${pro.p_no}">${pro.p_name }</a></td>  
				<td>${pro.p_txt }</td>
				<td><fmt:formatDate value="${pro.p_start }" pattern="yyyy-MM-dd"/> </td>
				<td><fmt:formatDate value="${pro.p_end }" pattern="yyyy-MM-dd"/></td>
				<td>${pro.p_ing }</td>
			</tr>
		</c:forEach>
	</table>
	
	<footer>
		<div id="d2">
			SPMS @ 2019
		</div>
	</footer>
</body>
</html>