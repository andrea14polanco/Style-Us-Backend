package com.styleus.backend.models;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(schema = "dbo",name = "Users")
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = ?1"),
        @NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = ?1")
})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
      @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private int gender;

   @Column(name = "name")
    private String name;

  @Column(name = "middle_name")
    private String middle_name;

  @Column(name = "first_surname")
    private String first_surname;

   @Column(name = "second_surname")
    private String second_surname;

    @Column(name = "complete_name")
    private String complete_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "profile_img_url")
    private String profile_img_url;

    @Column(name = "privacity")
    private int privacity;

    @Column(name = "follower_count")
    private Long follower_count;

    @Transient
    private Date created_at;

    @Column(name ="update_at")
    private Date update_at;

    public User() {
    }

    public User(String username, String password, String email, int gender, String name, String middle_name, String first_surname, String second_surname, String complete_name, Date date_of_birth, String profile_img_url, int privacity, Long follower_count, Date update_at) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.middle_name = middle_name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.complete_name = complete_name;
        this.date_of_birth = date_of_birth;
        this.profile_img_url = profile_img_url;
        this.privacity = privacity;
        this.follower_count = follower_count;
        this.update_at = update_at;
    }
    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.gender = user.gender;
        this.name = user.name;
        this.middle_name = user.middle_name;
        this.first_surname = user.first_surname;
        this.second_surname = user.second_surname;
        this.complete_name = user.complete_name;
        this.date_of_birth = user.date_of_birth;
        this.profile_img_url = user.profile_img_url;
        this.privacity = user.privacity;
        this.follower_count = user.follower_count;
        System.out.println(new Date());
        this.update_at =  new Date();
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getProfile_img_url() {
        return profile_img_url;
    }

    public void setProfile_img_url(String profile_img_url) {
        this.profile_img_url = profile_img_url;
    }

    public int getPrivacity() {
        return privacity;
    }

    public void setPrivacity(int privacity) {
        this.privacity = privacity;
    }

    public Long getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(Long follower_count) {
        this.follower_count = follower_count;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return update_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.update_at = updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", first_surname='" + first_surname + '\'' +
                ", second_surname='" + second_surname + '\'' +
                ", complete_name='" + complete_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", profile_img_url='" + profile_img_url + '\'' +
                ", privacity=" + privacity +
                ", follower_count=" + follower_count +
                ", created_at=" + created_at +
                ", updated_at=" + update_at +
                '}';
    }
}
