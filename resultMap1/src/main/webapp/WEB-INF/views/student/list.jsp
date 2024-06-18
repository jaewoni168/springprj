<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />

  <style>
    div.container { width: 900px; margin: 0 auto; }
    table { border-collapse: collapse; width: 100%; }
    td, th { border: 1px solid gray; padding: 4px; }
    thead { background-color: #ddd; }
  </style>

</head>
<body>

<div class="container">

  <h1>학생목록</h1>
  <table class="list">
    <thead>
      <tr>
        <th>학과</th>
        <th>id</th>
        <th>학번</th>
        <th>이름</th>
        <th>학과번호</th>
        <th>전화번호</th>
        <th>성별</th>
        <th>이메일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="student" items="${ students }">
        <tr>
          <td>${ student.department.departmentName }</td>
          <td>${ student.id }</td>
          <td>${ student.studentNo }</td>
          <td>${ student.name }</td>
          <td>${ student.departmentId }</td>
          <td>${ student.phone }</td>
          <td>${ student.sex }</td>
          <td>${ student.email }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>