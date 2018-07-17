package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderTableDAO;
import com.niit.model.OrderTable;


public class OrderTableDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static OrderTable orderTable;
	
	@Autowired
	static OrderTableDAO orderTableDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		orderTableDAO =  (OrderTableDAO) context.getBean("orderTableDAO");
		
		//get the category from context
		
		orderTable = (OrderTable)context.getBean("orderTable");
		
	}
	
	
	@Ignore
	@Test
	public void createOrderTableTestCase(){
		//orderTable.setId(1);
		orderTable.setUser_id("suveen");
		//orderTable.setStatus("N");
		boolean flag = orderTableDAO.save(orderTable);
		assertEquals("createOrderTableTestCase", true, flag);
	}
	@Ignore
	@Test
	public void listTestCase(){
		int orderedSize = orderTableDAO.list("suveen").size();
		assertEquals(1, orderedSize);
	}

}
