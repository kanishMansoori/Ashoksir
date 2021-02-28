package com.kanish.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanish.entity.Contact;

@Service
public interface ContactService {
	
	public boolean  saveContact(Contact contact);
	public List<Contact> getAllContact();
	public Contact getContactById(Integer id);
	public boolean deleteContactById(Integer id);

}
