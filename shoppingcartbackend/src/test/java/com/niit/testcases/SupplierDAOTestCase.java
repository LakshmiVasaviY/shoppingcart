package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;


public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		// get the category from context

		supplier = (Supplier) context.getBean("supplier");

	}
	@Ignore

	@Test
	public void createSupplierTestCase() {
		supplier.setId("BigC");
		supplier.setName("Sangeetha Mobiles");
		supplier.setDescription("Large Collection of Mobiles");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}
	@Ignore

	@Test
	public void updateSupplierTestCase() {
		supplier.setId("BigC");
		supplier.setName("BigC Mobiles");
		supplier.setDescription("Large Collection of Mobiles");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}
	@Ignore

	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}

}
