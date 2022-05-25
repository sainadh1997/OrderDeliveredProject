package org.ordersdelivered.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.ordersdelivered.domain.OrdersData;

public class ValidationOrderUtil {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		
		 public static String validate(OrdersData order) {
		String orderproductName = order.getorderProductName();
		String ordercustomerName = order.getorderCustomerName();
		String adress = order.getAdress();
		String phonenumber = order.getPhoneNumber();
		String paymentMethod = order.getPaymentMethod();
		Date productBooked = order.getproductBooked();
		String error = "";
		if (orderproductName == null || orderproductName.trim().length() == 0) {
			error = "Please Enter OrderproductName And It should not be empty";
		} else if (ordercustomerName == null || ordercustomerName.trim().length() == 0) {
			error = "Please Enter OrdercustomerName And It should not be empty";
		} else if (adress == null || adress.trim().length() == 0) {
			error = "Please Enter adress And It should not be empty";
		} else if (phonenumber == null || phonenumber.trim().length() == 0) {
			error = "Please Enter Phonenumber And It should not be empty";
		} else if (paymentMethod == null || paymentMethod.trim().length() == 0) {
				error = "Please Enter paymentMethod And It should not be empty";
		} else if (productBooked == null || String.valueOf(productBooked).trim().length() == 0) {
			error = "Please Enter bookingdate And It should not be empty";
		}  
		
	
		return error;
	


		 }
		 
	
}
