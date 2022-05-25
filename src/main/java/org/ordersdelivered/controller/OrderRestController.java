package org.ordersdelivered.controller;

import java.util.List;

import org.ordersdelivered.domain.OrdersData;
import org.ordersdelivered.domain.OrdersDeliveryDetails;
import org.ordersdelivered.services.OrderDeliveryService;
import org.ordersdelivered.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderRestController {

	@Autowired
	OrderService service;

	@Autowired
	OrderDeliveryService services;

	@GetMapping(value = "rest/DisplayTableOrdersContent", produces = "application/json") // get
	public List<OrdersData> getAllRecords() {

		return service.getdetails();

	}

	@PostMapping(value = "rest/AddingData") // add
	public List<OrdersData> addOrders(@RequestBody OrdersData orders) {

		service.add(orders);
		return service.getdetails();

	}

	@GetMapping(value = "rest/SearchByInt/{orderId}") // search operation
	public OrdersData getById(@PathVariable int orderId) {

		return service.getByDetailsId(orderId);

	}

	@PutMapping(value = "rest/SearchByInt") // update(edit)
	public OrdersData update(@RequestBody OrdersData orders) {

		return service.updateOrderDetails(orders);

	}

	@DeleteMapping(value = "rest/DeleteSelectId") // delete
	public List<OrdersData> delete(@RequestBody OrdersData orders) {

		return service.delete(orders);

	}

	@GetMapping(value = "rest/connectionByInt/{orderId}") // search operation
	public List<OrdersDeliveryDetails> relational(@PathVariable int orderId) {

		return services.relationalConnectionFirstDomain(orderId);

	}

	// Second Domain Rest API'S

	@GetMapping(value = "rest/DisplayTableDeliverdContent", produces = "application/json") // get_data
	public List<OrdersDeliveryDetails> getAllRecord() {

		return services.getData();

	}

	@PostMapping(value = "rest/AddingDeliveryData") // add data
	public List<OrdersDeliveryDetails> addOrders(@RequestBody OrdersDeliveryDetails deliver) {

		services.add(deliver);
		return services.getData();

	}

	@PutMapping(value = "rest/EditDeliveryDataBydeliveredId") // update(edit)
	public OrdersDeliveryDetails update(@RequestBody OrdersDeliveryDetails deliver) {

		return services.updateDeliveryDetails(deliver);

	}

	@DeleteMapping(value = "rest/DeleteDeliveredSelectDeliveredId") // delete
	public List<OrdersDeliveryDetails> delete(@RequestBody OrdersDeliveryDetails deliver) {

		return services.delete(deliver);

	}

}
