import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

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



public class JSS_SwimApp {

	public static List<List<?>> modifiedLists;
	public static List<TimeTable> timeTableList;
	public static List<SwimBooking> bookingDetailsList;
	public static HashMap<String, Learner> learnerInfo;

	
	public static void main(String[] args) {


			System.out.println("**********************************************");
			System.out.println("Hatfield Junior Swimming School ");
			
			// the main functionalities 
			System.out.println("==============================================");
			System.out.println("1 - Book a Swim lesson");
			System.out.println("2 - Add a new learner");			
			System.out.println("3 - Change / Cancel a Lesson ");
			System.out.println("4 - Attend a Lesson");
			System.out.println("5 - Learner Report ");
			System.out.println("6 - Coach's overall Report ");
			System.out.println("7 - Exit System");
			System.out.println("---------------------------------------------");
			
			System.out.println("Choose the operation to perform ");
			System.out.println("Enter Operation ID:");
			// read the operation to perform  
			Scanner operation = new Scanner(System.in);

			TimeTableUtil tt = new TimeTableUtil();
			LearnerUtil learnerUtil = new LearnerUtil();

			BookSwimLesson bookSwimLesson = new BookSwimLesson();
			SwimBookingUtil swimBookingUtil = new SwimBookingUtil();
			bookingDetailsList = swimBookingUtil.getBookingDetails();
			ModifyBooking mod = new ModifyBooking();
			AddLearner addLearner = new AddLearner();
			AttendLesson attend = new AttendLesson();
			SwimReport swimReport = new SwimReport();

			learnerInfo= learnerUtil.loadLearnerDetails();
			timeTableList= tt.swimSchedule();
			
			int option =operation.nextInt();
			while (option!=7) {

				switch (option) {
				case 1: 
					
					System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
					String learnerID = operation.next();
					boolean isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
					while(!isLearnerValid) {
						System.out.println("You have entered wrong learnerID\n"
								+ "Enter Valid learner ID:");
						learnerID  = operation.next();
						isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
					}

					modifiedLists = bookSwimLesson.bookASession(timeTableList,bookingDetailsList, learnerID, learnerUtil.getLearner(learnerID,learnerInfo));

					if(modifiedLists==null) {
						break; 
					}

					
					List<?> rawTimeTableList = modifiedLists.get(0);
					if (rawTimeTableList != null && !rawTimeTableList.isEmpty() && rawTimeTableList.get(0) instanceof TimeTable) {
					    timeTableList = (List<TimeTable>) (List<?>) rawTimeTableList; // Safe cast because of the instance check
					} 
					

					// Extract and cast the second list
					List<?> rawBookingDetailsList = modifiedLists.get(1);
					if (rawBookingDetailsList != null && !rawBookingDetailsList.isEmpty() && rawBookingDetailsList.get(0) instanceof SwimBooking) {
					    bookingDetailsList = (List<SwimBooking>) (List<?>) rawBookingDetailsList; // Safe cast because of the instance check
					} 
					
				
					break;
				case 2: 

				learnerInfo = addLearner.addNewLearner(learnerInfo);

				break;
				case 3: 
					System.out.println("1-Change Booking \n2-Cancel booking\n"
							+ "Choose option to perform");
					int op = operation.nextInt();
					if(op==1) {
						modifiedLists = mod.changeBooking(timeTableList,bookingDetailsList,learnerInfo);
					}
					
					else 
						if(op==2) {
						modifiedLists=mod.cancelBooking(timeTableList,bookingDetailsList,learnerInfo);
					}	 

					if(modifiedLists==null) { break; }
					List<?> rawTimeTableList1 = modifiedLists.get(0);
					if (rawTimeTableList1 != null && !rawTimeTableList1.isEmpty() && rawTimeTableList1.get(0) instanceof TimeTable) {
					    timeTableList = (List<TimeTable>) (List<?>) rawTimeTableList1; // Safe cast because of the instance check
					} 
					
					rawBookingDetailsList = modifiedLists.get(1);
					if (rawBookingDetailsList != null && !rawBookingDetailsList.isEmpty() && rawBookingDetailsList.get(0) instanceof SwimBooking) {
					    bookingDetailsList = (List<SwimBooking>) (List<?>) rawBookingDetailsList; // Safe cast because of the instance check
					} 

					break;
					
				case 4: 
					System.out.println("Enter you learner ID: (Sample input: HJSS-001,HJSS-002, HJSS-003...HJSS-015)");
					learnerID = operation.next();
					 isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
					while(!isLearnerValid) {
						System.out.println("You have entered wrong learnerID\n"
								+ "Enter Valid Learner ID:");
						learnerID  = operation.next();
						isLearnerValid = learnerUtil.validateLearner(learnerID,learnerInfo);
					}
					SimpleEntry<List<SwimBooking>, HashMap<String, Learner>> updatedSessionData = 
							attend.attendASession(bookingDetailsList,learnerID, learnerInfo);
					
					bookingDetailsList = updatedSessionData.getKey();
					learnerInfo = updatedSessionData.getValue();
					
					break;
					
				
					
				case 5: 

					swimReport.LearnerReport(bookingDetailsList, learnerInfo, timeTableList);
					break;

				case 6: 	
					
					swimReport.coachReport(bookingDetailsList, learnerInfo, timeTableList);
					break;
					
				case 7: System.out.println("Exit system");
				break;
				}
				
				if (option!=7) {
					System.out.println("\n\n############################################");
					System.out.println("\t\tMain menu");
					System.out.println("############################################");
					System.out.println("1 - Book a Swim lesson");
					System.out.println("2 - Add a new learner");			
					System.out.println("3 - Change / Cancel a Lesson ");
					System.out.println("4 - Attend a Lesson");
					System.out.println("5 - Learner Report ");
					System.out.println("6 - Coach's overall Report ");
					System.out.println("7 - Exit System");
					System.out.println("---------------------------------------------");
					
					System.out.println(" Choose the operation to perform ");

					if (operation.hasNextInt()) {
					    option = operation.nextInt();
					} else {
					    System.out.println("No input provided, exiting.");
					    break; 
					}
				}

		}
	System.out.println("Thanks for using THE HATFIELD JUNIOR SWIMMING SCHOOL System... Exited Sucessfully!!!");

		
	}

}
