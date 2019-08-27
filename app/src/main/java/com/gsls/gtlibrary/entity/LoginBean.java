package com.gsls.gtlibrary.entity;

public class LoginBean {

    private String username;
    private String password;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public LoginBean() {
        super();
    }

    public LoginBean(String username, String password, int age) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "LoginBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

}
