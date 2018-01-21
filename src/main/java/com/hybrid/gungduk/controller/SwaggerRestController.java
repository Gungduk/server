package com.hybrid.gungduk.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="swag-rest-controller", description="swagtest")
@RequestMapping(value="/api/v1/restTest")
public class SwaggerRestController {

	@RequestMapping(value="/hello/{name}")
	public String getHelloName(@PathVariable(value="name") String name){
		return "Hello " + name;
	}
}
