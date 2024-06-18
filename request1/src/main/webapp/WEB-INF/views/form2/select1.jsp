<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
div.container {
	width: 400px;
	margin: 20px auto;
}

form div {
	margin-bottom: 10px;
}

label {
	display: inline-block;
	width: 70px;
	text-align: right;
}

input {
	width: 150px;
	padding: 4px;
}

select {
	width: 50px;
	padding: 4px;
}

button {
	padding: 0.4em 2em;
	margin-top: 10px;
}
</style>

</head>
<body>
	<div class="container">
		<form method="post">

			<div>
				<label>number1:</label> <input type="text" name="number1"
					value="${ number1 }" />
			</div>

			<div>
				<label>operator:</label> <select name="cmd">
					<option value="+" ${cmd =="+" ? "selected" : ""}>+</option>
					<option value="-" ${cmd =="-" ? "selected" : ""}>-</option>
					<option value="*" ${cmd =="*" ? "selected" : ""}>*</option>
					<option value="/" ${cmd =="/" ? "selected" : ""}>/</option>
					
				</select>
			</div>

			<div>
				<label>number2:</label> <input type="text" name="number2"
					value="${ number2 }" />
			</div>

			<div>
				<button type="submit">확인</button>
			</div>
		</form>

		<p>결과: ${ result }
		<p>
	</div>
</body>
</html>