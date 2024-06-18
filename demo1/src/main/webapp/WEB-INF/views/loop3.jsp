<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:set var="list" value="apple, banana, orange, kiwi" />
<ul>
  <c:forEach var="s" items="${ list }">
      <li>${ s }</li>
  </c:forEach>
</ul>

</body>
</html>