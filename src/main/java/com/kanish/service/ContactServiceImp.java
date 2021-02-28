package com.kanish.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.stereotype.Service;

import com.kanish.entity.Contact;
import com.kanish.exception.NoDatafoundException;
import com.kanish.repoitory.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {
	
	private ContactRepository repository;
	
    public ContactServiceImp(ContactRepository repository) {
    	this.repository=repository;
	}

	@Override
	public boolean saveContact(Contact contact) {
		  Contact save = repository.save(contact);
		return save.getContactID()!= null ? true:false;
	}

	@Override
	public List<Contact> getAllContact() {
		return repository.findAll();
		}

	@Override
	public Contact getContactById(Integer id) {
		Optional<Contact> findById = repository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer id) {
		
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception e){
			 throw new  NoDatafoundException("No found to deleted");
		}
		
	}
    

}
