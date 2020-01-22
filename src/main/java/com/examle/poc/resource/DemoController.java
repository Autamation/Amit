package com.examle.poc.resource;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examle.poc.process.DemoProcess;

/*
 *  Exposing the service using RestController 
 *  */

@RestController
public class DemoController {
	private DemoProcess process ;
	
	public DemoController(DemoProcess process) {
		super();
		this.process = process;
	}

	@GetMapping("getMsg")
	public String getMessage() {
		
		String message = process.getMessage();
		return message ;
		
	}
	
	@GetMapping("getProp")
public Map<String , String> getProperty(){
		
		Map<String , String> properties = process.getProperty();
		
		return properties ;
		
	}
}
