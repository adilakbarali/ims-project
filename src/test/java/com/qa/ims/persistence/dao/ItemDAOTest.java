package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO(); 
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/ims_test_schema.sql", "src/test/resources/ims_test_data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(6L, "55in 4K TV", 799.99);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Monitor", 129.99));
		expected.add(new Item(2L, "Keyboard", 29.99));
		expected.add(new Item(3L, "Mouse", 15.99));
		expected.add(new Item(4L, "Headset", 22.99));
		expected.add(new Item(5L, "8GB Flash Drive", 9.99));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(5L, "8GB Flash Drive", 9.99), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final Long ID = 1L;
		assertEquals(new Item(1L, "Monitor", 129.99), DAO.read(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(5L, "Laptop", 1499.99);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(4));
	}
}
