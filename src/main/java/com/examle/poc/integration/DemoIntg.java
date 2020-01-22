package com.examle.poc.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.poc.configuration.LogConfiguration;
/*
 *  Persistance Logic section 
 *  */

@Component
@ConfigurationProperties("demo")
public class DemoIntg {

	private String environment;
	private List<String> hosts = new ArrayList<String>();

	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public List<String> getHosts() {
		return hosts;
	}


	public void setHosts(List<String> hosts) {
		this.hosts = hosts;
	}


	public String getMessage() {		
		return "Hello there !";		
	}
	
	
	public Map<String, String> getProperty() {
		System.out.println(environment);
		System.out.println(hosts);
		return LogConfiguration.properties;
	}
}
