<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="./header.jsp" />
<h3>${requestScope.pid.vegetableId}</h3>
	<form method="post">
		<table style="background-color: chartreuse; margin: auto;" border="1">
			<tr>
				<td>VegetableId</td>
				<td><input type="number" name="VegetableId" value="${requestScope.pid.vegetableId}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td><label for="payment">payment</label></td>
				<td><select name="payment" id="payment">
						<option value="paytm">paytm</option>
						<option value="PhonePe">PhonePe</option>
						<option value="GooglePe">GooglePe</option>
						<option value="COD">COD</option>
				</select></td>

			</tr>
			
			<tr>
				<td>UnitPrice</td>
				<td><input type="number" name="UPrice" value="${requestScope.currentselectedVegetable.unitPrice}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="Quantity"   /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="AddtoCart" /></td>
			</tr>
		</table>
</body>
</html>