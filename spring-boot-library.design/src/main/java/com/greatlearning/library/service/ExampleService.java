package com.greatlearning.library.service;

import org.springframework.stereotype.Component;

import com.greatlearning.library.model.GreatLearning;

@Component
public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName);

}