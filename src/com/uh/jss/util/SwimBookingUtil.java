package com.uh.jss.util;

import java.util.ArrayList;
import java.util.List;

import com.uh.jss.entity.SwimBooking;

public class SwimBookingUtil {

	 private List<SwimBooking> bookingDetails;

	    public SwimBookingUtil() {
	        bookingDetails = new ArrayList<>();
	        loadBookingDetails();
	    }
//George, Danny, Lara, Harry, Sophia
	    private void loadBookingDetails() {
	       
	        addBooking(new SwimBooking("1", "HJSS-005", "Grade 3", "Lara", "4/3/2024", "4-5pm", "attended", "4", "good session", "1"));
	        addBooking(new SwimBooking("2", "HJSS-010", "Grade 2", "Danny", "4/3/2024", "5-6pm", "booked", "", "", "2"));
	        addBooking(new SwimBooking("3", "HJSS-002", "Grade 1", "George", "4/3/2024", "6-7pm", "cancelled", "", "", "3"));
	        addBooking(new SwimBooking("4", "HJSS-013", "Grade 4", "Harry", "6/3/2024", "4-5pm", "attended", "3", "improving", "4"));
	        addBooking(new SwimBooking("5", "HJSS-011", "Grade 5", "Sophia", "6/3/2024", "5-6pm", "booked", "", "", "5"));
	        addBooking(new SwimBooking("6", "HJSS-014", "Grade 3", "Lara", "6/3/2024", "6-7pm", "attended", "5", "consistent effort", "6"));
	        addBooking(new SwimBooking("7", "HJSS-004", "Grade 1", "George", "8/3/2024", "4-5pm", "cancelled", "", "", "7"));
	        addBooking(new SwimBooking("8", "HJSS-009", "Grade 2", "Danny", "8/3/2024", "5-6pm", "attended", "2", "needs focus", "8"));
	        addBooking(new SwimBooking("9", "HJSS-015", "Grade 4", "Harry", "8/3/2024", "6-7pm", "booked", "", "", "9"));
	        addBooking(new SwimBooking("10", "HJSS-008", "Grade 5", "Sophia", "9/3/2024", "2-3pm", "attended", "4", "good attitude", "10"));
	        addBooking(new SwimBooking("11", "HJSS-003", "Grade 2", "Danny", "9/3/2024", "3-4pm", "cancelled", "", "", "11"));
	        addBooking(new SwimBooking("12", "HJSS-001", "Grade 3", "Lara", "11/3/2024", "4-5pm", "booked", "", "", "12"));
	        addBooking(new SwimBooking("13", "HJSS-007", "Grade 1", "George", "11/3/2024", "5-6pm", "attended", "3", "energetic", "13"));
	        addBooking(new SwimBooking("14", "HJSS-012", "Grade 5", "Sophia", "11/3/2024", "6-7pm", "booked", "", "", "14"));
	        addBooking(new SwimBooking("15", "HJSS-006", "Grade 2", "Danny", "13/3/2024", "4-5pm", "attended", "5", "perfect attendance", "15"));
	        addBooking(new SwimBooking("16", "HJSS-001", "Grade 2", "Danny", "1/4/2024", "6-7pm", "booked", "", "", "47"));
	        addBooking(new SwimBooking("17", "HJSS-002", "Grade 3", "Lara", "3/4/2024", "4-5pm", "cancelled", "", "", "48"));
	        addBooking(new SwimBooking("18", "HJSS-003", "Grade 4", "Harry", "3/4/2024", "5-6pm", "attended", "5", "outstanding performance", "49"));
	        addBooking(new SwimBooking("19", "HJSS-004", "Grade 5", "Sophia", "3/4/2024", "6-7pm", "booked", "", "", "50"));
	        addBooking(new SwimBooking("20", "HJSS-005", "Grade 1", "George", "5/4/2024", "4-5pm", "attended", "4", "great stamina", "51"));
	        addBooking(new SwimBooking("21", "HJSS-006", "Grade 2", "Danny", "5/4/2024", "5-6pm", "booked", "", "", "52"));
	        addBooking(new SwimBooking("22", "HJSS-007", "Grade 3", "Lara", "5/4/2024", "6-7pm", "attended", "3", "consistent effort", "53"));
	        addBooking(new SwimBooking("23", "HJSS-008", "Grade 4", "Harry", "6/4/2024", "2-3pm", "cancelled", "", "", "54"));
	        addBooking(new SwimBooking("24", "HJSS-009", "Grade 5", "Sophia", "6/4/2024", "3-4pm", "attended", "2", "needs focus", "55"));

	    }


	    private void addBooking(SwimBooking swimBooking) {
	        bookingDetails.add(swimBooking);
	    }

	    public List<SwimBooking> getBookingDetails() {
	        return new ArrayList<>(bookingDetails); // Returns a copy of the booking details
	    }

}
