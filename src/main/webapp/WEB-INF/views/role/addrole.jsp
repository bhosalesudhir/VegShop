
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <!-- to support form binding use spring supplied form taglib -->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Role Form</title>

<%@ include file="./common.jsp" %>

</head>
<body>
      <div class="row mt-5">
          <div class="col-md-4 offset-md-4">
               <div class="card">
               <div class="card-body">
						 <h3 class="text-center my-3">Sign Up Here</h3>
          
 				<form action="/role/addrole" method="post" >
 				 
 				 <div class="form-group">
    <label for="exampleInputEmail1">Email Address:</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required" placeholder="Enter email">
  				</div>
 				 
 				 	 <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" name="password" class="form-control" id="password" aria-describedby="passhelp" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"  title="password must be min-6 digits, 1-Upper,1-Small,1-Symbol"  required="required" placeholder="Enter password">
 					 </div>
  
  				 <div class="form-group">
      <label for="sel1">Select Account Type:</label>
      <select class="form-control" name="accType"   id="accType" required="required" >
       <option value="selected disabled hidden">Choose here</option>
        <option value="Customer">Customer</option>
        <option value="Shopper">Shopper</option>
        <option value="Admin">Admin</option>
      </select>
      </div>
      <br>
  					
  					<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">Register</button>  			
							<button type="reset" class="btn btn-outline-warning">Reset</button>  		
  					</div>
  
 				</form>               
               </div>
               </div>
        </div>

      </div>

</body>
</html>

