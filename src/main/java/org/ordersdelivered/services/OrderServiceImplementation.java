package org.ordersdelivered.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ordersdelivered.domain.OrdersData;

public class OrderServiceImplementation implements OrderService {

	List<OrdersData> details = new ArrayList<>();

	@Override
	public void add(OrdersData order) {

		details.add(order);
	}

	@Override
	public List<OrdersData> getdetails() {
		// TODO Auto-generated method stub
		return details;
	}

	@Override
	public List<OrdersData> delete(OrdersData order) {
		details.remove(order);
		return details;
	}

	@Override
	public List<OrdersData> sortOrderData() {
		Collections.sort(details, new Comparator<OrdersData>() {

			@Override
			public int compare(OrdersData od, OrdersData od2) {

				String name1 = (String) od.getorderProductName();
				String name2 = (String) od2.getorderProductName();
				return name1.compareTo(name2);
			}

		});

		return details;
	}

	@Override
	public OrdersData getByDetailsId(int orderId) { // ex(formet)-> int run()
		for (OrdersData OD : details) {

			if (OD.getorderId() == orderId) {
				return OD;
			}

		}

		return null;
	}

	@Override
	public OrdersData updateOrderDetails(OrdersData order) {
		// TODO Auto-generated method stub
		return null;
	}

}
