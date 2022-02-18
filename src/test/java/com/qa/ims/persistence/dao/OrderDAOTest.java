package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/ims_test_schema.sql", "src/test/resources/ims_test_data.sql");
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(5L, 1L);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, "Keyboard", 29.99, 2L));
		expected.add(new Order(1L, 1L, "Monitor", 129.99, 1L));
		expected.add(new Order(1L, 1L, "Mouse", 15.99, 1L));
		expected.add(new Order(2L, 2L, "8GB Flash Drive", 9.99, 3L));		
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void readLatest() {
		assertEquals(new Order(4L, 4L), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L), DAO.read(1L));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(4));
	}
}
