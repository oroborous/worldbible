package com.javapuppy.springxml.beans;

import com.javapuppy.springxml.services.LogService;
import org.apache.commons.logging.Log;

public class NPC {
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    private LogService logService;

    private int id;
    private String firstName;
    private String lastName;

    public NPC() {
    }

    public NPC(LogService logService) {
        this.logService = logService;
    }

    public void logChange(){
        logService.log("A change happened");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String bio;

}
