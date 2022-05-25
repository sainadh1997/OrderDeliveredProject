package org.ordersdelivered.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.ordersdelivered.domain.OrdersDeliveryDetails;
import org.ordersdelivered.services.OrderDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ManuhServices")
public class DeliveredController {

	@Autowired
	OrderDeliveryService services;

	Logger logger = Logger.getLogger(DeliveredController.class.getName());

	@GetMapping("/EnteringDeliveredUpdates/{orderId}")
	public String addingDeliveredData(@PathVariable String orderId, Model uiModel) {
		uiModel.addAttribute("orderId", orderId);
		uiModel.addAttribute("deliver", new OrdersDeliveryDetails()); 
		return "adddelivery";
	}

	@PostMapping("/EnteringDeliveredUpdates")
	public String addDelivered(@Valid @ModelAttribute("deliver") OrdersDeliveryDetails deliver, BindingResult error, Model uiModel) throws SQLException {
		if(error.hasErrors()) {
			logger.info("error" + error);
			return "adddelivery";
		}
		services.add(deliver);   

		logger.info("Added delivered data sucessfully ");
		List<OrdersDeliveryDetails> deliveredList = services.getData();
		uiModel.addAttribute("deliveredList", deliveredList);
		return "table_formet_deliverydata";
	}

	@GetMapping("/DisplayTableDeliverContent")
	public String getDeliveresDetails(Model uiModel) {
		List<OrdersDeliveryDetails> deliveredList = services.getData();
		uiModel.addAttribute("deliveredList", deliveredList);
		return "table_formet_deliverydata";
	}

	@GetMapping("/DeleteDeliver")
	public String deleteDeliverRecord(@ModelAttribute OrdersDeliveryDetails deliver, Model uiModel) {
		services.delete(deliver);
		logger.info(" Delete particular deliver record with " + deliver + "deliver ID");
		List<OrdersDeliveryDetails> deliveredList = services.getData();
		uiModel.addAttribute("deliveredList", deliveredList);
		return "table_formet_deliverydata";
	}

	@GetMapping("/EditDeliver/{deliveredId}")
	public String getUpdates(@PathVariable String deliveredId, Model uiModel) {
		OrdersDeliveryDetails deliver = services.SpecificDeliveryOutput(Integer.parseInt(deliveredId));
		uiModel.addAttribute("deliver", deliver); 
		return "editdelivery";
	}

	@PostMapping("/EditDeliver")
	public String editDeliverRecord(@Valid @ModelAttribute("deliver") OrdersDeliveryDetails deliver,BindingResult error, Model uiModel) {
		
		if(error.hasErrors()) {
			logger.info("error" + error);
			return "editdelivery";
		}
		
		services.updateDeliveryDetails(deliver);
		logger.info("update particular deliver record with " + deliver + "deliver ID");
		List<OrdersDeliveryDetails> deliveredList = services.getData();
		uiModel.addAttribute("deliveredList", deliveredList);
		return "table_formet_deliverydata";
	}

}
