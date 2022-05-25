package org.ordersdelivered.services;

import java.util.List;

import org.ordersdelivered.domain.OrdersData;

public interface OrderService {

	public void add(OrdersData order);

	public List<OrdersData> getdetails();

	public List<OrdersData> sortOrderData();

	public List<OrdersData> delete(OrdersData order);

	public OrdersData getByDetailsId(int orderId);
	
	public OrdersData updateOrderDetails(OrdersData order);
	
       
}
