package com.allysoftsolutions.waterbottle.Pojo;

/**
 *
 */

public class User {

    private int id;
    private String email;
    private String password;
    private String mobileno;
    private String profile_image;

    public User() {
        //Deafult con..
        }
    public User(int id, String email, String password, String mobileno, String profile_image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.mobileno = mobileno;
        this.profile_image = profile_image;
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

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
