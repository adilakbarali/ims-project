package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long O_CID = 2L;
		final Order created = new Order(O_CID);
		
		Mockito.when(utils.getLong()).thenReturn(O_CID);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 2L));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testDelete() {
		final Long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test(expected = Test.None.class)
	public void testUpdateAddBranch() {
		final int MENU = 1;
		final Long O_ID = 3L, I_ID = 3L, I_QTY = 1L; 
		Mockito.when(utils.getInt()).thenReturn(MENU);
		Mockito.when(utils.getLong()).thenReturn(O_ID);
		Mockito.when(utils.getLong()).thenReturn(I_ID);
		Mockito.when(utils.getLong()).thenReturn(I_QTY);
		this.controller.update();
	}
	
	@Test(expected = Test.None.class)
	public void testUpdateDeleteBranch() {
		final int MENU = 2;
		final Long O_ID = 1L, I_ID = 1L;
		Mockito.when(utils.getInt()).thenReturn(MENU);
		Mockito.when(utils.getLong()).thenReturn(O_ID);
		Mockito.when(utils.getLong()).thenReturn(I_ID);
		this.controller.update();
	}
	
	@Test(expected = Test.None.class)
	public void testUpdateCalculateBranch() {
		final int MENU = 3;
		final Long O_ID = 1L;
		Mockito.when(utils.getInt()).thenReturn(MENU);
		Mockito.when(utils.getLong()).thenReturn(O_ID);
		this.controller.update();
	}
}
