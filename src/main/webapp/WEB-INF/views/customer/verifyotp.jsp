<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
 <%@include file="verifyotp.css" %>
</style>

<script type="text/javascript">
		var sessionVar = <%=request.getAttribute("otp")%>
		function validateOtp() {
			var votp=document.getElementById("votp").value;
			alert(votp);
			if(sessionVar===votp)
			{
				alert(votp);
				document.getElementById("error").innerHTML="";
				return true;
			}
			else
		{
				document.getElementById("error").innerHTML="Otp not match plz enter correct one";
				return false;
		}
			return false;
		}
</script>
</head>
<body >
	<%-- <jsp:include page="./header.jsp"></jsp:include> --%>
	<div >
		<div align="center" >
			
			<h3>Please enter the 4-digit verification code we sent via Email:</h3>
			
			<form action="/customer/placedorder" method="get" >
			<div >
				<input type="text"  id="votp" maxLength="4" size="4" min="0" max="9" pattern="[0-9]{4}" />
				<br>
				<br>
				<input type="submit" id="btn" onsubmit="return validateOtp()" value="verify"/>
				<p id="error"></p>
			</div>
			
			</form>

			<div >
				Didn't receive the code?<br /> <a href="/customer/checkout">Send code again</a><br />
				
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