package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//mandatory
@ComponentScan(basePackages = {"dependency","dependent"})
public class ApplicationConfiguration {
//later  in Spring security we will add @Bean 
}
