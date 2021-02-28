package com.kanish.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanish.entity.Contact;
import com.kanish.exception.NoDatafoundException;
import com.kanish.service.ContactService;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/api/contact")
public class ContactController {
      
	Logger logger=LoggerFactory.getLogger(ContactController.class);
	
	private ContactService service;
	
	public ContactController(ContactService service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		    logger.debug("** saveContact  Start**");
		try {
			boolean isSave = service.saveContact(contact);
			if(isSave) {
				logger.info("**saveContact successfully");
			return new ResponseEntity<>("Contact save",HttpStatus.CREATED);
		}
		}
		catch (Exception e) {
			logger.error("**  saveContact  exception "+e.getMessage());
		}
		logger.info("**Fail to  saveContact *** ");
		return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> allContact =null;
		 logger.debug("** getAllContact() Start");
		try {
			allContact = service.getAllContact();
			if(allContact.isEmpty()) {
			logger.info(" *** getAllContact  no contact Available ");	
			}
			
		}catch (Exception e) {
			logger.error(" ***  saveContact  Exception"+e.getMessage());
		}
		logger.info("*** getAllContact  *** End ");
		return new ResponseEntity<List<Contact>>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactByID(@PathVariable Integer id){
		Contact contact =null;
		logger.debug("** getContactByID  Start ");
		try {
			  contact = service.getContactById(id);
			 if(contact==null) {
				 logger.info("** getContactByID  No Data found *** ");
				 throw new NoDatafoundException("Not found");
			 }
			
		}catch (Exception e) {
			logger.error("**  getContactByID  get exception"+e.getMessage());
			
		}
		logger.info("** getContactByID end  **");
		return new ResponseEntity<Contact>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer id){
		ResponseEntity<String> respoEntity;
		logger.debug("** deleteContactById Start **** ");
		try {
			boolean isdeleted = service.deleteContactById(id);
			if(isdeleted) {
				logger.info("** deleteContactById  Deleted contact successfully****");
				 respoEntity =new ResponseEntity<String>("Deleted Contact",HttpStatus.OK);
			}
			
		} catch (Exception e) {
			logger.error("*** deleteContactById exception"+e.getMessage());
		}
		
		logger.info("*** deleteContactById  Contact not found");
		 respoEntity= new ResponseEntity<String>("Not found",HttpStatus.NOT_FOUND);
		return respoEntity;
	}

}
