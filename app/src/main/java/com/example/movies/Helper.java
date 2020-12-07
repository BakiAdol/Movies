package com.example.movies;

public class Helper {

    private String id,actor,name;

    public Helper() {}

    public Helper(String id, String actor, String name) {
        this.id = id;
        this.actor = actor;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
