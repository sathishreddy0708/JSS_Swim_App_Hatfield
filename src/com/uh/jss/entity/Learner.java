package com.uh.jss.entity;

public class Learner {
    private String learnerId;
    private String name;
    private String gender;
    private int age;
    private String emergencyContact;
    private int currentGradeLevel;

    public Learner() {
       }
    
    public Learner(String learnerId, String name, String gender, int age, String emergencyContact, int currentGradeLevel) {
        this.learnerId = learnerId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.emergencyContact = emergencyContact;
        this.currentGradeLevel = currentGradeLevel;
    }

    // Getters and setters
    public String getLearnerId() {
        return learnerId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public int getCurrentGradeLevel() {
        return currentGradeLevel;
    }
    
    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setCurrentGradeLevel(int currentGradeLevel) {
        this.currentGradeLevel = currentGradeLevel;
    }
}

