package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

// A convenience annotation that is itself annotated with @Controller and @ResponseBody. => @RestController

//@Controller
@RestController
public class ExampleController {

	// @Autowired is equal to object creation in POJO
	// ExampleService exampleService = new ExampleService();

	@Autowired
	ExampleService exampleService;

//	@ResponseBody
	@GetMapping("/info")
	public GreatLearning get() {
		return exampleService.get();
	}

	@PostMapping("customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		return exampleService.customInfo(courseName, courseType, firstName, lastName);
	}

}
