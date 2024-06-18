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

<div class="container">
<form method="post">
  <h1>ȸ������</h1>
  <div>
    <label>����� ���̵�</label>
    <input type="text" name="userid" value="${ userid }" />
  </div>

  <div>
    <label>�̸�</label>
    <input type="text" name="name" value="${ name }" />
  </div>

  <div>
    <label>��й�ȣ1</label>
    <input type="password" name="password1" />
  </div>
  
  <div>
    <label>��й�ȣ2</label>
    <input type="password" name="password2" />
  </div>

  <div>
    <label>�̸���</label>
    <input type="email" name="email" value="${ email }" />
  </div>

  <div>
    <label>����</label>
    <select name="departmentId">
      <option value="1" ${ departmentId == 1 ? "selected" : "" }>����Ʈ�������</option>
      <option value="2" ${ departmentId == 2 ? "selected" : "" }>��ǻ�Ͱ���</option>
      <option value="3" ${ departmentId == 3 ? "selected" : "" }>������Ű���</option>
      <option value="4" ${ departmentId == 4 ? "selected" : "" }>�۷���IT</option>
    </select>
  </div>

  <button type="submit" class="btn">ȸ������</button>
</form>
<c:if test="${ not empty errorMsg }">
  <div class="error">${ errorMsg }</div>
</c:if>
</div>

</body>
</html>