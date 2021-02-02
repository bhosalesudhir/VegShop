<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<!-- <h1 align="center">Welcome to Shopping Cart</h1> -->
<body>
	<jsp:include page="./header.jsp" />
	<%-- <h5>${sessionScope.OrderedCartList}</h5> --%>
	<div align="center" style="color: green;">
		<h1>Welcome To Shopping Cart</h1>
	</div>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Product</th>
								<th scope="col">Quantity</th>
								<th scope="col">Price</th>
								<th scope="col">Amount</th>
								<th scope="col">remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="O" items="${sessionScope.OrderedCartList}">
								<c:set var="total" value="${total + O.totalAmount}"></c:set>
								<c:set var="vid" value="${O.vegetableId.vegetableId}"></c:set>
								<c:set var="Shipping" value="50"></c:set>
								<tr>

									<td>${O.vegetableId.vegetableId}</td>
									<td>${O.vegetableId.title.toUpperCase()}</td>
									<td>${O.qty}</td>
									<td>&#8377;${O.unitprice}</td>
									<td>&#8377;${O.totalAmount}</td>
									<td><a
										href="/customer/remove/${O.vegetableId.vegetableId}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Sub-Total</td>
							<td class="text-left">${total}</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Shipping</td>
							<td class="text-left">${Shipping}</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><strong>Total</strong></td>
							<td class="text-left"><strong>${total+Shipping}</strong></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="col mb-2" align="center">
				<div class="row">
					<div class="col-sm-3  col-md-3">

						<a href="/customer/home" class="btn btn-block btn-light">Continue
							Shopping</a>
					</div>
					<div class="col-sm-3 col-md-3 ">
						<a href="/customer/checkout"
							class="btn btn-lg btn-block btn-success text-uppercase">Checkout</a>
					</div>
				</div>
			</div>
</body>
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>