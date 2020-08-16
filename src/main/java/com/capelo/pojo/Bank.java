package com.capelo.pojo;

public class Bank {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String name;
    private String city;

    public Bank(String name, String city){
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
