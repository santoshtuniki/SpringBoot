package com.greatlearning.ticket_tracker.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreatedDate {

	public static String getTodaysDate() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
