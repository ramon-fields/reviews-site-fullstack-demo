package com.example.fullstackdemo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String images;
    @ManyToOne
    private Division division;
    @ManyToMany
    private java.util.Collection<Designer> designers;


    public Long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImages() {
        return images;
    }

    public Division getDivision() {
        return division;
    }

    public Collection<Designer> getDesigners() {
        return designers;
    }
    //default no args constructor required for jpa
    public Brand() {

    }

    public Brand(String title, String description, String images, Division division, Designer...designers) {
        this.title = title;
        this.description = description;
        this.images = images;
        this.division = division;
        this.designers = new ArrayList<>(Arrays.asList(designers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}