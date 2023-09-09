package com.example.appforattendance;

public class userDatabase {
    String name, clubname, date, classname, qrcodenum;

    public userDatabase(){

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getClubname(){
        return clubname;
    }
    public void setClubname(String clubname){
        this.clubname=clubname;
    }

    public String getQrcodenum(){
        return qrcodenum;
    }
    public void setQrcodenum(String qrcodenum){
        this.qrcodenum=qrcodenum;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public String getClassname(){
        return classname;
    }
    public void setClassname(String classname){this.classname=classname;}



}
