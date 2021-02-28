package com.kanish.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.convert.ConverterBuilder.WritingConverterBuilder;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kanish.controller.ContactController;
import com.kanish.entity.Contact;
import com.kanish.service.ContactService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@WebMvcTest(value = ContactController.class)
public class ContactControllerTest {
	
	@MockBean
	private ContactService service;
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void  saveContact() throws Exception {
		String json=null;
		when(service.saveContact(Mockito.any())).thenReturn(true);
		
		Contact  ct=new Contact(101,12356667l,"veeya","veeya@gmail.com");
		
		ObjectMapper mapper=new ObjectMapper();
	    try {
			 json=mapper.writeValueAsString(ct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/contact")
				                                                              .contentType("application/json")
				                                                              .content(json);
		                    
		MvcResult mvcresult = mockmvc.perform(requestBuilder).andReturn();
		     MockHttpServletResponse response = mvcresult.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(201, status);
		
	}
	@Test
	public void  saveContact_01() throws Exception {
		String json=null;
		when(service.saveContact(Mockito.any())).thenReturn(false);
		
		Contact  ct=new Contact(101,12356667l,"veeya","veeya@gmail.com");
		
		ObjectMapper mapper=new ObjectMapper();
	    try {
			 json=mapper.writeValueAsString(ct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/contact")
				                                                              .contentType("application/json")
				                                                              .content(json);
		                    
		MvcResult mvcresult = mockmvc.perform(requestBuilder).andReturn();
		     MockHttpServletResponse response = mvcresult.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(500, status);
		
	}
	@Test
	public void  saveContact_03() throws Exception {
		String json=null;
		when(service.saveContact(Mockito.any())).thenThrow(RuntimeException.class);
		
		Contact  ct=new Contact(101,12356667l,"veeya","veeya@gmail.com");
		
		ObjectMapper mapper=new ObjectMapper();
	    try {
			 json=mapper.writeValueAsString(ct);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/contact")
				                                                              .contentType("application/json")
				                                                              .content(json);
		                    
		MvcResult mvcresult = mockmvc.perform(requestBuilder).andReturn();
		     MockHttpServletResponse response = mvcresult.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(500, status);
		
	}
	@Test
	public void getAllContact_test_01() throws Exception {
		
		when(service.getAllContact()).thenReturn(Collections.EMPTY_LIST);
		  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/contact");
		  
		  MvcResult mvcresult = mockmvc.perform(requestBuilder).andReturn();
		     MockHttpServletResponse response = mvcresult.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(200, status);
		
		
	}
	
	@Test
	public void getAllContact_test_02() throws Exception {
		
		when(service.getAllContact()).thenThrow(RuntimeException.class);
		  MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/contact");
		  
		  MvcResult mvcresult = mockmvc.perform(requestBuilder).andReturn();
		     MockHttpServletResponse response = mvcresult.getResponse();
		     
		     int status = response.getStatus();
		     
		     assertEquals(200, status);
		
		
	}
	

}

