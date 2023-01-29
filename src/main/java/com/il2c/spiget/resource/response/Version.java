package com.il2c.spiget.resource.response;

import java.util.UUID;

public class Version {

    private int downloads;
    private Rating rating;
    private String url;
    private String name;
    private long releaseDate;
    private int resource;
    private UUID uuid;
    private int id;

    public int getDownloads() {
        return downloads;
    }

    public Rating getRating() {
        return rating;
    }

    public String getURL() {
        return url;
    }

    public String getName() {
        return name;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public int getResource() {
        return resource;
    }

    public UUID getUUID() {
        return uuid;
    }

    public int getID() {
        return id;
    }

    public static class Rating {

        private int count;
        private double average;

        public int getCount() {
            return count;
        }

        public double getAverage() {
            return average;
        }
    }
}
