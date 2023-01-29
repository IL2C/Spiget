package com.il2c.spiget.resource.response;

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
        return message;
    }

    public String getVersion() {
        return version;
    }

    public long getDate() {
        return date;
    }

    public String getResponseMessage() {
        return responseMessage;
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
