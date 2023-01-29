package com.il2c.spiget.author.response;

public class Author {

    private String name;
    private Icon icon;
    private Identities identities;
    private int id;

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    public Identities getIdentities() {
        return identities;
    }

    public int getID() {
        return id;
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

    public static class Identities {

        private String github;
        private String discord;
        private String youtube;
        private String aim;
        private String msn;
        private String icq;
        private String yahoo;
        private String skype;
        private String gtalk;
        private String facebook;
        private String twitter;

        public Identities() {
        }

        public String getGitHub() {
            return github;
        }

        public String getDiscord() {
            return discord;
        }

        public String getYouTube() {
            return youtube;
        }

        public String getAIM() {
            return aim;
        }

        public String getWindowsLive() {
            return msn;
        }

        public String getICQ() {
            return icq;
        }

        public String getYahooMessenger() {
            return yahoo;
        }

        public String getSkype() {
            return skype;
        }

        public String getGoogleTalk() {
            return gtalk;
        }

        public String getFacebook() {
            return facebook;
        }

        public String getTwitter() {
            return twitter;
        }
    }
}
