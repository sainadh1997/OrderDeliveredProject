package org.ordersdelivered.services;

import java.util.List;

import org.ordersdelivered.domain.OrdersDeliveryDetails;
import org.ordersdelivered.utils.OrdersDeliveryJdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDeliveryDetailsJdbcImpl implements OrderDeliveryService {

	@Autowired
	OrdersDeliveryJdbcUtil odju;

	@Override
	public void add(OrdersDeliveryDetails delivery) {
		// TODO Auto-generated method stub
		odju.insertOrderDetails(delivery);
	}

	@Override
	public List<OrdersDeliveryDetails> getData() {
		// TODO Auto-generated method stub

		return odju.getDetails();
	}

	public List<OrdersDeliveryDetails> delete(OrdersDeliveryDetails delivery) {
		// TODO Auto-generated method stub
		odju.deleteOneDeliveryDetails(delivery);
		return odju.getDetails();
	}

	public OrdersDeliveryDetails updateDeliveryDetails(OrdersDeliveryDetails delivery) {

		return odju.updateDeliveryDetails(delivery);
		// TODO Auto-generated method stub
	}

	public List<OrdersDeliveryDetails> relationalConnectionFirstDomain(int orderId) {
		return odju.relationalConnectionFirstDomain(orderId);
	}

	@Override
	public OrdersDeliveryDetails SpecificDeliveryOutput(int deliveredId) {
		// TODO Auto-generated method stub
		return odju.SpecificDeliveryOutput(deliveredId);
	}

}
