<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  div.container { width: 400px; margin: 20px auto; }
  form div { margin-bottom: 20px; }
  label { display: block; }  
  input, select { width: 200px; padding: 5px; }
  button { padding: 0.4em 1.5em; }
  div.error { margin-top: 20px; color: red; }
</style>

</head>
<body>

<div class = "container">
	<form method="post">
		<h1> �л����� </h1>
		<div>
			<label>�й�</label>
			<input type="text" name = "studentNo" value = "${ student.studentNo }" />
		</div>
		
		<div>
			<label>�̸�</label>
			<input type="text" name = "name" value = "${ student.name }" />
		</div>
		
		<div>
			<label>�̸���</label>
			<input type="email" name = "email" value = "${ student.email }" />
		</div>
		
		<div>
			<label>����</label>
			<select name="departmentId">
				<option value="0" ${ student.departmentId == 0 ? "selected" : "" }>������ �����ϼ���</option>
  				<option value="1" ${ student.departmentId == 1 ? "selected" : "" }>����Ʈ�������</option>
				<option value="2" ${ student.departmentId == 2 ? "selected" : "" }>��ǻ�Ͱ���</option>
  				<option value="3" ${ student.departmentId == 3 ? "selected" : "" }>������Ű���</option>
  				<option value="4" ${ student.departmentId == 4 ? "selected" : "" }>�۷���IT</option>
			</select>
		</div>
		
		<button type="submit" class="btn"> �л����� ��� </button>
	</form>
	<c:if test="${ not empty errorMsg }">
		<div class="error">${ errorMsg }</div>
	</c:if>
</div>



</body>
</html>