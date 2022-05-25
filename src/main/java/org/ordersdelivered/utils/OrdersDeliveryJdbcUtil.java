package org.ordersdelivered.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.ordersdelivered.domain.OrdersDeliveryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrdersDeliveryJdbcUtil {

	Logger logger = Logger.getLogger(OrdersDeliveryJdbcUtil.class.getName());

	@Autowired
	JdbcTemplate jdbc;

	public void insertOrderDetails(OrdersDeliveryDetails jdbcOrder) {

		String query1 = "insert into ordersdelivered(orderId,orderDeliveryStatus,paymentStatus,productReachedSafelyOrNot,DeliveredDate) values(?,?,?,?,?)";
		jdbc.update(query1, jdbcOrder.getOrderId(), jdbcOrder.getOrderDeliveryStatus(), jdbcOrder.getPaymentStatus(),
				jdbcOrder.getProductReachedSafelyOrNot(), (jdbcOrder.getDeliveredDate()));
		logger.info("inserted id" + jdbcOrder.getDeliveredId());

	}

	public List<OrdersDeliveryDetails> getDetails() {
		List<OrdersDeliveryDetails> details1 = new ArrayList<OrdersDeliveryDetails>();

		String query = "select * from ordersdelivered";
		details1 = jdbc.query(query,
				(rs, rowNum) -> new OrdersDeliveryDetails(rs.getInt("orderId"), rs.getString("orderDeliveryStatus"),
						rs.getString("paymentStatus"), rs.getString("productReachedSafelyOrNot"),
						rs.getInt("deliveredId"), rs.getDate("DeliveredDate")));

		logger.info("list" + details1);
		logger.info("From jdbc get all record is executed successfully");

		return details1;
	}

	public void deleteOneDeliveryDetails(OrdersDeliveryDetails jdbcOrder) {

		String query = "delete from ordersdelivered where deliveredId=?";
		jdbc.update(query, jdbcOrder.getDeliveredId());
		logger.info("Delete particular order record with " + jdbcOrder + "deliver Id");

	}

	public OrdersDeliveryDetails SpecificDeliveryOutput(int deliveredId) {

		String sqlQuery = "select * from ordersdelivered where deliveredId = ?";
		Object[] args = { deliveredId };
		OrdersDeliveryDetails delivered = jdbc.queryForObject(sqlQuery, 
				BeanPropertyRowMapper.newInstance(OrdersDeliveryDetails.class),args);

		return delivered;

	}

	public OrdersDeliveryDetails updateDeliveryDetails(OrdersDeliveryDetails jdbcOrder) {

		String query = "update ordersdelivered set orderDeliveryStatus=?,paymentStatus=?,productReachedSafelyOrNot=?,orderId=?,DeliveredDate=? where deliveredId=?";
		jdbc.update(query, jdbcOrder.getOrderDeliveryStatus(), jdbcOrder.getPaymentStatus(),
				jdbcOrder.getProductReachedSafelyOrNot(), jdbcOrder.getOrderId(), (jdbcOrder.getDeliveredDate()),
				jdbcOrder.getDeliveredId());

		System.out.println("From database " + jdbcOrder.getOrderDeliveryStatus() + "is updated into the jdbcOrder");

		return jdbcOrder;

	}

	public List<OrdersDeliveryDetails> relationalConnectionFirstDomain(int orderId) {

		List<OrdersDeliveryDetails> details1 = new ArrayList<OrdersDeliveryDetails>();

		String query = "select * from ordersdelivered where orderId=?";
		Object[] args = { orderId };
		details1 = jdbc.query(query, 
				(rs, rowNum) -> new OrdersDeliveryDetails(rs.getInt("orderId"), rs.getString("orderDeliveryStatus"),
						rs.getString("paymentStatus"), rs.getString("productReachedSafelyOrNot"),
						rs.getInt("deliveredId"), rs.getDate("DeliveredDate")),args);

		logger.info("list" + details1);
		logger.info("From jdbc get all record is executed successfully");
		return details1;

	}

}
