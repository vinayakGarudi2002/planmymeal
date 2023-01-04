package com.example.mealmyplan;

public class mode8 {
    String  name,expDate,cal,Ostate,phoneno,Address,Region,LunchTime,DinnerTime,BreakfastTime,UserKey,ctime,cdate;

    public mode8(String name, String expDate, String cal, String ostate, String phoneno, String address, String region, String lunchTime, String dinnerTime, String breakfastTime, String userKey, String ctime, String cdate) {
        this.name = name;
        this.expDate = expDate;
        this.cal = cal;
        Ostate = ostate;
        this.phoneno = phoneno;
        Address = address;
        Region = region;
        LunchTime = lunchTime;
        DinnerTime = dinnerTime;
        BreakfastTime = breakfastTime;
        UserKey = userKey;
        this.ctime = ctime;
        this.cdate = cdate;
    }

    public mode8() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getOstate() {
        return Ostate;
    }

    public void setOstate(String ostate) {
        Ostate = ostate;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getLunchTime() {
        return LunchTime;
    }

    public void setLunchTime(String lunchTime) {
        LunchTime = lunchTime;
    }

    public String getDinnerTime() {
        return DinnerTime;
    }

    public void setDinnerTime(String dinnerTime) {
        DinnerTime = dinnerTime;
    }

    public String getBreakfastTime() {
        return BreakfastTime;
    }

    public void setBreakfastTime(String breakfastTime) {
        BreakfastTime = breakfastTime;
    }

    public String getUserKey() {
        return UserKey;
    }

    public void setUserKey(String userKey) {
        UserKey = userKey;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}