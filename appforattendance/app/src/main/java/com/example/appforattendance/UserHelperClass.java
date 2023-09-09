package com.example.appforattendance;

public class UserHelperClass {
    String name, clubname, date, classname, qrcodenum;

    public UserHelperClass(){

    }
    public UserHelperClass(String name,String clubname,String date,String classname,String qrcodenum)
    {
        this.classname=classname;
        this.date=date;
        this.qrcodenum=qrcodenum;
        this.clubname=clubname;
        this.name=name;
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
    public void setClassname(String classname){
        this.classname=classname;
    }
}
