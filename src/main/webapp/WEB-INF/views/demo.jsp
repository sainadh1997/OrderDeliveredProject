<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Manuh Orders</title>
  <style>
p {
  text-align: center;
  }
</style>

</head>
<body style="background-color:darkseagreen;">


				<form action="AddingData" method="post">
		
				
			<p text-align=center; style="color:red;">Welcome To Manuh Orders Register Form</p>
			<p text-align=center; style="color:black;">Products Booking</p>
		    
		    
		       <p class="error"><c:out value="${emptyFliedError }"></c:out></p>	
					
			
			<p style="color:blue;">orderProductName:<br></p>
			<p><input type="text" name="orderProductName"  value='<c:out value="${order.orderProductName}" />' placeholder="Product Name..."></p>
			
			
			<p style="color:blue;">orderCustomerName:<br></p>
			<p><input type="text" name="orderCustomerName"  value='<c:out value="${order.orderCustomerName}" />'  placeholder="Your Name.."></p>	
					
			
			<p style="color:blue;">Adress:<br></p>	
			<p><input type="text" name="adress" value='<c:out value="${order.adress}" />'  placeholder="Your Adress.."></p>
			
			
			<p style="color:blue;">phoneNumber:<br></p>	
			<p><input type="text" name="phoneNumber" value='<c:out value="${order.phoneNumber}" />'  placeholder="Your phoneNumber.."></p>
			
			
			<p style="color:blue;">paymentMethod:<br></p>	
			<p><input type="text" name="paymentMethod" value='<c:out value="${order.paymentMethod}" />'  placeholder="online or cash on delivery...."></p>
			
			
			<p style="color:blue;">productBooked:<br></p>
			<p><input type="text" id="productBooked" value='<c:out value="${order.productBooked}" />' name="productBooked"></p>
			
			
			    <p><input type="submit" value="Submit"></p>
				

	</form>
				<p text-align=center; style="color:red;">Thanks for Products Booking In Manuh Orders</p>
				
 	    
 				<div>
							<a href="/ManuhServices/DisplayTableOrdersContent">
								<button type="submit">Back To Menu</button>
							</a>
  					</div>	    
 	    
 	    
</body>
</html>