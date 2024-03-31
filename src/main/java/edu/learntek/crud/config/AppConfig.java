package edu.learntek.crud.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:db-config.properties")
public class AppConfig {
	
	@Value("${db.driver.name}")
	private String driverClassName;
	
	@Value("${db.connection.url}")
	private String connectionURL;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Bean
	public DataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("driverClassName : "+driverClassName);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(connectionURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate myJdbbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();		
		return restTemplate;
	}
	
}
