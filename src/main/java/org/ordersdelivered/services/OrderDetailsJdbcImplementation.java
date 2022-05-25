package org.ordersdelivered.services;

import java.util.List;

import org.ordersdelivered.domain.OrdersData;
import org.ordersdelivered.utils.OrdersJdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsJdbcImplementation implements OrderService {

	@Autowired
	OrdersJdbcUtil oju;

	@Override
	public void add(OrdersData order) {
		oju.insertOrderDetails(order);
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrdersData> delete(OrdersData order) {

		oju.deleteOneOrderDetails(order);
		return getdetails();
		// TODO Auto-generated method stub
	}

	@Override
	public List<OrdersData> getdetails() {

		// TODO Auto-generated method stub
		return oju.getdetails();
	}

	@Override
	public OrdersData getByDetailsId(int orderId) {
		// TODO Auto-generated method stub
		return oju.SpecificOrderOutput(orderId);
	}

	@Override
	public List<OrdersData> sortOrderData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersData updateOrderDetails(OrdersData order) {
		return oju.updateOrderDetails(order);
		// TODO Auto-generated method stub
	}

}