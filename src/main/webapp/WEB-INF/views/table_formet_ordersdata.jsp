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
		
		
				<h2>Data for Manuh_Orders</h2>
		
		
		<div class="topnav">
  			
  				<a class="active" href="/ManuhServices/AddingData">Add Customer Data</a>
					
					
				<a href="#contact">Contact</a>	
				
				
				<form  action="SearchOrderysByInt" style="margin:auto;max-width:500px" href="/css/searchstyle.css">
  						<input type="number" placeholder="Your Order_Id" name="orderId">
  						<button type="submit"><i class="fa fa-search"></i>SEARCH</button>		
        		</form>					
		
		</div>
					


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
			<th>Delivered_Updates</th>
			<th><a href="/ManuhServices/DisplayTableDeliverContent">List_Delivered</a></th>
			    
			
			
	</tr>
	
	
			<tbody>
				<c:forEach items="${orderList}" var="order">
			
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
				
				
				<td>
						<a href="/ManuhServices/EnteringDeliveredUpdates/<c:out value="${order.orderId}" />">Add_Delivered_Updates</a>		
				</td>
				
				
				<td>
						<a href="/ManuhServices/RelationalConnection?orderId=<c:out value="${order.orderId}" />">View</a>		
				</td>


								<td><button>
									<i class="fas fa-trash-alt">
									</button>
								</i></td>
		</tr>
		
		      </c:forEach>
			
			</tbody>
		
</table>
  					
					<div>
							<a href="/ManuhServices/homepage">
								<button type="submit">Back To Menu</button>
							</a>
  					</div>
  					
  					
			     
</body>
</html>

