package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the category from context
		product = (Product)context.getBean("product");
		
	}
@Ignore

	@Test
	public void createProductTestCase()
	{
		
		product.setId("SamsungTest1");
		product.setName("Samsung S8 256gb");
		product.setDescription("Brand new Samsung S8 64gb blue");
		product.setPrice(70000);
		product.setCategory_id("Laptop1");
		product.setSupplier_id("BigC");
		product.setQuantity(4);
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	@Ignore

	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 

}
