package com.uh.jss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.uh.jss.entity.Learner;
import com.uh.jss.entity.SwimBooking;
import com.uh.jss.entity.TimeTable;
import com.uh.jss.util.LearnerUtil;

public class ModifyBooking {


	private List<TimeTable> timeTableMod;
	private List<SwimBooking> bookingDataMod;

	private List<List<?>> modifiedList = new ArrayList<>();
	public List<List<?>>  cancelBooking(List<TimeTable> timeTableList, List<SwimBooking> bookingDetailsList, HashMap<String,Learner> learnerInfo) {
		
		Scanner sc = new Scanner(System.in);

		LearnerUtil learnerUtil = new LearnerUtil();

		BookSwimLesson gs = new BookSwimLesson();
		ModifyBooking modify = new ModifyBooking();
		System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");

		String learnerId = sc.next();

		boolean isLearnerValid = learnerUtil.validateLearner(learnerId,learnerInfo);
		while(!isLearnerValid) {
			System.out.println("You have entered wrong learner\n"
					+ "Enter Valid learner ID:");
			learnerId  = sc.next();
			isLearnerValid = learnerUtil.validateLearner(learnerId,learnerInfo);
		}
		System.out.println("Availble bookings with this customer ID:"+learnerId);

		System.out.println("======================================================");
		System.out.println("BookingId\t Fitness \t Date\t\t Status");
		System.out.println("======================================================");
		
		int count=0;
		for(SwimBooking data :bookingDetailsList) {
			if(data.getLearnerID().equalsIgnoreCase(learnerId)) {

						System.out.println(
								data.getId()+"\t\t"+
								data.getGradeLevel()+"\t\t"+
								data.getDate()+"\t"+		
								data.getStatus()
						);
			}

			if(data.getLearnerID().equals(learnerId)&& data.getStatus().equals("booked")) {
				count++;
			}
		}
		System.out.println("--------------------------------------------------------");
		if(count ==0) {
			System.out.println("You don't have any pending sessions to attend.. ");
			return null;
		}
		System.out.println("enter booking Id to cancel the session");
		String cancelId = sc.next();
		boolean flag = true;
		SwimBooking bookInfo = new SwimBooking();
		for(SwimBooking data :bookingDetailsList) {
			
			
			if(data.getId().equals(cancelId)&& data.getStatus().equals("booked")) {
				flag = false;
				bookInfo =data;
			}
		}
		if(flag) {
			System.out.println("Please choose class Id which is in booked status.. ");
			return null;
		}


		timeTableMod = gs.updateTimetable(timeTableList, Integer.valueOf(bookInfo.getSwimID()), -1);

		bookingDataMod = modify.updateStatus(bookingDetailsList, cancelId,"cancelled");
		
		modifiedList.clear();
		modifiedList.add(timeTableMod);
		modifiedList.add(bookingDataMod);
		System.out.println("You have successfully Cancelled you booking..");
		return modifiedList;

		
	}


	public List<SwimBooking> updateStatus(List<SwimBooking> bookingDetails,String bookingId,String status){
		List<SwimBooking> updatedList = new ArrayList<>();
		updatedList.clear();
		for( SwimBooking booking:bookingDetails) {
			if(booking.getId().equals(String.valueOf(bookingId))) {


				
				booking.setStatus(status);
				SwimBooking tempString = booking;

				updatedList.add(tempString);
			}
			else {
				updatedList.add(booking);
			}
			
		}
		return updatedList;
	}



	public List<List<?>>   changeBooking(List<TimeTable> timeTableList, List<SwimBooking> bookingDetailsList, HashMap<String,Learner> custInfo) {
				
		Scanner sc = new Scanner(System.in);

		LearnerUtil learnerUtil = new LearnerUtil();

		BookSwimLesson gs = new BookSwimLesson();
		ModifyBooking modify = new ModifyBooking();
		System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
		String custID = sc.next();
		boolean isCustomerValid = learnerUtil.validateLearner(custID,custInfo);
		while(!isCustomerValid) {
			System.out.println("You have entered wrong learnerId\n"
					+ "Enter Valid learner ID:");
			custID  = sc.next();
			isCustomerValid = learnerUtil.validateLearner(custID,custInfo);
		}
		System.out.println("Availble bookings with this customer ID:"+custID);

		System.out.println("======================================================");
		System.out.println("BookingId\t Fitness \t Date\t\t Status");
		System.out.println("======================================================");
		
		int count=0;
		for(SwimBooking data :bookingDetailsList) {
			if(data.getLearnerID().equals(custID)) {
				System.out.println(
				
						data.getId()+"\t\t"+data.getGradeLevel()+"\t\t"+
				 data.getDate()+"\t\t"+data.getStatus()
						);
			}
			if(data.getLearnerID().equals(custID)&& data.getStatus().equals("booked")) {
							count++;
			}
		}
		System.out.println("--------------------------------------------------------");
		if(count ==0) {
			System.out.println("You don't have any pending sessions to modify booking.. ");
			return null;
		}
		System.out.println("enter booking Id to modify the session");
		String modifyId = sc.next();
		boolean flag = true;
		SwimBooking bookInfo = new SwimBooking();
		for(SwimBooking data :bookingDetailsList) {
			
			if(data.getId().equals(modifyId)&& data.getStatus().equals("booked")) {
				flag = false;
				bookInfo =data;
			}
		}
		if(flag) {
			System.out.println("Please choose class Id which is in booked status.. ");
			return null;
		}
		

		timeTableMod = gs.updateTimetable(timeTableList, Integer.valueOf(bookInfo.getSwimID()), -1);
		bookingDataMod = modify.updateStatus(bookingDetailsList, modifyId,"changed");
		modifiedList.clear();
		
		modifiedList = gs.bookASession(timeTableMod,bookingDataMod,custID,learnerUtil.getLearner(custID,custInfo));

		modifiedList.clear();
		modifiedList.add(timeTableMod);
		modifiedList.add(bookingDataMod);

		System.out.println("Modified booking successful..");
		return modifiedList;
	}

	
}
