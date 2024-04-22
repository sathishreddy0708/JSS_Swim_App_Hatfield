package com.uh.jss.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

import org.junit.jupiter.api.Test;

import com.uh.jss.entity.Learner;
import com.uh.jss.entity.SwimBooking;
import com.uh.jss.entity.TimeTable;
import com.uh.jss.service.AddLearner;
import com.uh.jss.service.AttendLesson;
import com.uh.jss.service.BookSwimLesson;
import com.uh.jss.service.ModifyBooking;
import com.uh.jss.service.SwimReport;
import com.uh.jss.util.LearnerUtil;
import com.uh.jss.util.SwimBookingUtil;
import com.uh.jss.util.TimeTableUtil;
 


class JssTests {



	@Test
	public void bookingTest() {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Booking Lesson method");
		List<TimeTable> timeTableList;
			List<SwimBooking> bookingDetailsList;
			HashMap<String, Learner> learnerInfo;
			SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
			bookingDetailsList = swimBookingUtil.getBookingDetails();;
			LearnerUtil learnerUtil = new LearnerUtil();
			TimeTableUtil tt = new TimeTableUtil();
			learnerInfo= learnerUtil.loadLearnerDetails();
			timeTableList= tt.swimSchedule();
			BookSwimLesson bookSwimLesson = new BookSwimLesson();
			Scanner operation = new Scanner(System.in);
			System.out.println("Enter you customer ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
			
			String learnerID = operation.next();
		boolean isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		while(!isLearnerValid) {
			System.out.println("You have entered wrong customerID\n"
					+ "Enter Valid Customer ID:");
			learnerID  = operation.next();
			isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		}
		List<List<?>> modifiedLists = bookSwimLesson.bookASession(timeTableList,bookingDetailsList, learnerID, learnerUtil.getLearner(learnerID,learnerInfo));
		assertNotNull(modifiedLists);

	}
	
	@Test
	public void attendLessonTest() {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Attending Lesson method");
		LearnerUtil learnerUtil = new LearnerUtil();
		HashMap<String, Learner> learnerInfo;

		learnerInfo= learnerUtil.loadLearnerDetails();
		Scanner operation = new Scanner(System.in);
		System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
		String learnerID = operation.next();
		Boolean isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		while(!isLearnerValid) {
			System.out.println("You have entered wrong learnerID\n"
					+ "Enter Valid Learner ID:");
			learnerID  = operation.next();
			isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		}
		List<SwimBooking> bookingDetailsList;
		SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
		bookingDetailsList = swimBookingUtil.getBookingDetails();;
		AttendLesson attend = new AttendLesson();
		SimpleEntry<List<SwimBooking>, HashMap<String, Learner>> updatedSessionData = 
				attend.attendASession(bookingDetailsList,learnerID, learnerInfo);
		
		assertNotNull(updatedSessionData);
		
			
	}

	@Test
	public void attendLessonTestNegative() {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Attending Lesson method");
		LearnerUtil learnerUtil = new LearnerUtil();
		HashMap<String, Learner> learnerInfo;

		learnerInfo= learnerUtil.loadLearnerDetails();
		Scanner operation = new Scanner(System.in);
		System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
		String learnerID = operation.next();
		Boolean isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		while(!isLearnerValid) {
			System.out.println("You have entered wrong learnerID\n"
					+ "Enter Valid Learner ID:");
			learnerID  = operation.next();
			isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
		}
		List<SwimBooking> bookingDetailsList;
		SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
		bookingDetailsList = swimBookingUtil.getBookingDetails();;
		AttendLesson attend = new AttendLesson();
		SimpleEntry<List<SwimBooking>, HashMap<String, Learner>> updatedSessionData = 
				attend.attendASession(bookingDetailsList,learnerID, learnerInfo);
		
		assertNotNull(updatedSessionData);
		
			
	}
	

	
	@Test
	public void changeBookingTest() {
		
		System.out.println("------------------------------------------------------");
		System.out.println("Testing change Booking method");
		List<TimeTable> timeTableList;
			List<SwimBooking> bookingDetailsList;
			HashMap<String, Learner> learnerInfo;
			SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
			bookingDetailsList = swimBookingUtil.getBookingDetails();
			ModifyBooking mod = new ModifyBooking();
			LearnerUtil learnerUtil = new LearnerUtil();
			TimeTableUtil tt = new TimeTableUtil();
			learnerInfo= learnerUtil.loadLearnerDetails();
			timeTableList= tt.swimSchedule();
			
		List<List<?>> modifiedLists  = mod.changeBooking(timeTableList,bookingDetailsList,learnerInfo);
		
		assertNotNull(modifiedLists);


	}
	
	@Test
	public void cancelBookingTest() {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Cancel Lesson method");
		List<TimeTable> timeTableList;
			List<SwimBooking> bookingDetailsList;
			HashMap<String, Learner> learnerInfo;
			SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
			bookingDetailsList = swimBookingUtil.getBookingDetails();
			ModifyBooking mod = new ModifyBooking();
			LearnerUtil learnerUtil = new LearnerUtil();
			TimeTableUtil tt = new TimeTableUtil();
			learnerInfo= learnerUtil.loadLearnerDetails();
			timeTableList= tt.swimSchedule();

		List<List<?>> modifiedLists = mod.cancelBooking(timeTableList,bookingDetailsList,learnerInfo);
		assertNotNull(modifiedLists);

	}
	
		
	@Test
	public void coachReportTest() throws IOException {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Coach Report method");
		 List<TimeTable> timeTableList;
		List<SwimBooking> bookingDetailsList;
		HashMap<String, Learner> learnerInfo;
		SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
		bookingDetailsList = swimBookingUtil.getBookingDetails();
		SwimReport swimReport = new SwimReport();
		LearnerUtil learnerUtil = new LearnerUtil();
		TimeTableUtil tt = new TimeTableUtil();
		learnerInfo= learnerUtil.loadLearnerDetails();
		timeTableList= tt.swimSchedule();
		boolean reportGenerated = swimReport.coachReport(bookingDetailsList , learnerInfo , timeTableList);
		assertEquals(reportGenerated, true);
	}
	
	@Test
	public void learnerReportTest() throws IOException {
		System.out.println("------------------------------------------------------");
		System.out.println("Testing Learner report method");
		 List<TimeTable> timeTableList;
			List<SwimBooking> bookingDetailsList;
			HashMap<String, Learner> learnerInfo;
			SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
			bookingDetailsList = swimBookingUtil.getBookingDetails();
			SwimReport swimReport = new SwimReport();
			LearnerUtil learnerUtil = new LearnerUtil();
			TimeTableUtil tt = new TimeTableUtil();
			learnerInfo= learnerUtil.loadLearnerDetails();
			timeTableList= tt.swimSchedule();
			boolean reportGenerated = swimReport.LearnerReport(bookingDetailsList , learnerInfo , timeTableList);
			assertEquals(reportGenerated, true);

	}


}
