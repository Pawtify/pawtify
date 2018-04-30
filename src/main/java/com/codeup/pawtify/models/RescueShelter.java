package com.codeup.pawtify.models;

import javax.persistence.*;

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
    private long users_id;

    public RescueShelter(long id, String name, String address, String phone, long users_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.users_id = users_id;
    }

    public RescueShelter(String name, String address, String phone, long users_id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.users_id = users_id;
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

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }
}
