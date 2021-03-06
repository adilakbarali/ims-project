package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAO {

	public static final Logger LOGGER = LogManager.getLogger();

	public OrdersItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("fk_order_id");
		Long itemId = resultSet.getLong("fk_item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrdersItems(orderId, itemId, quantity);
	}
	
	public String modelFromResultSetCost(ResultSet resultSet) throws SQLException {
		return "Order id: " + resultSet.getString("fk_order_id") + " Total Cost: ?" + resultSet.getDouble("cost");	
	}

	/**
	 * Reads the latest OrdersItems entry in the database
	 * @return the most recent OrdersItems
	 */
	public OrdersItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY fk_order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	public OrdersItems create(OrdersItems ordersItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(fk_order_id, fk_item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, ordersItems.getOrderId());
			statement.setLong(2, ordersItems.getItemId());
			statement.setLong(3, ordersItems.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Runs a query to calculate the cost for a particular order in the database
	 * 
	 * @param orderId - The id of the order that the cost needs to be calculated for
	 * 
	 * @return
	 */
	public String calculateCost(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT oi.fk_order_id, sum(oi.quantity*i.value) AS cost FROM orders_items oi JOIN items i ON i.id = oi.fk_item_id WHERE oi.fk_order_id = ? ORDER BY cost;");) {
			statement.setLong(1, orderId);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return modelFromResultSetCost(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param orderId - The id of the order that contains an item that needs to be deleted
	 * 
	 * @param itemId - The id of the item to be deleted from the order
	 * 
	 * @return
	 */
	public int deleteItem(long orderId, long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE fk_order_id = ? AND fk_item_id = ?");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * 
	 * @param orderId - The id of the order to be deleted
	 * 
	 * @return
	 */
	public int deleteOrder(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE fk_order_id = ?");) {
			statement.setLong(1, orderId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
