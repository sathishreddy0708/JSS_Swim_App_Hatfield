package com.uh.jss.util;
import java.util.HashMap;
import java.util.Map;

import com.uh.jss.entity.Learner;

public class LearnerUtil {
	private HashMap<String, Learner> learnerData;

    public LearnerUtil() {
        learnerData = new HashMap<>();
        loadLearnerDetails();
    }

    public HashMap<String, Learner> loadLearnerDetails() {
        // Sample data loading
        
        addLearner(new Learner("HJSS-001", "Ethan", "Male", 7, "07123 456789", 1));
        addLearner(new Learner("HJSS-002", "Olivia", "Female", 5, "07234 567890", 1));
        addLearner(new Learner("HJSS-003", "Jacob", "Male", 9, "07345 678901", 1));
        addLearner(new Learner("HJSS-004", "Sophia", "Female", 6, "07456 789012", 1));
        addLearner(new Learner("HJSS-005", "Mason", "Male", 8, "07567 890123", 1));
        addLearner(new Learner("HJSS-006", "Isabella", "Female", 4, "07678 901234", 1));
        addLearner(new Learner("HJSS-007", "Noah", "Male", 11, "07789 012345", 1));
        addLearner(new Learner("HJSS-008", "Mia", "Female", 10, "07890 123456", 1));
        addLearner(new Learner("HJSS-009", "Liam", "Male", 6, "07901 234567", 1));
        addLearner(new Learner("HJSS-010", "Ava", "Female", 9, "07012 345678", 1));
        addLearner(new Learner("HJSS-011", "William", "Male", 5, "07111 223344", 1));
        addLearner(new Learner("HJSS-012", "Sophie", "Female", 7, "07222 334455", 1));
        addLearner(new Learner("HJSS-013", "James", "Male", 4, "07333 445566", 1));
        addLearner(new Learner("HJSS-014", "Emily", "Female", 11, "07444 556677", 1));
        addLearner(new Learner("HJSS-015", "Alexander", "Male", 8, "07555 667788", 1));

        return learnerData;
    }

    private void addLearner(Learner learner) {
        learnerData.put(learner.getLearnerId(), learner);
    }

    public boolean validateLearner(String learnerId) {
        return learnerData.containsKey(learnerId);
    }

    public Learner getLearner(String learnerId) {
        return learnerData.get(learnerId);
    }

    public boolean validateLearner(String learnerId, Map<String, Learner> learnerInfo1) {
        return learnerData.containsKey(learnerId);
    }
    
    public Learner getLearner(String learnerId, Map<String, Learner> learnerInfo) {
        return learnerInfo.get(learnerId);
    }
}


















//
//import java.util.HashMap;
//
//
//public class LearnerUtil {
//	
//	public static HashMap<String, String> learnerData ;
//	
//	public HashMap<String, String>	learnerDetails(){
//		
//		 /**
//		  * custid, name, gender, currentLevel
//		  * 
//		  *  name, gender, age, emergency contact phone number, current grade level.
//		  *  
//		  * 
//		  * 
//		  */
//		 learnerData = new HashMap<String, String>();
//
//		learnerData.put("cust01","Alice,male,10,07812121315,1");
//		learnerData.put("cust02","Madhu,female,10,07812121315,1");
//		learnerData.put("cust03","Nikki,male,10,07812121315,1");
//		learnerData.put("cust04","Lucky,male,10,07812121315,1");
//		learnerData.put("cust05","Danny,male,10,07812121315,1");
//		learnerData.put("cust06","Dave,female,10,07812121315,1");
//		learnerData.put("cust07","Abbie,male,10,07812121315,1");
//		learnerData.put("cust08","Monna,female,10,07812121315,1");
//		learnerData.put("cust09","Gilbert,female,10,07812121315,1");
////        custData.put("cust10","Joseph,female,1");
////        custData.put("cust11","Oliver,female,1");
////        custData.put("cust12","Thomas,female,1");
////		custData.put("cust13","William,female,1");
////		custData.put("cust14","David,female,1");
////	    custData.put("cust15","Jonson,female,1");
////        custData.put("cust16","Olivia,female,1");
//            return learnerData;
//	}
//	
//	/*
//	 * public boolean validateCustomer(String customerID) { Customer custInf= new
//	 * Customer(); custInf.learnerDetails();
//	 * //System.out.println("is valid"+custData.containsKey(customerID)+"---"+
//	 * customerID); return learnerData.containsKey(customerID); }
//	 */
//	
//	public boolean validateLearner(String customerID, HashMap<String,String> newCustData) {
//		LearnerUtil custInf= new LearnerUtil();
//		custInf.learnerDetails();
//		//System.out.println("is valid"+custData.containsKey(customerID)+"---"+customerID);
//		return newCustData.containsKey(customerID);
//	}
//	
//	public String getLearnerData(String customerID, HashMap<String,String> newCustData) {
//		LearnerUtil custInf= new LearnerUtil();
//		custInf.learnerDetails();
//		//System.out.println("is valid"+custData.containsKey(customerID)+"---"+customerID);
//		return newCustData.get(customerID);
//	}
//
//	
	/*
	 * public String getCustomerData(String customerID) { Customer custInf= new
	 * Customer(); custInf.learnerDetails();
	 * //System.out.println("is valid"+custData.containsKey(customerID)+"---"+
	 * customerID); return learnerData.get(customerID); }
	 */

//}
