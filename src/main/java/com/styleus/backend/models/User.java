package com.styleus.backend.models;

import java.security.PublicKey;
import java.util.Date;

public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String middle_name;
    private String first_surname;
    private String second_surname;
    private String complete_name;
    private Date date_of_birth;
    private Boolean privacity;
    private Long follower_count;
    private Boolean verification;
    private Long following_count;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private Boolean gender; //0 mujer y 1 hombre

    public User(){

    }

    public User(String name, String first_surname, Date date_of_birth, boolean gender, String email, String password, Boolean privacity){

        this.id = (new Date()).getTime();
        this.name=name;
        this.first_surname=first_surname;
        this.date_of_birth=date_of_birth;
        this.gender=gender;
        this.email=email;
        this.password=password;
        this.privacity=privacity;



    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getComplete_name() {
        return complete_name;
    }

    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Boolean getPrivacity() {
        return privacity;
    }

    public void setPrivacity(Boolean privacity) {
        this.privacity = privacity;
    }

    public Long getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(Long follower_count) {
        this.follower_count = follower_count;
    }

    public Boolean getVerification() {
        return verification;
    }

    public void setVerification(Boolean verification) {
        this.verification = verification;
    }

    public Long getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(Long following_count) {
        this.following_count = following_count;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", first_surname='" + first_surname + '\'' +
                ", second_surname='" + second_surname + '\'' +
                ", complete_name='" + complete_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", privacity=" + privacity +
                ", follower_count=" + follower_count +
                ", verification=" + verification +
                ", following_count=" + following_count +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                ", gender=" + gender +
                '}';
    }
}
