<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<h1>회원가입성공</h1>

<table>
	<tr>
		<td>사용자 아이디</td>
		<td>${ member.userid }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${ member.name }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${ member.email }</td>
	</tr>
	<tr>
		<td>전공 ID</td>
		<td>${ member.departmentId }</td>
	</tr>
	</table>

</body>
</html>