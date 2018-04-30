package com.codeup.pawtify.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rescue_shelter")
public class RescueShelter {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rescueshelter")
    private List<Animal> animals;

    public RescueShelter(long id, String name, String address, String phone, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.user = user;
    }

    public RescueShelter(String name, String address, String phone, User user) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.user = user;
    }

    public RescueShelter() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
