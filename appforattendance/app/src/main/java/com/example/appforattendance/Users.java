package com.example.appforattendance;

public class Users {
    String name;
    String clubsession;
    String classname;
    String date;
    String usermail;
    String qrcode;

    public Users() {}

    public Users(String name, String clubsession, String classname, String date, String usermail, String qrcode) {
        this.name = name;
        this.clubsession = clubsession;
        this.classname = classname;
        this.date = date;
        this.usermail = usermail;
        this.qrcode = qrcode;
    }



    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubsession() {
        return clubsession;
    }

    public void setClubsession(String clubsession) {
        this.clubsession = clubsession;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcodenum) {
        this.qrcode = qrcode;
    }
}



