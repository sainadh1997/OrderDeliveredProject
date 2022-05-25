<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


			
			<!DOCTYPE html>
<html>
<head>
	<title> Table FORM</title>
	<link rel="stylesheet" type="text/css" href="/css/tabledesign.css">
</head>

<body style="background-color:darkseagreen;;">
				
							<h2>Update Delivered Status</h2>
						
<table>
							
				<tr>
						<th>orderId</th>
						<th>orderDeliveryStatus</th>
						<th>paymentStatus</th>
						<th>productReachedSafelyOrNot</th>
						<th>deliveredId</th>
						<th>DeliveredDate</th>
				</tr>
	
	
<tbody>
					<c:forEach items="${deliveredList}" var="delivered">
			
		<tr>
						<td><c:out value="${delivered.orderId}"/></td>
						<td><c:out value="${delivered.orderDeliveryStatus}"/></td>
						<td><c:out value="${delivered.paymentStatus}"/></td>
						<td><c:out value="${delivered.productReachedSafelyOrNot}"/></td>
						<td><c:out value="${delivered.deliveredId}"/></td>
						<td><c:out value="${delivered.deliveredDate}"/></td>
							
		</tr>
		
		</c:forEach>
		     			
</tbody>
	
		
</table>

  				    <div>
							<a href="/ManuhServices/DisplayTableOrdersContent">
							<button type="submit">Back To Menu</button>
							</a>
  					</div>
	
</body>
</html>
