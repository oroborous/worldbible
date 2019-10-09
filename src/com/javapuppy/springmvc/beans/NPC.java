package com.javapuppy.springmvc.beans;

public class NPC {
    private int id;
    private String firstName;
    private String lastName;
    private String bio;
    private String description;
    private String nickname;
    private String occupation;
    private String sex;
    private String primaryImageFilename;

    public NPC() {
    }

    public String getPrimaryImageFilename() {
        return primaryImageFilename;
    }

    public void setPrimaryImageFilename(String primaryImageFilename) {
        this.primaryImageFilename = primaryImageFilename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

}
