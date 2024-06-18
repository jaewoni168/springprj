<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="now" class="java.util.Date" />
<div>
${ now }
</div>
<div>
  <fmt:formatDate pattern="yyyy-MM-dd a hh:mm:ss" value="${ now }" />
</div>
<div>
  <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ now }" />
</div>
<div>
  <fmt:formatDate pattern="yy-M-d H:m:s" value="${ now }" />
</div>

</body>
</html>