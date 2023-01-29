package com.il2c.spiget.resource.response;

public class ResourcesForVersion {

    private String[] check;
    private String method;
    private Match[] match;

    public String[] getCheck() {
        return check;
    }

    public String getMethod() {
        return method;
    }

    public Match[] getMatches() {
        return match;
    }

    public static class Match {

        private String[] testedVersions;
        private String name;
        private int id;

        public String[] getTestedVersions() {
            return testedVersions;
        }

        public String getName() {
            return name;
        }

        public int getID() {
            return id;
        }
    }
}
