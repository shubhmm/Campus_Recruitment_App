package com.shubhammm.loginsignup;

/**
 * Created by Shubhamm Arora on 27-09-2017.
 */

public class UserInformation {
    public String name;
    public String registration;
    public String branch;
    public String yearop;
    public String cpi;
    public String contact;


    public UserInformation()
    {

    }

    public UserInformation(String name, String registration, String branch, String yearop, String cpi, String contact) {
        this.name = name;
        this.registration = registration;
        this.branch = branch;
        this.yearop = yearop;
        this.cpi = cpi;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public String getBranch() {
        return branch;
    }

    public String getYearop() {
        return yearop;
    }

    public String getCpi() {
        return cpi;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYearop(String yearop) {
        this.yearop = yearop;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
