package com.kanish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "CONTACT_DTLS")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	@Id
	@GeneratedValue(generator="contact_id_seq",strategy = GenerationType.AUTO )
	@Column(name="CONTACT_ID")
	private Integer contactID;	
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	

}
