package com.codeup.pawtify.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "pawtifications")
public class pawtification {
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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pawtification")
    private List<CatBreed> cat_breeds;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pawtification")
    private List<DogBreed> dog_breeds;




    public pawtification() {
    }

    public pawtification(String age, String gender, String size, String color, User user, List<CatBreed> cat_breeds, List<DogBreed> dog_breeds) {
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.user = user;
        this.cat_breeds = cat_breeds;
        this.dog_breeds = dog_breeds;
    }

    public pawtification(long id , String age, String gender, String size, String color, User user, List<CatBreed> cat_breeds, List<DogBreed> dog_breeds) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.user = user;
        this.cat_breeds = cat_breeds;
        this.dog_breeds = dog_breeds;

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

    public List<CatBreed> getCat_breeds() {
        return cat_breeds;
    }

    public void setCat_breeds(List<CatBreed> cat_breeds) {
        this.cat_breeds = cat_breeds;
    }

public List<DogBreed> getDog_breeds() {
        return dog_breeds;
    }

    public void setDog_breeds(List<DogBreed> dog_breeds) {
        this.dog_breeds = dog_breeds;
    }
}