package com.madone.forumone;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Postsub implements Serializable {

    @Exclude
    private String title;
    private String description;
    private String key;
    public Postsub(){}
    public Postsub(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
