<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  body { font-family: 굴림체; }
  div.container { width: 310px; margin: 20px auto; }
  table { width: 300px; border-collapse: collapse; }
  thead tr { background-color: #eee; }
  td, th { border: 1px solid #aaa; padding: 5px; }
  td:nth-child(1) { background-color: #eee; }
</style>

</head>
<body>

<h1>로그인 성공</h1>

<table>
	<tr>
		<td>사용자 아이디</td>
		<td>${userid}</td>
	</tr>
	<tr>
		<td>자동 로그인</td>
		<td>${autologin}</td>
	</tr>
</table>

</body>
</html>