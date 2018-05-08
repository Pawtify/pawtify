package com.codeup.pawtify.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pawtifications")
public class Pawtification {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Gender")
    private String gender;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Size")
    private String size;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Color")
    private String color;

//    Relationships
    @OneToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private CatBreed catBreed;

    @OneToOne(cascade = CascadeType.ALL)
    private DogBreed dogBreed;

    public Pawtification() {
    }

    public Pawtification(String age, String gender, String size, String color, User user, CatBreed catBreed, DogBreed dogBreed) {
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.user = user;
        this.catBreed = catBreed;
        this.dogBreed = dogBreed;
    }

    public Pawtification(long id , String age, String gender, String size, String color, User user, CatBreed catBreed, DogBreed dogBreed) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.user = user;
        this.catBreed = catBreed;
        this.dogBreed = dogBreed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatBreed getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(CatBreed catBreed) {
        this.catBreed = catBreed;
    }

    public DogBreed getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(DogBreed dogBreed) {
        this.dogBreed = dogBreed;
    }
}