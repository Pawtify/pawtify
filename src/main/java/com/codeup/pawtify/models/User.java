package com.codeup.pawtify.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long id;

    @Column @NotBlank(message= "Must insert full name.")
    private String full_name;

    @Column @NotBlank(message= "Must enter valid phone number.")
    private String phone;

    @Column(nullable = false, unique = true) @NotBlank(message= "Enter username.")
    private String username;

    @Column(nullable = false, unique = true) @NotBlank(message= "Must enter valid email.")
    @Email(message="Must enter valid email.")
    private String email;

    @Column(nullable = false) @NotBlank(message = "Must enter valid password.")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Pawtification pawtification;

    public User(long id, String full_name, String phone, String username, String email, String password) {
        this.id = id;
        this.full_name = full_name;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String full_name, String phone, String username, String email, String password) {
        this.full_name = full_name;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
