/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.webmavenproject.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Darpan
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userID;
    private String individualName;
    private Date createdTimeStamp;
    private Integer heartRate;
    private PersonalDetails personalDetails;
    
    public User() {
        this.userID = -1;
        this.individualName = "";
        this.createdTimeStamp = new Date();
        this.personalDetails = new PersonalDetails();
    }
    
    public User(Integer userID, String individualName) {
        this.userID = userID;
        this.individualName = individualName;
        this.createdTimeStamp = new Date();
    }
    public User(String individualName) {
        this.userID = -1;
        this.individualName = individualName;
        this.createdTimeStamp = new Date();
    }

    public User(Integer userID, String individualName, Date createdTimeStamp, Integer heartRate, PersonalDetails personalDetails) {
        this.userID = userID;
        this.individualName = individualName;
        this.createdTimeStamp = createdTimeStamp;
        this.heartRate = heartRate;
        this.personalDetails = personalDetails;
    }
    
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getIndividualName() {
        return individualName;
    }

    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    
    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Override
    public String toString() {
        return "Users{" + "userID=" + userID + ", individualName=" + individualName + ", createdTimeStamp=" + createdTimeStamp + ", heartRate=" + heartRate + '}';
    }

    
}
