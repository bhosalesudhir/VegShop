
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
	<br>
	<span >
		<form   action="home" method="post" >
	<input type="radio" name="acctype" value="Customer">CustomerList</input>
	<input type="radio" name="acctype" value="Shopper">ShopperList</input>
	<input type="submit" value="submit">
	</form>
	 </span>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								 <th>RoleID</th>
								<th>email</th>
								<th>accType</th>
								<th> Active</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="r" items="${requestScope.listByaccType}">
								<tr>
								  <td>${r.roleID}</td>
									<td>${r.email}</td>
									<td>${r.accType}</td>
								<td>${r.active}</td>
								<span> 
								<td><a href="/admin/deleteuser/${r.roleID}" class="btn btn-primary">remove</a></td>
								<td><a href="/admin/updateuser/${r.roleID}" class="btn btn-primary">update</a></td>
								 </span>
								<%-- 	<td>${v.title.toUpperCase()}</td>
									<td>${v.description}</td>
									<td>&#8377;${v.unitPrice}</td>
									<td><div>
											<a href="/customer/addtocart/${v.vegetableId}"
												class="btn btn-primary">Add to cart</a>
										</div></td> --%>
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

