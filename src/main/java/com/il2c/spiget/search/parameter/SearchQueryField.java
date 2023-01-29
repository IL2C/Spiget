package com.il2c.spiget.search.parameter;

public enum SearchQueryField {

    NAME("name"),
    TAG("tag");

    private final String name;

    SearchQueryField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
