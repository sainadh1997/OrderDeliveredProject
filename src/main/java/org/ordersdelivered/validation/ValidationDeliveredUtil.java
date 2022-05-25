package org.ordersdelivered.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.ordersdelivered.domain.OrdersDeliveryDetails;

public class ValidationDeliveredUtil {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static String validate(OrdersDeliveryDetails request) {
		String orderDeliveryStatus = request.getOrderDeliveryStatus();               
		String paymentStatus = request.getPaymentStatus();
		String productReachedSafelyOrNot = request.getProductReachedSafelyOrNot();
		Date DeliveredDate = request.getDeliveredDate();
		String error = "";

		if (orderDeliveryStatus == null || orderDeliveryStatus.trim().length() == 0) {
			error = "Please Enter orderDeliveryStatus And It should not be empty";
		} else if (paymentStatus == null || paymentStatus.trim().length() == 0) {
			error = "Please Enter paymentStatus And It should not be empty";
		} else if (productReachedSafelyOrNot == null || productReachedSafelyOrNot.trim().length() == 0) {
			error = "Please Enter productReachedSafelyOrNot And It should not be empty";
		} else if (DeliveredDate == null || String.valueOf(DeliveredDate).trim().length() == 0) {
			error = "Please Enter DeliveredDate And It should not be empty";
		}

		
		return error;

	}

}
