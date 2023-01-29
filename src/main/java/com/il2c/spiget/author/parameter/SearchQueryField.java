package com.il2c.spiget.author.parameter;

public enum SearchQueryField {

    NAME("name");

    private final String name;

    SearchQueryField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
