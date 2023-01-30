package com.il2c.spiget.resource.response;

import java.util.Base64;
import java.util.UUID;

public class Resource {

    private boolean external;
    private File file;
    private String contributors;
    private String description;
    private int likes;
    private String[] testedVersions;
    private Links links;
    private String name;
    private String tag;
    private Version version;
    private Author author;
    private Category category;
    private Rating rating;
    private Icon icon;
    private long releaseDate;
    private long updateDate;
    private int downloads;
    private boolean premium;
    private String donationLink;
    private int existenceStatus;
    private String sourceCodeLink;
    private int id;

    public boolean isExternal() {
        return external;
    }

    public File getFile() {
        return file;
    }

    public String getContributors() {
        return contributors;
    }

    public String getDescription() {
        return description != null ? new String(Base64.getDecoder().decode(description)) : null;
    }

    public int getLikes() {
        return likes;
    }

    public String[] getTestedVersions() {
        return testedVersions;
    }

    public Links getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public Version getVersion() {
        return version;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }

    public Icon getIcon() {
        return icon;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public int getDownloads() {
        return downloads;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getDonationLink() {
        return donationLink;
    }

    public int getExistenceStatus() {
        return existenceStatus;
    }

    public String getSourceCodeLink() {
        return sourceCodeLink;
    }

    public int getID() {
        return id;
    }

    public static class File {

        private String type;
        private double size;
        private String sizeUnit;
        private String url;

        public String getType() {
            return type;
        }

        public double getSize() {
            return size;
        }

        public String getSizeUnit() {
            return sizeUnit;
        }

        public String getURL() {
            return url;
        }
    }

    public static class Links {

        private String additionalInformation;
        private String alternativeSupport;
        private String discussion;

        public String getAdditionalInformation() {
            return additionalInformation;
        }

        public String getAlternativeSupport() {
            return alternativeSupport;
        }

        public String getDiscussion() {
            return discussion;
        }
    }

    public static class Version {

        private int id;
        private UUID uuid;

        public int getID() {
            return id;
        }

        public UUID getUUID() {
            return uuid;
        }
    }

    public static class Author {

        private int id;

        public int getID() {
            return id;
        }
    }

    public static class Category {

        private int id;

        public int getID() {
            return id;
        }
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

    public static class Icon {

        private String url;
        private String data;
        private String info;
        private String hash;

        public String getURL() {
            return url;
        }

        public String getData() {
            return data;
        }

        public String getInfo() {
            return info;
        }

        public String getHash() {
            return hash;
        }
    }
}
