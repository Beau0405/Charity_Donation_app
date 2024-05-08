package com.fundraiser.fundraiser.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Campaign extends AbstractEntity{

    @ManyToMany
    private List<Donation> donations = new ArrayList<>();
    @ManyToOne
    private User user;

    private String name;
//    private String location;
    private String description;

    public Campaign(){}

    public Campaign(User user, String name, String description) {
        super();
        this.user = user;
        this.name = name;
        this.description = description;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // commented out section was for potentially ingesting every.org API
//    private String description;
//    private String name;
//    private String location;
//    private String websiteUrl;
//    private String logoUrl;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public String getWebsiteUrl() {
//        return websiteUrl;
//    }
//
//    public String getLogoUrl() {
//        return logoUrl;
//    }

}
