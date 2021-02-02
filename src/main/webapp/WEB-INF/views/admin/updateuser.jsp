<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./header.jsp"></jsp:include>
	<h3>Update user</h3>
	<form method="post" action="">
		<table style="background-color: chartreuse; margin: auto;" border="1">
			<tr>
				<td>AccType</td>
				<td><input type="text" name="accType"
					value="${requestScope.updateuserdetails.accType}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Active</td>
				<td><input type="text" name="active"
					value="${requestScope.updateuserdetails.active}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value="${requestScope.updateuserdetails.email}" readonly="readonly" /></td>
			</tr>
		
			<tr>
				<td>RoleID</td>
				<td><input type="text" name="roleID"
					value="${sessionScope.logged_details.roleID}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="UpdateUser" /></td>
			</tr>
		</table>
	</form>

</body>
</html>