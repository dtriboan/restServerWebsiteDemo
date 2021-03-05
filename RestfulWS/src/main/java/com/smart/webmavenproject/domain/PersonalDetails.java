/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.webmavenproject.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Darpan
 */
public class PersonalDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private String address;
    private String dob;
    private String mobileNumber;

    public PersonalDetails(){
        address = "";
        dob = "";
        mobileNumber = "";
    }

    public PersonalDetails(String address, String dob, String mobileNumber) {
        this.address = address;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getBornYear() {
        return dob;
    }

    public void setBornYear(String bornYear) {
        this.dob = bornYear;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    
}
