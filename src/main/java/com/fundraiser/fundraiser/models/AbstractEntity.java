package com.fundraiser.fundraiser.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntity abEnt = (AbstractEntity) obj;
        return id == abEnt.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
