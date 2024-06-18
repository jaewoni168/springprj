<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  div.container { width: 310px; margin: 20px auto; }
  table { width: 300px; border-collapse: collapse; }
  thead tr { background-color: #eee; }
  td, th { border: 1px solid #aaa; padding: 5px; }
  td:nth-child(1) { background-color: #eee; }
</style>

</head>
<body>

<h1> 학생정보 등록 성공</h1>

<table>
	<tr>
		<td>학번</td>
		<td>${ student.studentNo }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${ student.name }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${ student.email }</td>
	</tr>
	<tr>
		<td>전공ID</td>
		<td>${ student.departmentId }</td>
	</tr>
	
	
	<tr>
		<td>전공과목</td>
		<td><c:choose>
			<c:when test = "${student.departmentId == 1}">
				<p>소프트웨어공학</p>
			</c:when>
			<c:when test = "${student.departmentId == 2}">
				<p>컴퓨터공학</p>
			</c:when>
			<c:when test = "${student.departmentId == 3}">
				<p>정보통신공학</p>
			</c:when>
			<c:when test = "${student.departmentId == 4}">
				<p>글로컬IT공학</p>
			</c:when>
			</c:choose>
	</tr>
</table>

</body>
</html>