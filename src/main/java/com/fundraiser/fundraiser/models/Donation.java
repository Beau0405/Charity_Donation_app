package com.fundraiser.fundraiser.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Donation extends AbstractEntity{
    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "donations")
    private List<Campaign> campaigns = new ArrayList<>();
    @Positive
    private Integer amount;

    public Donation(){    }
//    public Donation(User user, Campaign campaign, Integer amount) {
//        super();
//        this.user = user;
//        this.campaign = campaign;
//        this.amount = amount;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Campaign getCampaign() {
//        return campaign;
//    }
//
//    public void setCampaign(Campaign campaign) {
//        this.campaign = campaign;
//    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

//    public void setCampaigns(List<Campaign> campaigns) {
//        this.campaigns = campaigns;
//    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
