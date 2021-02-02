

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
						 <h3 class="text-center my-3">Create Profile</h3>
          
 				<form action="/role/addmoredetails" method="post" >
 				 
 				 <div class="form-group">
    <label for="Fname">First Name:</label>
    <input type="text" class="form-control" name="Fname" id="Fname" aria-describedby="fnameHelp" required="required" placeholder="Enter first name">
  				</div>
 				 
 				 <div class="form-group">
    <label for="Lname">Last Name:</label>
    <input type="text" class="form-control" name="Lname" id="Lname" aria-describedby="lnameHelp" required="required" placeholder="Enter last name">
  				</div>
  					
  					
  					
  					 <div class="form-group">
      <label for="Gender">Gender:</label>
      <select class="form-control" name="Gender" id="Gender" required="required" >
       <option value="" selected disabled hidden>Choose here</option>
        <option>Male</option>
        <option>Female</option>
        <option>Other</option>
      </select>
      </div>
      
       <div class="form-group">
    <label for="ContactNo">ContactNo:</label>
    <input type="text" class="form-control" name="ContactNo" id="ContactNo" aria-describedby="contactnoHelp"  maxlength="10" pattern="\d{10}" title="Please enter exactly 10 digits" required="required" placeholder="Enter contactNo">
  				</div>
  
       <div class="form-group">
    <label for="DOR">Date of Registration:</label>
    <input type="date" class="form-control" name="DOR" id="DOR" aria-describedby="dorHelp" required="required" placeholder="Enter DOR">
  				</div>
  
   <div class="form-group">
    <label for="City">City:</label>
    <input type="text" class="form-control" name="City" id="City" aria-describedby="cityHelp" required="required" placeholder="Enter city">
  				</div>
  				
  				 <div class="form-group">
    <label for="State">State:</label>
    <input type="text" class="form-control" name="State" id="State" aria-describedby="stateHelp" required="required" placeholder="Enter state">
  				</div>
  				
  				 <div class="form-group">
    <label for="PinCode">PinCode:</label>
    <input type="text" class="form-control" name="PinCode" id="PinCode" aria-describedby="pcHelp" required="required" placeholder="Enter pincode">
  				</div>
  				
  				 <div class="form-group">
    <label for="RoleID">RoleID:</label>
    <input type="text" class="form-control"  name="RoleID" id="RoleID" aria-describedby="roleidHelp" value="${ sessionScope.role_details.roleID}" readonly="readonly">
  				</div>
  				<br>
  				<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">Addmoredetails</button>  			
								<button type="reset" class="btn btn-outline-warning">Reset</button>  		
  					</div>
  				
 				</form>               
               </div>
               </div>
        </div>

      </div>

</body>
</html>

