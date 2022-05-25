<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Login Form</title>
	<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body style="background-color:lightblue;">

				<form id="form" onsubmit="return validateForm()" action="ManuhServices/ServletClass" method="post">
		 
  <div class="container">
 	
 	<div class="header">
 		<h1>login</h1>
 		<p  class="sub">Only admin and staff can access to login</p>
 		<p><c:out value="${error}" /></p>
 		<p><c:out value="${loginError}"></c:out></p>
 		<p><c:out value="${logOutError}"></c:out></p>
 		<!--  <p class="error"><%=request.getAttribute("error")
		%></p>-->
 	</div>
	
	
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>



    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
	

		<button type="submit">Login</button>
    
  
</form> 
</body>
</html>		