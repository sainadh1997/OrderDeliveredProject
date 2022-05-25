package org.ordersdelivered.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.ordersdelivered.domain.OrdersData;
import org.ordersdelivered.domain.OrdersDeliveryDetails;
import org.ordersdelivered.services.OrderDeliveryService;
import org.ordersdelivered.services.OrderService;
import org.ordersdelivered.validation.ValidationOrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ManuhServices")
public class OrderController {

	@Autowired
	OrderService service;

	@Autowired
	OrderDeliveryService services;

	Logger logger = Logger.getLogger(OrderController.class.getName());

	@GetMapping("/AddingData")
	public String addingOrders() {
		return "demo";
	}

	@PostMapping("/AddingData")
	public String addOrders(@ModelAttribute @Valid OrdersData order, Model uiModel, Errors errors) throws SQLException {

		String error = ValidationOrderUtil.validate(order);
		if (error != null && error.trim().length() > 0) {
			uiModel.addAttribute("order", order);
			uiModel.addAttribute("emptyFliedError", error);
			return "demo";
		}
		service.add(order);

		logger.info("Added orders data sucessfully ");
		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);

		return "table_formet_ordersdata";

	}

	@GetMapping("/DisplayTableOrdersContent")

	public String getOrdersDetails(Model uiModel) {

		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);

		return "table_formet_ordersdata";

	}

	@GetMapping("/DeleteSelectId")
	public String deleteOrderRecord(@ModelAttribute OrdersData order, Model uiModel) {
		service.delete(order);
		System.out.println(" Delete particular order record with " + order + "order ID");
		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);
		return "table_formet_ordersdata";

	}

	@GetMapping("/EditSpecificId")
	public String getUpdates(String orderId, Model uiModel) {
		OrdersData order = service.getByDetailsId(Integer.parseInt(orderId)); // SpecificOrderOutput(Integer.parseInt(orderId));
		uiModel.addAttribute("order", order);
		return "editOrders";
	}

	@PostMapping("/EditSpecificId")
	public String editOrderRecord(@ModelAttribute OrdersData order, Model uiModel) {

		String error = ValidationOrderUtil.validate(order);
		if (error != null && error.trim().length() > 0) {
			uiModel.addAttribute("order", order);
			uiModel.addAttribute("emptyFliedError", error);
			return "editOrders";
		}

		service.updateOrderDetails(order);
		logger.info("update particular order record with " + order + "order ID");
		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);
		return "table_formet_ordersdata";

	}

	@GetMapping("/SearchOrderysByInt")
	public String searchOrderId(String orderId, Model uiModel, HttpSession session) {

		OrdersData searchOrders = service.getByDetailsId(Integer.parseInt(orderId));

		uiModel.addAttribute("order", searchOrders);
		return "searchOrders";
	}

	@GetMapping("/homepage")
	public String backToHomePage() {
		return "homepage";

	}

	@GetMapping("/backbutton")
	public String backToReturn(Model uiModel) {
		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);
		return "table_formet_ordersdata";

	}

	@GetMapping("/firstDomainMenuPage")
	public String backToHome(Model uiModel) {
		List<OrdersData> orderList = service.getdetails();
		uiModel.addAttribute("orderList", orderList);
		return "table_formet_ordersdata";

	}

	@GetMapping("/RelationalConnection")
	public String viewPage(String orderId, Model uiModel) {
		List<OrdersDeliveryDetails> deliveredList = services.relationalConnectionFirstDomain(Integer.parseInt(orderId));
		logger.info("list size:" + deliveredList.size());
		uiModel.addAttribute("deliveredList", deliveredList);
		return "connection";

	}

}

//doubts:-
// @GetMapping("/homepage")--->the words contains in the bracket which is be
// same as the "href names"
// href will be in jsp pages...