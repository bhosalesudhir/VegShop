<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h5>${requestScope.updateproductstatus}</h5>

	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<h2>Shop Stored Details :-</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>CustomerId</th>
								<th>CustomerMailId</th>
								<th>Title</th>
								<th>OStatus</th>
								<th>OrderDate</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="O" items="${requestScope.pendingOrder}">

								<tr>
									<td>${O.oRoleId.roleID}</td>
									<td>${O.oRoleId.email }</td>
									<td>${O.vegetableId.title.toUpperCase()}</td>
									<td>${O.OStatus}</td>
									<td>${O.orderDate}</td>

									<td><span> <a
											href="/admin/confirmOrder/${O.orderId}"
											class="btn btn-primary">Confirm Order</a>

									</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
