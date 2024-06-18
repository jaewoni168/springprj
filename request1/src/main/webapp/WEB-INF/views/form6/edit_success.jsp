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

<h1> �л����� ��� ����</h1>

<table>
	<tr>
		<td>�й�</td>
		<td>${ student.studentNo }</td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td>${ student.name }</td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td>${ student.email }</td>
	</tr>
	<tr>
		<td>����ID</td>
		<td>${ student.departmentId }</td>
	</tr>
	
	
	<tr>
		<td>��������</td>
		<td><c:choose>
			<c:when test = "${student.departmentId == 1}">
				<p>����Ʈ�������</p>
			</c:when>
			<c:when test = "${student.departmentId == 2}">
				<p>��ǻ�Ͱ���</p>
			</c:when>
			<c:when test = "${student.departmentId == 3}">
				<p>������Ű���</p>
			</c:when>
			<c:when test = "${student.departmentId == 4}">
				<p>�۷���IT����</p>
			</c:when>
			</c:choose>
	</tr>
</table>

</body>
</html>