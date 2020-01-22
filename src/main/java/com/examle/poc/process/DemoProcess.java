package com.examle.poc.process;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examle.poc.integration.DemoIntg;

/*
 *  Bussiness Logic section 
 *  */

@Component
public class DemoProcess {

	@Autowired
	private DemoIntg intg ;
	
	public DemoProcess(DemoIntg intg) {
		this.intg = intg;
	}

	public String getMessage() {
		String message = intg.getMessage();
		return message;		
	}
	
	public Map<String, String> getProperty(){
		
		Map<String , String> properties = intg.getProperty();	
		return properties;	
	}
}
