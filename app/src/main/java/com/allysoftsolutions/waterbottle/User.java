package com.allysoftsolutions.waterbottle;

/**
 * Created by Zoom on 10/1/2018.
 */

public class User {

    private int id;
    private String email;
    private String password;
    private String mobileno;
    private  String profile_image;

    public User(String email, String password,String profile_image) {
        this.email = email;
        this.password = password;

    }

    public User(String s, String s1,String s3,String s4) {
    }

    public User(String string, String string1) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMobileno() { return mobileno;}

    public void setMobileno(String mobileno) { this.mobileno = mobileno;}


    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password='" + profile_image + '\'' +
                '}';
    }
}
