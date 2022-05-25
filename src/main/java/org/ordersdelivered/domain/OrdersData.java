package org.ordersdelivered.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdersData {

	private int orderId;

	private String orderProductName;

	private String orderCustomerName;

	private String adress;

	private String phoneNumber;

	private String paymentMethod;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date productBooked;

	public OrdersData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersData(int orderId, String orderProductName, String orderCustomerName, String adress, String phoneNumber,
			String paymentMethod, Date productBooked) {
		this.orderId = orderId;
		this.orderProductName = orderProductName;
		this.orderCustomerName = orderCustomerName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.paymentMethod = paymentMethod;
		this.productBooked = productBooked;
	}

	public Date getproductBooked() {
		return productBooked;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setproductBooked(Date productBooked) {
		this.productBooked = productBooked;
	}

	public int getorderId() {
		return orderId;
	}

	public void setorderId(int orderId) {
		this.orderId = orderId;
	}

	public String getorderProductName() {
		return orderProductName;
	}

	public void setorderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}

	public String getorderCustomerName() {
		return orderCustomerName;
	}

	public void setorderCustomerName(String orderOwnerName) {
		this.orderCustomerName = orderOwnerName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "OrdersData [orderId=" + orderId + ", orderProductName=" + orderProductName + ", orderCustomerName="
				+ orderCustomerName + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", paymentMethod="
				+ paymentMethod + ", productBooked=" + productBooked + "]";
	}

}
