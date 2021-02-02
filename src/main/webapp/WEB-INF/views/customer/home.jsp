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
								<th>Title</th>
								<th>Description</th>
								<th>UnitPrice</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="v" items="${sessionScope.all_productlist}">
								<tr>
								<td><img src="${pageContext.request.contextPath}/resources/images/${v.imageSrc}" width="100px" height="100px"></td>
									<td>${v.title.toUpperCase()}</td>
									<td>${v.description}</td>
									<td>&#8377;${v.unitPrice}</td>
									<td><div>
											<a href="/customer/addtocart/${v.vegetableId}"
												class="btn btn-primary">Add to cart</a>
										</div></td>
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