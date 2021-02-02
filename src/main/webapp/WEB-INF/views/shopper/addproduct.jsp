

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <!-- to support form binding use spring supplied form taglib -->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>

<%@ include file="./common.jsp" %>

</head>
<body>

      <div class="row mt-5">
          <div class="col-md-4 offset-md-4">
               <div class="card">
               <div class="card-body">
						 <h3 class="text-center my-3">Add Product Form</h3>
          
 				<form action="" method="post" >
 				 
 				 <div class="form-group">
    <label for="Title">Title:</label>
    <input type="text" class="form-control" name="Title" id="Title" aria-describedby="titleHelp" required="required" placeholder="Enter title">
  				</div>
  				
  				 <div class="form-group">
    <label for="Description">Description:</label>
    <input type="text" class="form-control" name="Description" id="Description" aria-describedby="descriptionHelp" required="required" placeholder="Enter description">
  				</div>
  				
  				 <div class="form-group">
    <label for="Category">Category:</label>
    <input type="text" class="form-control" name="Category" id="Category" aria-describedby="categoryHelp" required="required" placeholder="Enter category">
  				</div>
  				
  				 <div class="form-group">
    <label for="UnitPrice">UnitPrice:</label>
    <input type="text" class="form-control" name="UnitPrice" id="UnitPrice" aria-describedby="unitPriceHelp" required="required" placeholder="Enter unitPrice">
  				</div>
  				
  				 <div class="form-group">
    <label for="Quantity">Quantity:</label>
    <input type="text" class="form-control" name="Quantity" id="Quantity" aria-describedby="quantityHelp" required="required" placeholder="Enter quantity">
  				</div>
  				
  				 <div class="form-group">
    <label for="RoleID">RoleID:</label>
    <input type="text" class="form-control" name="RoleID" id="RoleID" aria-describedby="roleIDHelp" value="${sessionScope.logged_details.roleID}" readonly="readonly" >
  				</div>
 				 
 		
      <br>
  					
  					<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">AddProduct</button>  			
							<button type="reset" class="btn btn-outline-warning">Reset</button>  		
  					</div>
  
 				</form>               
               </div>
               </div>
        </div>

      </div>

</body>
</html>

