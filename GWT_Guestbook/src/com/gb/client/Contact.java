package com.gb.client;

public class Contact {
    String name;
    String email;
    String phone;
    String imageURL;
    public Contact(String name, String email, String phone, String imageURL) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.imageURL = imageURL;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
