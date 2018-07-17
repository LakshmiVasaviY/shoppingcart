package com.niit.dao;

import java.util.List;

import com.niit.model.Contact;


public interface ContactDAO {
	
	
	public  boolean save(Contact contact);
	
	// update the contact details  - update
	public boolean delete(int id);
	
	
	public List<Contact> list();
	
	
	//get contact details based on contactID
	
	public Contact getContactById(int id);
	
}
