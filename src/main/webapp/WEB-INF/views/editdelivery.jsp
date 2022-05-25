<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

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
				
				
				<form:form action="/ManuhServices/EditDeliver" modelAttribute="deliver" method="post">
		
					
				<p text-align=center; style="color:red;">Welcome To Manuh Products</p>
				
			
			<p><form:hidden path="orderId"    placeholder="Order Id.."/><br></p>
                   			
										
			<p style="color:blue;">orderDeliveryStatus:<br></p>
			<p><form:input path="orderDeliveryStatus"  placeholder="delivered or not delivered...."/></p>
			<form:errors path="orderDeliveryStatus"></form:errors>
			
			
			<p style="color:blue;">paymentStatus:<br></p>
			<p><form:input path="paymentStatus"  placeholder="pending or sucess...."/></p>
			<form:errors path="paymentStatus"></form:errors>	
					
			
			<p style="color:blue;">productReachedSafelyOrNot:<br></p>	
			<p><form:input path="productReachedSafelyOrNot"   placeholder="damaged or safe...."/></p>
			<form:errors path="productReachedSafelyOrNot"></form:errors>
			
			
			<p><form:hidden path="deliveredId"   placeholder="Order Id.."/><br></p>
			
			
			<p style="color:blue;">DeliveredDate:<br></p>
			<p><form:input path="DeliveredDate"   placeholder="delivered date...."/></p>
			<form:errors path="DeliveredDate"></form:errors>
									
			
			    <p><form:button>submit</form:button></p>
		
				
					<div>
							<button  onclick="history.back()">Go Back</button>
				    </div>
		 
		 
	</form:form>
				<p text-align=center; style="color:red;">Thanks And Visit Again</p>
</body>
</html>