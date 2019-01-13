package com.shubhammm.loginsignup;

/**
 * Created by Shubhamm Arora on 08-10-2017.
 */

public class UserInformationn {


    private String name;
    private String registration;
    private String branch;
    private String yearop;
    private String cpi;

    public UserInformationn(){

    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCpi() {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }


    public String getYearop() {
        return yearop;
    }

    public void setYearop(String yearop) {
        this.yearop = yearop;
    }
}
