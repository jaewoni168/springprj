<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  body { font-family: ����ü; }
  div.container { width: 310px; margin: 20px auto; }
  table { width: 300px; border-collapse: collapse; }
  thead tr { background-color: #eee; }
  td, th { border: 1px solid #aaa; padding: 5px; }
  td:nth-child(1) { background-color: #eee; }
</style>

</head>
<body>

<h1>�α��� ����</h1>

<table>
	<tr>
		<td>����� ���̵�</td>
		<td>${userid}</td>
	</tr>
	<tr>
		<td>�ڵ� �α���</td>
		<td>${autologin}</td>
	</tr>
</table>

</body>
</html>