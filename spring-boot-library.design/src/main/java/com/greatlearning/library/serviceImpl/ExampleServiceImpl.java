package com.greatlearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning greatlearning = new GreatLearning();
		greatlearning.setCourseName("Learn Controllers in Spring Boot");
		greatlearning.setCourseType("Information Technology");
		greatlearning.setInstructorName(FullName.builder().firstName("Samarth").lastName("Naruel").build());
//		greatlearning.setInstructorName("Samrath Narual");
		return greatlearning;
	}

	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning greatlearning = new GreatLearning();
		greatlearning.setCourseName(courseName);
		greatlearning.setCourseType(courseType);
		greatlearning.setInstructorName(FullName.builder().firstName(firstName).lastName(lastName).build());
//		greatlearning.setInstructorName(instructorName);
		return greatlearning;
	}

}
