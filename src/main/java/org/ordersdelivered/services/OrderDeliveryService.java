package org.ordersdelivered.services;


import java.util.*;
import org.ordersdelivered.domain.OrdersDeliveryDetails;

public interface OrderDeliveryService {
      
	public void add(OrdersDeliveryDetails delivery);
	
	public List<OrdersDeliveryDetails> getData();
	
	public List<OrdersDeliveryDetails> delete(OrdersDeliveryDetails delivery);

	public OrdersDeliveryDetails SpecificDeliveryOutput(int deliveredId);
	
	public OrdersDeliveryDetails updateDeliveryDetails(OrdersDeliveryDetails delivery);
	
	public List<OrdersDeliveryDetails> relationalConnectionFirstDomain(int orderId);
	
	
	
}