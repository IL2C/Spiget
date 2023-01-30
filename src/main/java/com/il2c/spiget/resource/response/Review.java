package com.il2c.spiget.resource.response;

import java.util.Base64;

public class Review {

    private Author author;
    private Rating rating;
    private String message;
    private String version;
    private long date;
    private String responseMessage;
    private int resource;
    private int id;

    public Author getAuthor() {
        return author;
    }

    public Rating getRating() {
        return rating;
    }

    public String getMessage() {
        return message != null ? new String(Base64.getDecoder().decode(message)) : null;
    }

    public String getVersion() {
        return version;
    }

    public long getDate() {
        return date;
    }

    public String getResponseMessage() {
        return responseMessage != null ? new String(Base64.getDecoder().decode(responseMessage)) : null;
    }

    public int getResource() {
        return resource;
    }

    public int getID() {
        return id;
    }

    public static class Author {

        private int id;

        public int getID() {
            return id;
        }
    }

    public static class Rating {

        private int count;
        private int average;

        public int getCount() {
            return count;
        }

        public int getAverage() {
            return average;
        }
    }
}
