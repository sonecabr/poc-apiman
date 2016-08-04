package com.soneca.poc.apiman.publicapi.entity;

/**
 * Created by soneca on 04/08/16.
 */
public class User {

    private String id;
    private String name;
    private String role;


    public User role(String role){
        this.role = role;
        return this;
    }

    public User id(String id){
        this.id = id;
        return this;
    }

    public User name(String name){
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }
}
