package com.example.fullstackdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Division {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String images;
    @OneToMany(mappedBy = "division")
    private Collection<Brand> brands;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getImages() {
        return images;
    }

    public Collection<Brand> getBrands() {
        return brands;
    }

    //default no args constructor required for jpa
    public Division() {

    }

    public Division(String type) {
        this.type = type;
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}