package com.example.appforattendance;

public class choice {

    String accesscode,session_name,club;

    public choice(){}

    public choice(String session_name,String club){
        this.club=club;
        this.session_name=session_name;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
