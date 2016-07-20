package com.soneca.poc.apiman.publicapi.entity;

/**
 * Created by soneca on 20/07/16.
 */
public class Item {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item id(Integer id){
        this.id = id;
        return this;
    }

    public Item name(String name){
        this.name = name;
        return this;
    }
}
