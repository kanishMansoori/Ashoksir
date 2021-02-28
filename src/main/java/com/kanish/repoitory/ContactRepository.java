package com.kanish.repoitory;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanish.entity.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Serializable>{

	
	
	
}
