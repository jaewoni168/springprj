<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
table {
	border-collapse: collapse;
}

td {
	padding: 5px;
	border: solid 1px gray;
}
</style>

</head>
<body>

	<jsp:useBean id="now" class="java.util.Date" />
	<table>
		<tr>
			<td>시각</td>
			<td><fmt:formatDate value="${ now }" pattern="HH:mm:ss" /></td>
		</tr>
		<tr>
			<td>시</td>
			<td><fmt:formatDate value="${ now }" pattern="H" /></td>
		</tr>
		<tr>
			<td>분</td>
			<td><fmt:formatDate value="${ now }" pattern="m" /></td>
		</tr>
		<tr>
			<td>초</td>
			<td><fmt:formatDate value="${ now }" pattern="s" /></td>
		</tr>
	</table>
	<fmt:formatDate var="hour" value="${ now }" pattern="H" />
	<fmt:formatDate var="minute" value="${ now }" pattern="m" />
	<fmt:formatDate var="second" value="${ now }" pattern="s" />

	<c:if test="${ hour <12 }">
	Good Morning!
	</c:if>

	<c:if test="${ 12<= hour && hour <18 }">
	Good Afternoon!
	</c:if>

	<c:if test="${18<= hour }">
	Good Evening!
	</c:if>

	<br /> 지금은 ${ hour }시 ${ minute }분 ${ second }초 입니다.

</body>
</html>