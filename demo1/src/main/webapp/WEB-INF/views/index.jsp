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
<h1>�ȳ��ϼ���</h1>
<h3>${ user }�� ${message} </h3>
<h3><fmt:formatDate value="${ now }" pattern = "yyyy-MM-dd HH:mm:ss" /></h3>
 
</body>
</html>