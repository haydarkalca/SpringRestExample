package com.restexample.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfiguration {
	
	@Autowired
	private MyClassProperties myClassProperties;
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	@Bean
	public DataSource dataSource() throws SQLException{
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setUsername("xxx");
//		dataSource.setPassword("xxx");
//		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/testdatabase");
//		dataSource.setConnectionTimeout(8000);
//		return dataSource();
		
//		System.out.println("my class properties " + myClassProperties);
//		return DataSourceBuilder.create()
//				.url("jdbc:postgresql://localhost:5432/testdatabase")
//				.username("haydaruser").password("111222").build();
		
		return DataSourceBuilder.create()
				.url(dataSourceProperties.getUrl())
				.username(dataSourceProperties.getUsername()).password(dataSourceProperties.getPassword()).build();
		
	}

}
