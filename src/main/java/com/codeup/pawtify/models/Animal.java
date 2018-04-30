package com.codeup.pawtify.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue
    private long id;

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
    @Size(min=1, max=100, message="Please Pick Pet's Behavior")
    private String behavior;

    @Column
    @Size(min=1, max=100, message="Please Upload a Photo")
    private String path;

    //    Relationships
    @ManyToOne(cascade = CascadeType.ALL)
    private RescueShelter rescueshelter;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "animal")
//    private List<CatBreed> cat_breeds;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "animal")
//    private List<DogBreed> dog_breeds;

    @OneToOne(cascade = CascadeType.ALL)
    private CatBreed catBreed;

    @OneToOne(cascade = CascadeType.ALL)
    private DogBreed dogBreed;


    public Animal() {
    }

    public Animal(String name, String age, String gender, String size, String color, String behavior, String path, RescueShelter rescueShelter, CatBreed catBreed, DogBreed dogBreed) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.behavior = behavior;
        this.path = path;
        this.rescueshelter = rescueshelter;
        this.catBreed = catBreed;
        this.dogBreed = dogBreed;

    }

    public Animal(long id, String name, String age, String gender, String size, String color, String behavior, String path, RescueShelter rescueShelter, CatBreed catBreed, DogBreed dogBreed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.behavior = behavior;
        this.path = path;
        this.rescueshelter = rescueshelter;
        this.catBreed = catBreed;
        this.dogBreed = dogBreed;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RescueShelter getRescueshelter() {
        return rescueshelter;
    }

    public void setRescueshelter(RescueShelter rescueshelter) {
        this.rescueshelter = rescueshelter;
    }

//    public List<CatBreed> getCat_breeds() {
//        return cat_breeds;
//    }
//
//    public void setCat_breeds(List<CatBreed> cat_breeds) {
//        this.cat_breeds = cat_breeds;
//    }
//
//    public List<DogBreed> getDog_breeds() {
//        return dog_breeds;
//    }
//
//    public void setDog_breeds(List<DogBreed> dog_breeds) {
//        this.dog_breeds = dog_breeds;
//    }
}

