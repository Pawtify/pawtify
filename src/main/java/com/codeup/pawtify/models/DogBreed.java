package com.codeup.pawtify.models;

import javax.persistence.*;

@Entity
@Table(name= "dog_breeds")
public class DogBreed {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String breed;

    public DogBreed() {
    }

    public DogBreed(String breed) {
        this.breed = breed;
    }

    public DogBreed(long id, String breed) {
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