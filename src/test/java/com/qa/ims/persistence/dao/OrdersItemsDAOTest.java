package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAOTest {

	private final OrdersItemsDAO DAO = new OrdersItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/ims_test_schema.sql", "src/test/resources/ims_test_data.sql");
	}
	
	@Test
	public void testCreate() {
		final OrdersItems created = new OrdersItems(2L, 2L, 1L);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.deleteItem(1L, 1L));
	}
	
	@Test
	public void testCalculateCost() {
		String expected = "Order id: 1 Total Cost: £205.96";
		assertEquals(expected, DAO.calculateCost(1L));
	}
	
}
