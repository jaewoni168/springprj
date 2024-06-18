<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<table>
		<tr>
			<c:forEach var="i" begin="1" end="10" >
				<c:if test="${ i % 2 == 0 }">
					<td style="background-color: #ffffcc">${ i }</td>
				</c:if>

				<c:if test="${ i % 2 != 0 }">
					<td style="background-color: #ccffcc">${ i }</td>
				</c:if>
			</c:forEach>
		</tr>
	</table>

</body>
</html>