 





 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<%@ include file="./common.jsp" %>
    <style>
    body {
        margin: 0;
        padding: 0;
        background-color: #17a2b8;
        height: 100vh;
      }
      #login .container #login-row #login-column #login-box {
        /* margin-top: 120px;
        max-width: 600px;
        height: 320px; */
        width: 500px;
    height: 320px;
    top: 50%;
    left: 50%;
    position: absolute;
    margin-top: -200px;
    margin-left: -250px;
        border: 1px solid #9C9C9C;
        background-color: #EAEAEA;
      
       
      }
      #login .container #login-row #login-column #login-box #login-form {
        padding: 20px;
      }
      #login .container #login-row #login-column #login-box #login-form #register-link {
        margin-top: -85px;
      }
      
       </style>
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!------ Include the above in your HEAD tag ---------->

</head>


<body>
<h3>${requestScope.addusermsg}</h3>
<h3>${requestScope.loginmsg}</h3>
<h3>${requestScope.message}</h3>

    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-2">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="/role/login" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="email" id="username" class="form-control" required="required">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="pass" id="password" class="form-control" required="required">
                            </div>
                            <span>
                                <input type="radio" name="acctype" value="Admin" required="required">Admin</input>
                                <input type="radio" name="acctype" value="Customer" required="required">Customer</input>
                                <input type="radio" name="acctype" value="Shopper" required="required">Shopper</input>
                            </span> 
                            <div class="form-group">
                             <!--   <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            <div><span id="register-link" class="text-right">
                                <a href="/role/addrole" class="text-info">Register here</a>
                            </span><span id="forgaet-pass" class="text-right">
                                <a href="/role/forgetpass" class="text-info">Forget password</a>
                            </span>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

