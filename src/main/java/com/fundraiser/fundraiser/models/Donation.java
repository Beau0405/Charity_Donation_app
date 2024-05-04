package com.fundraiser.fundraiser.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Donation extends AbstractEntity{
    @ManyToOne
    private User user;

}
