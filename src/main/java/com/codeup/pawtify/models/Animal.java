package com.codeup.pawtify.models;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Type")
    private String type;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Breed")
    private String breed;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Pet Name")
    private String name;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Age")
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

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Pets Behavior")
    private String behavior;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Please Pick Shelter Location")
    private String shelter_location;

    @Column
    @Size(min=1, max=100, message="Please Upload a Photo")
    private String path;

    //    TODO: Discuss with Emma RS_User's relationship to Animals.
//    @ManyToOne
//    private RS_User rs_user;


    public Animal() {
    }

    public Animal(String type, String breed, String name, String age, String gender, String size, String color, String behavior, String shelter_location, String path) {
        this.type = type;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.behavior = behavior;
        this.shelter_location = shelter_location;
        this.path = path;
//        this.rs_user = rs_user;
    }

//    public animal(long id, String type, String breed, String name, String age, String gender, String size, String color, String behavior, String shelter_location, String path, RS_User rs_user) {
//        this.id = id;
//        this.type = type;
//        this.breed = breed;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.size = size;
//        this.color = color;
//        this.behavior = behavior;
//        this.shelter_location = shelter_location;
//        this.path = path;
////        this.rs_user = rs_user;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getShelter_location() {
        return shelter_location;
    }

    public void setShelter_location(String shelter_location) {
        this.shelter_location = shelter_location;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public RS_User getRs_user() {
//        return rs_user;
//    }
//
//    public void setRs_user(RS_User rs_user) {
//        this.rs_user = rs_user;
//    }
}

