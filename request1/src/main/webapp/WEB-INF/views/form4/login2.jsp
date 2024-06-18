<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  div.container { width: 400px; margin: 20px auto; }
  form div { margin-bottom: 20px; }
  label { display: block; }
  input[type=text], input[type=password] { width: 200px; padding: 5px; }
  .btn { border: 1px solid gray; text-decoration: none; padding: 0.4em 1em;
    color: black; background-color: #eee; cursor: pointer; font-size: 10pt; }
  hr { margin-top: 80px; }
</style>

</head>
<body>
	<div class="container">
		<form method="post">
			<h1>�α���</h1>
			<div>
				<label>���̵�</label> <input type="text" class="text" name="userid" value="${userid}"/>
			</div>
			<div>
				<label>��й�ȣ</label> <input type="password" class="text"
					name="password"/>
			</div>
			<div>
				<label><input type="checkbox" name="autologin" ${ autologin ? "checked" : ""}/> �ڵ� �α���</label>
			</div>
			<button type="submit" class="btn">�α���</button>
			<a href="/form5/register1" class="btn">ȸ������</a>
		</form>
		
		<hr />
		
		����ð�:
		<fmt:formatDate pattern="HH:mm:ss" value="${ now }" />
		<br /> userid: ${ userid } <br /> password: ${ password } <br />
		autologin: ${ autologin } <br />

	</div>

</body>
</html>