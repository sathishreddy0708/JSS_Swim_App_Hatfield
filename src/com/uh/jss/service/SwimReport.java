package com.uh.jss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.uh.jss.entity.Learner;
import com.uh.jss.entity.SwimBooking;
import com.uh.jss.entity.TimeTable;
import com.uh.jss.util.LearnerUtil;


public class SwimReport {

	public Boolean LearnerReport(List<SwimBooking> bookingDetailsList, HashMap<String, Learner> learnerInfo, List<TimeTable> timeTableList) {
		
		 HashMap<String, String> learnerMap= new HashMap<>();
		 Scanner operation = new Scanner(System.in);
		 System.out.println("enter month  (range between: 1 to 12)"); 
		  int month = operation.nextInt(); 
		  while (month < 1 || month > 12) {
			  System.out.println("enter valid month (range between: 1 to 12)"); 
			  month = operation.nextInt(); 
		  }
		for (Map.Entry<String, Learner> entry : learnerInfo.entrySet()) {
			 
			 String cc= entry.getKey();
			 learnerMap.put(cc, "attended,0,booked,0,cancelled,0");

			 for(SwimBooking bookingDetail:bookingDetailsList) {
				
				String expectedValue = cc;
				String actualValue = bookingDetail.getLearnerID();

				if(expectedValue.equalsIgnoreCase(actualValue) &&
						 bookingDetail.getDate().split("/")[1].equalsIgnoreCase(String.valueOf(month)))
				{

					if(learnerMap.get(cc)!=null) {

						String tempValue = learnerMap.get(cc);
						//update rating
						//attended
						if(bookingDetail.getStatus().equalsIgnoreCase("attended")
								) {
							
							int attendedCount = Integer.valueOf(tempValue.split(",")[1])+1;
							int bookedCount = Integer.valueOf(tempValue.split(",")[3])+0;
							int cancelledCount = Integer.valueOf(tempValue.split(",")[5])+0;
							

							learnerMap.replace(cc,tempValue.split(",")[0]+","+attendedCount+","+tempValue.split(",")[2]+","+bookedCount+","+tempValue.split(",")[4]+","+cancelledCount );

						}else if(bookingDetail.getStatus().equalsIgnoreCase("booked")) {
							int attendedCount = Integer.valueOf(tempValue.split(",")[1])+0;
							int bookedCount = Integer.valueOf(tempValue.split(",")[3])+1;
							int cancelledCount = Integer.valueOf(tempValue.split(",")[5])+0;
							
							learnerMap.replace(cc,tempValue.split(",")[0]+","+attendedCount+","+tempValue.split(",")[2]+","+bookedCount+","+tempValue.split(",")[4]+","+cancelledCount );

						}else if(bookingDetail.getStatus().equalsIgnoreCase("cancelled")) {
							
							int attendedCount = Integer.valueOf(tempValue.split(",")[1])+0;
							int bookedCount = Integer.valueOf(tempValue.split(",")[3])+0;
							int cancelledCount = Integer.valueOf(tempValue.split(",")[5])+1;
							
							learnerMap.replace(cc,tempValue.split(",")[0]+","+attendedCount+","+tempValue.split(",")[2]+","+bookedCount+","+tempValue.split(",")[4]+","+cancelledCount );

						}
					}
				}
			}
		}		
		 System.out.println("***** Learner Report  *****");
		 LearnerUtil  learnerUtil = new LearnerUtil();
		 for (Map.Entry<String, String> entry : learnerMap.entrySet()) {

	            String learnerId= entry.getKey();
	            String learnerData = entry.getValue();
	            if(!learnerData.equalsIgnoreCase("attended,0,booked,0,cancelled,0")) {
		            Learner learnerDetails = learnerUtil.getLearner(learnerId, learnerInfo);
		            System.out.println("Learner ID:"+learnerId);
		            System.out.println("Learner Name:"+ learnerDetails.getName());
		            System.out.println("Total Attended Lessons:"+learnerData.split(",")[1]);
		            System.out.println("Total Booked Lessons:"+learnerData.split(",")[3]);
		            System.out.println("Total Cancelled Lessons:"+learnerData.split(",")[5]+"\n");
	            }
        }
		 
		 System.out.println("Learner's Report generated Successfully...!!!");

		 return true;
	}

	public Boolean coachReport(List<SwimBooking> bookingDetailsList, HashMap<String, Learner> custInfo, List<TimeTable> timeTableList) {
		
		 
		 HashMap<String,String> ratingMap = new HashMap<String, String>();

		 Scanner operation = new Scanner(System.in);
		 System.out.println("enter month  (range between: 1 to 12)"); 
		  int month = operation.nextInt(); 
		  while (month < 1 || month > 12) {
			  System.out.println("enter valid month (range between: 1 to 12)"); 
			  month = operation.nextInt(); 
		  }
		 String []coachArray  = {"George", "Danny", "Lara", "Harry", "Sophia"};		 
		for (String coach : coachArray) {
			ratingMap.put(coach, "0");
			for(SwimBooking bookingDetail:bookingDetailsList) {
				String expectedValue = coach;
				String actualValue = bookingDetail.getCoach();
				
				String expectedStatusValue = "attended";
				String actualStatusValue = bookingDetail.getStatus();
				
				if(expectedValue.equalsIgnoreCase(actualValue)  && actualStatusValue.equalsIgnoreCase(expectedStatusValue)
						&&
						 bookingDetail.getDate().split("/")[1].equalsIgnoreCase(String.valueOf(month)))
						
				{

					
					if(ratingMap.get(coach)!=null && !ratingMap.get(coach).equalsIgnoreCase("0")) {

						String temp = ratingMap.get(coach);
						//update rating
						int updateValue = Integer.valueOf(bookingDetail.getRating())+Integer.valueOf(temp.split(",")[0]);
						
						int count = Integer.valueOf(temp.split(",")[1])+1;

						ratingMap.replace(coach,String.valueOf(updateValue)+","+count );

					}else {
					
					ratingMap.put(coach, bookingDetail.getRating()+",1");
					}
				}

			}
		}
		
		System.out.println("*******Overall Coach Report*******\n");
		 for (Map.Entry<String, String> entry : ratingMap.entrySet()) {
			 if(!entry.getValue().equalsIgnoreCase("0")){
	            double avgRating = Double.valueOf(entry.getValue().split(",")[0])/Double.valueOf(entry.getValue().split(",")[1]);
	            System.out.println("Coach Name:-->"+entry.getKey()+"\nAverage Rating: "+(avgRating)+"\nTotal number of learners attended your lessions:"+entry.getValue().split(",")[1]+"\n");
			 }
	        }
		return true;	
	}

}
