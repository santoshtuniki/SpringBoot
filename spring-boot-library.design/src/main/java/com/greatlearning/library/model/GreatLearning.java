package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode. => @Data

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
//	private String instructorName;
	private FullName instructorName;

	public GreatLearning(String courseName) {
		this.courseName = courseName;
	}

	public GreatLearning(String courseName, String courseType) {
		this.courseName = courseName;
		this.courseType = courseType;
	}

}
