package com.uh.jss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uh.jss.entity.Learner;
import com.uh.jss.entity.SwimBooking;
import com.uh.jss.entity.TimeTable;

public class BookSwimLesson {

	List<List<?>> updatedList = new ArrayList<>();
	
	public List<List<?>> bookASession(List<TimeTable> timetable, List<SwimBooking> bookingData,String learnerID, Learner learner){
		Scanner sc = new Scanner(System.in);
		BookSwimLesson gs = new BookSwimLesson();
		int gradeLevel = Integer.valueOf(learner.getCurrentGradeLevel());

		
		System.out.println("Choose option to get your timetalbe");
		System.out.println("1 - Monday/Wednesday/Friday/Saturday\n2 - View by Grade Level\n3 - View by Coach's Name");
		System.out.println("Enter your option");
		int choice = sc.nextInt();
		
		int classId=0;
		
		  while(choice<1 || choice > 3) { 
			  System.out.println("Enter valid option\n1 - Monday/Wednesday/Friday/Saturday\n2 - View by Grade Level\n3 - View by Coach's Name");
			  choice = sc.nextInt(); 
		  }
		 
		if(choice == 2) { //get time table with fitness type
			
			System.out.println("choose Grade Level: (1 - Grade 1, 2 - Grade 2, 3 - Grade 3, 4 - Grade 4, 5 - Grade 5)");
			String gradeId = sc.next();
			String grade = "";
			if (gradeId.equalsIgnoreCase("1")) {
				grade ="grade 1";	
			}
			else if (gradeId.equalsIgnoreCase("2")) {
				grade ="grade 2";	
			} 
			else if (gradeId.equalsIgnoreCase("3")) {
				grade ="grade 3";	
			} 
			else if (gradeId.equalsIgnoreCase("4")) {
				grade ="grade 4";	
			} 
			else if (gradeId.equalsIgnoreCase("5")) {
				grade ="grade 5";	
			} 
			
			int count=0;
			System.out.println("=================================================================================");
			System.out.println("ClassID\t\tGrade\t\tDate\t\ttime\tvacancies\tcoach\t\tDay");
			System.out.println("---------------------------------------------------------------------------------");
			for (TimeTable ttble:timetable) {
				if(ttble.getGrade().equalsIgnoreCase(grade)) {
					System.out.println(ttble.getSwimID()+"\t\t"
							+ttble.getGrade()+"\t\t"
							+ttble.getDate()+"\t"
							+ttble.getTime()+"\t   "
							+
							Integer.valueOf(4-Integer.valueOf( ttble.getCurrent_booking_count()))

							+"\t\t"
							+ttble.getCoach()
							+"\t\t"
							+ttble.getDay()
							
							);
					count++;
				}
			
			}
			System.out.println("---------------------------------------------------------------------------------");
		
			if(count==0) {
				System.out.println("Don't have Fitness classes with "+grade
						+"\nwe have different grade level like(1 - Grade 1, 2 - Grade 2, 3 - Grade 3, 4 - Grade 4, 5 - Grade 5");
				return null;
			}
			
		}
		else if (choice==1) { //get timetable with Saturday or Sunday
			
			System.out.println("choose options:\n1 - Monday\n2 - Wednesday\n3 - Friday\n4 - Saturday");
			int satSun= sc.nextInt();
			
			
			while(satSun<1 || satSun > 4) { 
				  System.out.println("Enter valid option\n1 - Monday\n2 - Wednesday\n3 - Friday\n4 - Saturday");
				  satSun = sc.nextInt(); 
			  }
			
			String day = "";
			if (satSun==1) {
				day ="monday";
				
			}
			else if (satSun ==2) {
				day = "wednesday";
			}
			else if (satSun ==3) {
				day = "friday";
			}
			else if (satSun ==4) {
				day = "saturday";
			}
			else {
				System.out.println("you have choosen wrong option\nStart booking again");
				return null;
			}
			System.out.println("=================================================================================");
			System.out.println("ClassID\t\tGrade\t\tDate\t\ttime\tvacancies\tcoach\t\tDay");
			System.out.println("---------------------------------------------------------------------------------");
			for (TimeTable ttble:timetable) {
				if(ttble.getDay().equalsIgnoreCase(day)) {
					System.out.println(ttble.getSwimID()+"\t\t"
							+ttble.getGrade()+"\t\t"
							+ttble.getDate()+"\t"
							+ttble.getTime()+"\t   "
							+
							Integer.valueOf(4-Integer.valueOf( ttble.getCurrent_booking_count()))

							+"\t\t"
							+ttble.getCoach()
							+"\t\t"
							+ttble.getDay()
							
							);
				}
			
			}
			System.out.println("---------------------------------------------------------------------------------");
		
		
		}
		
		else if(choice == 3) { //get time table with coach's name
			
			System.out.println("Enter coach's name: (sample input: George, Danny, Lara, Harry, Sophia)");
			String coach_name = sc.next();
			
			
			int count=0;
			System.out.println("=================================================================================");
			System.out.println("ClassID\t\tGrade\t\tDate\t\ttime\tvacancies\tcoach\t\tDay");
			System.out.println("---------------------------------------------------------------------------------");
			for (TimeTable ttble:timetable) {
				if(ttble.getCoach().equalsIgnoreCase(coach_name)) {
					System.out.println(ttble.getSwimID()+"\t\t"
							+ttble.getGrade()+"\t\t"
							+ttble.getDate()+"\t"
							+ttble.getTime()+"\t   "
							+
							Integer.valueOf(4-Integer.valueOf( ttble.getCurrent_booking_count()))

							+"\t\t"
							+ttble.getCoach()
							+"\t\t"
							+ttble.getDay()
							
							);
					count++;
				}
			
			}
			System.out.println("---------------------------------------------------------------------------------");
		
			
		
			if(count==0) {
				System.out.println("Don't have classes with "+coach_name
						+"\nwe have different coach name like  (sample input: coach 1, coach 2, coach 3)");
				return null;
			}
			
		}
		
		System.out.println("Enter classId you wanna join");
		classId = sc.nextInt();

		TimeTable classRecord = null;
		for (TimeTable ttble:timetable) {

			if(ttble.getSwimID().equals(String.valueOf(classId))) {
				classRecord = ttble;

				break;
			}
		}
		

		int enrollCount = gs.getEnrollCount(timetable, classId);
		int gradeCheck = Integer.valueOf(classRecord.getGrade().split(" ")[1]) - gradeLevel;
		
		if(enrollCount==-1) {
			System.out.println("you have entered wrong data.. So starting booking a class again");
			return null;
		}
		else if(gradeCheck>1) {
			System.out.println("you are not allowed to book higher level's.. You can just book one level higher to your current level ");
			return null;
		}
		else if((enrollCount+1)>4) {
			System.out.println("Class is already full... Please choose some different class and start booking again!!");
			return null;
		}
		else if(gs.isAlreadyEnrolled(learnerID,bookingData,classRecord.getGrade())) {
			System.out.println("Already you have enrolled for this class..."
					+ "\nChoose different class and book again!!!");
			
		}


		else {
			//update timetable & booking list
			
			timetable = gs.updateTimetable(timetable, classId, 1);
			bookingData = gs.updateBookingDetails(bookingData, classRecord,learnerID);
			System.out.println("Booking lesson is successful");
		
		}
		
		updatedList.clear();
		updatedList.add(timetable);
		updatedList.add(bookingData);
		
		return updatedList;
	}
	

