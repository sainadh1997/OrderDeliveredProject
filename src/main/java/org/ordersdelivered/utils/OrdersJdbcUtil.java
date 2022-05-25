package org.ordersdelivered.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.ordersdelivered.controller.OrderController;
import org.ordersdelivered.domain.OrdersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component

public class OrdersJdbcUtil {

	Logger logger = Logger.getLogger(OrderController.class.getName());

	@Autowired
	JdbcTemplate jdbc;

	public void insertOrderDetails(OrdersData jdbcOrder) {

		String query1 = "insert into itemsbooked(orderId,orderProductName,orderCustomerName,adress,phoneNumber,paymentMethod,productBooked) values(?,?,?,?,?,?,?)";
		jdbc.update(query1, jdbcOrder.getorderId(), jdbcOrder.getorderProductName(), jdbcOrder.getorderCustomerName(),
				jdbcOrder.getAdress(), jdbcOrder.getPhoneNumber(), jdbcOrder.getPaymentMethod(),
				(jdbcOrder.getproductBooked()));
		logger.info("inserted id" + jdbcOrder.getorderId());

	}

	public void deleteOneOrderDetails(OrdersData order) {
		// TODO Auto-generated method stub

		String query = "delete from itemsbooked where orderId = ?";
		jdbc.update(query, order.getorderId());
		logger.info("Delete particular order record with " + order + "order Id");

	}

	public OrdersData updateOrderDetails(OrdersData order) {
		// TODO Auto-generated method stub

		String query = "update itemsbooked set orderProductName=?,orderCustomerName=?,adress=?,phoneNumber=?,paymentMethod=?,productBooked=? where orderId=?;";
		jdbc.update(query, order.getorderProductName(), order.getorderCustomerName(), order.getAdress(),
				order.getPhoneNumber(), order.getPaymentMethod(), (order.getproductBooked()), order.getorderId());

		logger.info("From database " + order.getorderProductName() + "is updated into the order");

		return order;

	}

	public List<OrdersData> getdetails() {
		// TODO Auto-generated method stub

		List<OrdersData> orderList = new ArrayList<OrdersData>();

		String query = "select * from itemsbooked";
		orderList = jdbc.query(query,
				(rs, rowNum) -> new OrdersData(rs.getInt("orderId"), rs.getString("orderProductName"),
						rs.getString("orderCustomerName"), rs.getString("adress"), rs.getLong("phoneNumber"),
						rs.getString("paymentMethod"), rs.getDate("productBooked")));

		logger.info("list" + orderList);
		logger.info("From jdbc get all record is executed successfully");

		return orderList;

	}

	public OrdersData SpecificOrderOutput(int orderId) {
		// TODO Auto-generated method stub

		String sqlQuery = "select * from itemsbooked where orderId = ?";
		Object[] args = { orderId };
		OrdersData order = jdbc.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(OrdersData.class), args);
		return order;

	}

}

//doubts:-
// (OrdersData order)-> here "OrdersData" it is the data type and "order"-> it
// is called the obj
// obj contains some data which is related to the data type
