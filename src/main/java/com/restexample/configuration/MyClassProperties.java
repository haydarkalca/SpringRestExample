package com.restexample.configuration;

import java.util.List;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="my.class")
@Data
@Component
public class MyClassProperties {
	private Integer size;
	private String name;
	private String description;
	private List<String> servers;
}
