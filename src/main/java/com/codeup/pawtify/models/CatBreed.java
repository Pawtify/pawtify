package com.codeup.pawtify.models;

import javax.persistence.*;

@Entity
@Table(name = "cat_breeds")
public class CatBreed {
    @Id@GeneratedValue
    private long id;

    @Column
    private String breed;

    public CatBreed() {
    }

    public CatBreed(String breed) {
        this.breed = breed;
    }

    public CatBreed(long id, String breed) {
        this.id = id;
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
