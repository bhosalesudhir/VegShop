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
<link rel="stylesheet" href="/JSPOnlineShopping/src/main/webapp/WEB-INF/views/style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th></th>
								 <th>VegetableId</th>
									<th>Title</th>
									<th>Description</th>
									<th> Category</th>
									<th>UnitPrice</th>
									<th>Quantity</th>
										<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="v" items="${requestScope.vegetables_list}">
								<tr>
								<td><img src="${pageContext.request.contextPath}/resources/images/${v.imageSrc}" width="100px" height="100px"></td>
								<td>${v.vegetableId}</td>
								<td>${v.title}</td>
								<td>${v.description}</td>
								<td>${v.category }</td>
									<td>&#8377;${v.unitPrice}</td>
									<td>${v.quantity}</td>
									<td>
									<span>
								
											<a href="/shopper/deleteproduct/${v.vegetableId}"
												class="btn btn-primary">Delete Product</a>
									
											<a href="/shopper/updateproduct/${v.vegetableId}"
												class="btn btn-primary">Update Product</a>
								
									</span>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>


