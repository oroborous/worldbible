package com.javapuppy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "npc")
public class Npc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npc_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "sex")
    private String sex;
    @Column(name = "primary_image_filename")
    private String primaryImageFilename;
    @Column(name = "bio")
    private String bio;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "npc_quest",
            joinColumns = @JoinColumn(name = "quest_id"),
            inverseJoinColumns = @JoinColumn(name = "npc_id"))
    private List<Quest> quests;

    public Npc() {
        // no-arg constructor
    }

    public Npc(String firstName, String lastName, String nickname, String occupation, String sex, String primaryImageFilename, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.occupation = occupation;
        this.sex = sex;
        this.primaryImageFilename = primaryImageFilename;
        this.bio = bio;
    }

    public void add(Quest quest) {
        if (quests == null)
            quests = new ArrayList<>();
        quests.add(quest);
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

    public String getPrimaryImageFilename() {
        return primaryImageFilename;
    }

    public void setPrimaryImageFilename(String primaryImageFilename) {
        this.primaryImageFilename = primaryImageFilename;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public String toString() {
        return "Npc{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", occupation='" + occupation + '\'' +
                ", sex='" + sex + '\'' +
                ", primaryImageFilename='" + primaryImageFilename + '\'' +
                ", bio='" + bio + '\'' +
                ", quests=" + quests +
                '}';
    }
}
