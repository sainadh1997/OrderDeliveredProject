package org.ordersdelivered.services;

import java.util.ArrayList;
import java.util.List;


import org.ordersdelivered.domain.OrdersDeliveryDetails;

public class OrderDeliveryServiceImplementation implements OrderDeliveryService {

	List<OrdersDeliveryDetails> delivered = new ArrayList<>();

	@Override
	public void add(OrdersDeliveryDetails delivery) {

		delivered.add(delivery);

	}

	@Override
	public List<OrdersDeliveryDetails> getData() {

		return delivered;
	}

	@Override
	public List<OrdersDeliveryDetails> delete(OrdersDeliveryDetails delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersDeliveryDetails SpecificDeliveryOutput(int deliveredId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersDeliveryDetails updateDeliveryDetails(OrdersDeliveryDetails delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersDeliveryDetails> relationalConnectionFirstDomain(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
