package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private final OrdersItemsDAO ordersItemsDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		ordersItemsDAO = new OrdersItemsDAO();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter a choice:");
		LOGGER.info("1. Add item to order");
		LOGGER.info("2. Delete item from order");
		LOGGER.info("3. Calculate order cost");
		int choice = utils.getInt();
		switch(choice) {
		case 1:
			LOGGER.info("Please enter the id of an order you would like to add an item to");
			Long orderId = utils.getLong();
			LOGGER.info("Please enter an item id to add to the order");
			Long itemId = utils.getLong();
			LOGGER.info("Please enter an item quantity to add to the order");
			Long quantity = utils.getLong();
			ordersItemsDAO.create(new OrdersItems(orderId, itemId, quantity));
			LOGGER.info("Order Updated");
			break;
		case 2:
			LOGGER.info("Please enter the id of an order you would like to delete an item from");
			Long orderDeleteId = utils.getLong();
			LOGGER.info("Please enter an item id to remove to the order");
			Long itemDeleteId = utils.getLong();
			ordersItemsDAO.deleteItem(orderDeleteId, itemDeleteId);
			LOGGER.info("Order Updated");
			break;
		case 3:
			LOGGER.info("Please enter the id of an order you would like to calculate the cost for");
			Long orderCostId = utils.getLong();
			LOGGER.info(ordersItemsDAO.calculateCost(orderCostId));
			break;
		}
		return null;
	}

	/**
	 * Deletes an existing order by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		ordersItemsDAO.deleteOrder(id);
		return orderDAO.delete(id);
	}

}
