<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
  div.container { width: 400px; margin: 20px auto; }
  div.radio label { margin-right: 20px; }
  button { padding: 0.4em 2em; margin-top: 10px; }
</style>

</head>
<body>

<div class="container">
  <form method="post">
    <h3>checkbox</h3>
    <div>
      <label>
        <input type="checkbox" name="checkbox1" value="true" ${ checkbox1 ? "checked" : ""} /> 
        �����Ͻʴϱ�?
      </label>
    </div>
    <hr />
 
    <h3>radio - ������?</h3>
    <div class="radio">
      <label><input type="radio" name="radio1" value="��" ${ radio1 == "��" ? "checked" : "" } /> ����</label>
      <label><input type="radio" name="radio1" value="��" ${ radio1 == "��" ? "checked" : "" } /> ����</label>
    </div>     
    <hr />
 
    <h3>radio - ��������?</h3>
    <div class="radio">
      <label><input type="radio" name="radio2" value="A" ${ radio2 == "A" ? "checked" : "" } /> A��</label>
      <label><input type="radio" name="radio2" value="B" ${ radio2 == "B" ? "checked" : "" } /> B��</label>
      <label><input type="radio" name="radio2" value="AB" ${ radio2 == "AB" ? "checked" : "" } /> AB��</label>
      <label><input type="radio" name="radio2" value="O" ${ radio2 == "O" ? "checked" : "" } /> O��</label>
    </div>
    
    <div>
      <button type="submit">Ȯ��</button>
    </div>
  </form>
  ${checkbox1 }
  <c:if test="${checkbox1}">
  false
  </c:if>
  ${radio1 }
  ${radio2 }��
</div>
</body>
</html>