	private boolean isAlreadyEnrolled(String custID, List<SwimBooking> bookingData, String fitness) {
		for (SwimBooking bdata:bookingData) {

			if(bdata.getLearnerID().equals(custID) && bdata.getGradeLevel().equals(fitness)  ) {
				return true;
			}
			
		}
		return false;
	}
	
	private List<SwimBooking> updateBookingDetails(List<SwimBooking> bookingData,TimeTable fitnessInfo,String custId) {
		List<SwimBooking> bookingList = new ArrayList<>();
		for(SwimBooking temp:bookingData) {
			bookingList.add(temp);
		}
		int rowId = bookingData.size()+1;

		bookingList.add(new SwimBooking(String.valueOf(rowId),custId, fitnessInfo.getGrade(), fitnessInfo.getCoach(), fitnessInfo.getDate(), fitnessInfo.getTime(), "booked", "", "", fitnessInfo.getSwimID()));
		
		return bookingList;
	}

	public int getEnrollCount(List<TimeTable> classInfo, int classID) {
				
		for( TimeTable cinfo:classInfo) {
			if(cinfo.getSwimID().equals(String.valueOf(classID))) {
				return Integer.valueOf(cinfo.getCurrent_booking_count());
			}
		}
		return -1;
	}

	public List<TimeTable> updateTimetable(List<TimeTable> tTable,int classId, int attendees){
		List<TimeTable> newList = new ArrayList<>();
		
		for( TimeTable ttInfo:tTable) {
			if(ttInfo.getSwimID().equals(String.valueOf(classId))) {
				int count = Integer.valueOf(ttInfo.getCurrent_booking_count())+attendees;

				TimeTable tt = new TimeTable(
						 ttInfo.getSwimID(), ttInfo.getGrade(), ttInfo.getDate(), ttInfo.getTime(), 
						 String.valueOf(count), ttInfo.getCoach(),ttInfo.getDay()							
						);
				
				
					newList.add(tt);
					
						
			}
			else {
				newList.add(ttInfo);
			}
		}
		
		return newList;
	}

}
