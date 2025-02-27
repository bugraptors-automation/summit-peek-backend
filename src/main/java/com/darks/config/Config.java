package com.darks.config;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/deviceDetails/**").addResourceLocations("file:///home/darks/device_details/");
		registry.addResourceHandler("/tetraDetails/**").addResourceLocations("file:///home/darks/device_details/tetra_response/");

	}

}

