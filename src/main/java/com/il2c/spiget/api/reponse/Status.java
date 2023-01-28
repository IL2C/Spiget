package com.il2c.spiget.api.reponse;

public class Status {

    private Server server;
    private Fetch fetch;
    private RestFetch restFetch;
    private Existence existence;

    public Server getServer() {
        return server;
    }

    public Fetch getFetch() {
        return fetch;
    }

    public RestFetch getRestFetch() {
        return restFetch;
    }

    public Existence getExistence() {
        return existence;
    }

    public static class Server {

        private String name;
        private String mode;

        public String getName() {
            return name;
        }

        public String getMode() {
            return mode;
        }
    }

    public static class Fetch {

        private long start;
        private String startString;
        private int end;
        private boolean active;
        private Page page;

        public long getStart() {
            return start;
        }

        public String getStartString() {
            return startString;
        }

        public int getEnd() {
            return end;
        }

        public boolean isActive() {
            return active;
        }

        public Page getPage() {
            return page;
        }

        public static class Page {

            private int amount;
            private int index;
            private Item item;

            public int getAmount() {
                return amount;
            }

            public int getIndex() {
                return index;
            }

            public Item getItem() {
                return item;
            }

            public static class Item {

                private int index;
                private String status;

                public int getIndex() {
                    return index;
                }

                public String getStatus() {
                    return status;
                }
            }
        }
    }

    public static class RestFetch {

        private long start;
        private String startString;
        private int end;
        private boolean active;
        private N n;

        public long getStart() {
            return start;
        }

        public String getStartString() {
            return startString;
        }

        public int getEnd() {
            return end;
        }

        public boolean isActive() {
            return active;
        }

        public static class N {

            private int num;
            private long start;
            private long end;
            private int max;
            private int index;

            public int getNum() {
                return num;
            }

            public long getStart() {
                return start;
            }

            public long getEnd() {
                return end;
            }

            public int getMax() {
                return max;
            }

            public int getIndex() {
                return index;
            }
        }
    }

    public static class Existence {

        private long start;
        private String startString;
        private long end;
        private boolean active;
        private Document document;

        public long getStart() {
            return start;
        }

        public String getStartString() {
            return startString;
        }

        public long getEnd() {
            return end;
        }

        public boolean isActive() {
            return active;
        }

        public Document getDocument() {
            return document;
        }

        public static class Document {

            private int amount;
            private int suspects;
            private int index;
            private int id;

            public int getAmount() {
                return amount;
            }

            public int getSuspects() {
                return suspects;
            }

            public int getIndex() {
                return index;
            }

            public int getId() {
                return id;
            }
        }
    }
}
