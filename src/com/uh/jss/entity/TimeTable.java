package com.uh.jss.entity;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {
//	  swim_ID	grade	Date	time	current_booking_count	coach 	day

	public String swimID;
	public String grade;
	public String date;
	public String time;
	public String current_booking_count;
	public String coach; 	
	public String day;
	
	public TimeTable() {
		super();
	}
	
	public TimeTable(String swimID, String grade, String date, String time, String current_booking_count,
			String coach, String day) {
		super();
		this.swimID = swimID;
		this.grade = grade;
		this.date = date;
		this.time = time;
		this.current_booking_count = current_booking_count;
		this.coach = coach;
		this.day = day;
	}

	public String getSwimID() {
		return swimID;
	}

	public void setSwimID(String swimID) {
		this.swimID = swimID;
	}

	public String getGrade() {
		return grade;
	}

	public void setgrade(String grade) {
		this.grade = grade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCurrent_booking_count() {
		return current_booking_count;
	}

	public void setCurrent_booking_count(String current_booking_count) {
		this.current_booking_count = current_booking_count;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
