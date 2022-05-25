<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<title>Validation Page</title>
	<link rel="stylesheet" type="text/css" href="./tabledesign.css">
</head>

<body style="background-color:darkseagreen;;">

<div class="main header">
	<h2>Manuh Orders_Delivered_Items</h2>
</div>


 <div class="container">
 	<div class="header">
 		<h1>Error Occured</h1>
 		<h3><c:out value="${exceptionOccurs}"></c:out></h3>
 		<h3><c:out value=" ${delete}"></c:out></h3>
 		<h3><c:out value="${error}"></c:out></h3>
 	</div>
 </div>


<div class="back">
 	<button  class="back" type="button" onclick="Previous()">back</button>
</div>
 <script  >function Previous() {
     window.history.back()
 }</script>


</body>
</html>