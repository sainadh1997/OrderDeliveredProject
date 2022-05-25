<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title> Searching...</title>
	
</head>

<body style="background-color:darkseagreen">
			
		
		<h2>Data for Manuh_Orders</h2>
			

<table>
	<tr>
			<th>orderId</th>
			<th>orderProductName</th>
			<th>orderCustomerName</th>
			<th>adress</th>
			<th>phoneNumber</th>
			<th>paymentMethod</th>
			<th>ProductBooked</th>
			<th>Edit</th>  
			<th>Delete</th>
	</tr>
	
	
			<tbody>
			
			
		<tr>
					<td><c:out value="${order.orderId}" /></td>
					<td><c:out value="${order.orderProductName}" /></td>
					<td><c:out value="${order.orderCustomerName}" /></td>
					<td><c:out value="${order.adress}" /></td>
					<td><c:out value="${order.phoneNumber}" /></td>
					<td><c:out value="${order.paymentMethod}" /></td>
					<td><c:out value="${order.productBooked}" /></td>
          
          
		  
				<td>
						<a href="/ManuhServices/EditSpecificId?orderId=<c:out value="${order.orderId}" />"> edit</a>		
				</td>
				
				
				<td>
						<a href="/ManuhServices/DeleteSelectId?orderId=<c:out value="${order.orderId}" />"> delete</a>		
				</td>
				
								
		</tr>
		
		      
			</tbody>
	
</table>

                    <div>
							<a href="backbutton">
							<button type="submit">Back To Home</button>
							</a>
  					</div>     
 	          
</form>
</body>
</html>

