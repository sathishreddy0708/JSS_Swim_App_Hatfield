package com.uh.jss.service;

import java.util.HashMap;
import java.util.Scanner;

import com.uh.jss.entity.Learner;

public class AddLearner {

	public HashMap<String, Learner> addNewLearner(HashMap<String,Learner> custInfo) {
		
		Scanner sc = new Scanner(System.in);
			int size = custInfo.size();
			
			System.out.println("Enter learner name:");
			String learnerName = sc.nextLine();
			
			System.out.println("Enter learner age:");
			int age = sc.nextInt();

			System.out.println("Enter learner's mobile number:");
			String mobileNumber = sc.next();


			System.out.println("Choose Gender: 1 - male\t 2 - female");
			int choice= sc.nextInt();
			String gender = choice==1?"male":"female";
					

			String key = "HJSS-0"+String.valueOf(size+1);
			//name,gender,age,mobileNumber,grade
			String value = learnerName+","+gender+","+String.valueOf(age)+","+mobileNumber+","+"0";

			
			Learner learner = new Learner(key,learnerName,gender, age,mobileNumber,0);


			if(age>=4 && age<=11) {
			custInfo.put(key, learner);
			System.out.println("Learner Added successfully...");
			System.out.println("Use the learnerID: \""+key+"\" to book swimming lessons");
			}
			else {
				System.out.println("System can add learner.. If the age is between 4 years to 11 years..");
			}
			return custInfo;
			
		
	}

}
