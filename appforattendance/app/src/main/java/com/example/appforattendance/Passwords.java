package com.example.appforattendance;

public class Passwords {

    String session_name,access;

    public Passwords(String clubname, String access) {
        this.session_name= session_name;
        this.access = access;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
