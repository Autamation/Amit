package com.example.poc.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LogConfiguration {

	public static Map<String , String> properties = new LinkedHashMap<String , String>();
	
	
	private static List<List<String>> props = new ArrayList<List<String>>();

	private LogConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		 Resource resource = new ClassPathResource("/properties/splunk");

		try (Stream<Path> walk = Files.walk(Paths.get(resource.getURI()))) {

			List<String> result = walk.map(x -> x.toString())
					.filter(f -> f.endsWith(".properties")).collect(Collectors.toList());
			result.stream().forEach(q ->{
				try {
					Files.lines(Paths.get(q)).map(s ->{
						return Arrays.asList(s.split(":")).stream().map(w -> w.trim()).collect(Collectors.toList());
					}).forEach(t -> props.add(t));
					
					props.stream().forEachOrdered(props ->{
						properties.put(props.get(0), props.get(1));
					});		

				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
	
