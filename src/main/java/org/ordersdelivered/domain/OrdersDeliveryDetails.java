package org.ordersdelivered.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdersDeliveryDetails {
	private int orderId;

	@NotNull
	@Size(min = 1, message = "the status should not be empty")
	private String orderDeliveryStatus;

	@NotNull
	@Size(min = 1, message = "the paymentstatus should not be empty")
	private String paymentStatus;

	@NotNull
	@Size(min = 1, message = "the product status should not be empty")
	private String productReachedSafelyOrNot;

	private Integer deliveredId;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DeliveredDate;

	public OrdersDeliveryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersDeliveryDetails(int orderId, String orderDeliveryStatus, String paymentStatus,
			String productReachedSafelyOrNot, Integer deliveredId, Date DeliveredDate) {
		super();

		this.orderId = orderId;
		this.orderDeliveryStatus = orderDeliveryStatus;
		this.paymentStatus = paymentStatus;
		this.productReachedSafelyOrNot = productReachedSafelyOrNot;
		this.deliveredId = deliveredId;
		this.DeliveredDate = DeliveredDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDeliveryStatus() {
		return orderDeliveryStatus;
	}

	public void setOrderDeliveryStatus(String orderDeliveryStatus) {
		this.orderDeliveryStatus = orderDeliveryStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getProductReachedSafelyOrNot() {
		return productReachedSafelyOrNot;
	}

	public void setProductReachedSafelyOrNot(String productReachedSafelyOrNot) {
		this.productReachedSafelyOrNot = productReachedSafelyOrNot;
	}

	public Integer getDeliveredId() {
		return deliveredId;
	}

	public void setDeliveredId(Integer deliveredId) {
		this.deliveredId = deliveredId;
	}

	public Date getDeliveredDate() {
		return DeliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		DeliveredDate = deliveredDate;
	}

	@Override
	public String toString() {
		return "OrdersDeliveryDetails [orderId=" + orderId + ", orderDeliveryStatus=" + orderDeliveryStatus
				+ ", paymentStatus=" + paymentStatus + ", productReachedSafelyOrNot=" + productReachedSafelyOrNot
				+ ", deliveredId=" + deliveredId + ", DeliveredDate=" + DeliveredDate + "]";
	}

}
