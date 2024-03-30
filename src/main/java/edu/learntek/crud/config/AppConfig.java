package edu.learntek.crud.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate myJdbbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource());
		return jdbcTemplate;
	}
}
