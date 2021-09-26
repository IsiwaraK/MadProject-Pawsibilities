package com.madone.forumone;

public class SetData {
    String title, description, image;
    SetData(String title, String description, String image){
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
