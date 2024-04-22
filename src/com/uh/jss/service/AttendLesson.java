package com.uh.jss.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.uh.jss.entity.Learner;
import com.uh.jss.entity.SwimBooking;
import com.uh.jss.util.LearnerUtil;


public class AttendLesson {

	public SimpleEntry<List<SwimBooking>, HashMap<String, Learner>>  attendASession(List<SwimBooking> bookingDetailsList, String custID, HashMap<String,Learner> learnerInfo) {
		
		Scanner sc = new Scanner(System.in);
		AttendLesson attnd = new AttendLesson();
	
		System.out.println("Availble bookings with this customer ID:"+custID);
		System.out.println("======================================================");
		System.out.println("Id\t\t Grade \t Date\t\t Status");
		System.out.println("======================================================");
		
		int count=0;
		HashMap<String, String> idCheck = new HashMap<>();
		for(SwimBooking swimBooking :bookingDetailsList) {
			if(swimBooking.getLearnerID().equals(custID)) {
				System.out.println(
						swimBooking.getId()+"\t\t"+
								swimBooking.getGradeLevel()+"\t\t"+
								swimBooking.getDate()+"\t"+		
								swimBooking.getStatus()
						);
			}
			if(swimBooking.getLearnerID().equals(custID)&& swimBooking.getStatus().equals("booked")) {
				count++;
				idCheck.put(swimBooking.getId(), swimBooking.getStatus());
			}
		}
		
		System.out.println("--------------------------------------------------------");
		if(count ==0) {
			System.out.println("You don't have any pending sessions to attend.. ");

		    return new SimpleEntry<>(bookingDetailsList, learnerInfo);
		}
		System.out.println("enter booking Id to attend");
		String bookingId = sc.next();
		if(idCheck.containsKey(bookingId)) {
			
			System.out.println("Provide Session Rating rangin 1 - 5"
					+ "\n(1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied)");
			int rating = sc.nextInt();
			 while (rating < 1 || rating > 5) {
				  System.out.println("Provide valid Rating (Range between: 1 to 5)"); 
				  rating = sc.nextInt(); 
			  }
			System.out.println("Enter Review:");
			String review = sc.nextLine();
			review=sc.nextLine();
			bookingDetailsList = attnd.updateReview(bookingDetailsList, bookingId, rating,review);
			
			learnerInfo = updateLearnerGrade(learnerInfo,custID);
			
		}
		else {
			System.out.println("You have entered wrong booking id");
		}

	    return new SimpleEntry<>(bookingDetailsList, learnerInfo);
	}

	
	public List<SwimBooking> updateReview(List<SwimBooking> bookingDetails,String bookingId, int rating, String review){
		List<SwimBooking> updatedList = new ArrayList<>();
		updatedList.clear();
		for( SwimBooking booking:bookingDetails) {
			if(booking.getId().equals(String.valueOf(bookingId))) {
			
			booking.setStatus("attended");
			
			updatedList.add(booking);
			}
			else {
				updatedList.add(booking);
			}
			
		}
		System.out.println("Attended class successfully..");
		return updatedList;
	}
	
	 public HashMap<String, Learner> updateLearnerGrade(HashMap<String, Learner> learnerInfo, String learnerId) {
	        Learner learner = learnerInfo.get(learnerId);
        	int newGradeLevel = learner.getCurrentGradeLevel()+1;

	        if (learner != null && newGradeLevel<5) {
	            learner.setCurrentGradeLevel(newGradeLevel);
	            System.out.println("Grade level updated for Learner ID: " + learnerId + " to grade " + newGradeLevel);
	        } 
	        return learnerInfo; // Return the updated HashMap
	    }

	 public void displayAllLearners(HashMap<String, Learner> learnerInfo) {
	        for (Map.Entry<String, Learner> entry : learnerInfo.entrySet()) {
	            Learner learner = entry.getValue();
	            System.out.println("ID: " + entry.getKey() + ", Name: " + learner.getName() + ", Current Grade: " + learner.getCurrentGradeLevel());
	        }
	    }

}
