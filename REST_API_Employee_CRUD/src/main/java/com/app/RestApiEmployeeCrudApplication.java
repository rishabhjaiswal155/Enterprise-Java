package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class RestApiEmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiEmployeeCrudApplication.class, args);
	}
@Bean
public ModelMapper modelMapper() {
	System.out.println("in modelmapper");
	ModelMapper mapper=new ModelMapper();
	mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	return mapper;
}
}