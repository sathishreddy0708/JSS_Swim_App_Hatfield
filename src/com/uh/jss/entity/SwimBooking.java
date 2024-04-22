package com.uh.jss.entity;

public class SwimBooking {

	  private String id;
	    private String learerID;
	    private String gradeLevel;
	    private String coach;
	    private String date;
	    private String timeSlot;
	    private String status;
//	    private int memCount;
	    private String rating;
	    private String review;
	    private String swimID;

	    public SwimBooking() {
	    	
	    }
	    		
	    public SwimBooking(String id, String learnerID, String gradeLevel, String coach, String date,String timeSlot, String status,  String rating, String review, String swimID) {
	        this.id = id;
	        this.learerID = learnerID;
	        this.gradeLevel = gradeLevel;
	        this.coach = coach;
	        this.date = date;
	        this.timeSlot = timeSlot;
	        this.status = status;
//	        this.memCount = memCount;
	        this.rating = rating;
	        this.review = review;
	        this.swimID = swimID;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLearnerID() {
			return learerID;
		}

		public void setLearnerID(String learnerID) {
			this.learerID = learnerID;
		}

		public String getGradeLevel() {
			return gradeLevel;
		}

		public void setGradeLevel(String gradeLevel) {
			this.gradeLevel = gradeLevel;
		}

		public String getCoach() {
			return coach;
		}

		public void setCoach(String coach) {
			this.coach = coach;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		/*
		 * public int getMemCount() { return memCount; }
		 * 
		 * public void setMemCount(int memCount) { this.memCount = memCount; }
		 */

		public String getRating() {
			return rating;
		}

		public void setRating(String rating) {
			this.rating = rating;
		}

		public String getReview() {
			return review;
		}

		public void setReview(String review) {
			this.review = review;
		}

		public String getSwimID() {
			return swimID;
		}

		public void setSwimID(String swimID) {
			this.swimID = swimID;
		}

	    
}
