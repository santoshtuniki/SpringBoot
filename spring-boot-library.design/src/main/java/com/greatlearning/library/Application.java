package com.greatlearning.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello Spring Boot");
		System.out.println("Hello Dev-Tools");
	}

	@Override
	public void run(String... args) throws Exception {
//		GreatLearning greatlearning = new GreatLearning();
//		greatlearning.setCourseName("Designing Microservices with Spring Boot");
//		greatlearning.setCourseType("Information Technology");
////		greatlearning.setInstructorName("Samarth Narula");
//		System.out.println("Get GreatLearning Object: " + greatlearning);
//
////		GreatLearning greatlearningUsingAllArgsConstructor = new GreatLearning(
////				"Designing Microservices with Spring Boot", "Information Technology", "Samarth Narula");
////		System.out
////				.println("Get GreatLearning Object with AllArgsConstructor : " + greatlearningUsingAllArgsConstructor);
//
//		// Design Pattern
//		GreatLearning greatlearningTeleDesignPattern = new GreatLearning("Learn Creational Design Pattern", "IT");
//		System.out.println("GreatLearning with Tele Design Pattern: " + greatlearningTeleDesignPattern);
//
//		// Builder Pattern
//		GreatLearning greatlearningBuilderPattern = GreatLearning.builder().courseName("Learn Builder Pattern")
//				.courseType("IT").build();
//		System.out.println("GreatLearning with Builder Pattern: " + greatlearningBuilderPattern);
//
//		GreatLearning greatlearningOnlyCourseName = GreatLearning.builder().courseName("Advantages of Builder Pattern")
//				.build();
//		System.out.println("GreatLearning Object with Only CourseName: " + greatlearningOnlyCourseName);

		GreatLearning greatlearningComplexObject = GreatLearning.builder()
				.courseName("Complex Object Creation using Builder Pattern").courseType("Information Technology")
				.instructorName(FullName.builder().firstName("Samarth").lastName("Narula").build()).build();
//		System.out.println("GreatLearning Complex Object: " + greatlearningComplexObject);
		log.info("GreatLearning Complex Object: {} ", greatlearningComplexObject);

	}

}
