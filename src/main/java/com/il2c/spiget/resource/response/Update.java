package com.il2c.spiget.resource.response;

import java.util.Base64;

public class Update {

    private String title;
    private String description;
    private long date;
    private int likes;
    private int resource;
    private int id;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description != null ? new String(Base64.getDecoder().decode(description)) : null;
    }

    public long getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public int getResource() {
        return resource;
    }

    public int getID() {
        return id;
    }
}
