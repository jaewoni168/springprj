<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<style>
    table { border-collapse: collapse; }
    td { padding: 5px; border: solid 1px gray; }

</style>

<title>Insert title here</title>
</head>
<body>

<table>
  <tr>
    <c:forEach var="i" begin="0" end="10">
      <td>${ i }</td>
    </c:forEach>
  </tr>
</table>

</body>
</html>