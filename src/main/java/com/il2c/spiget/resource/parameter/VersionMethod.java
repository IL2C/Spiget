package com.il2c.spiget.resource.parameter;

public enum VersionMethod {

    ANY("any"),
    ALL("all");

    private final String name;

    VersionMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
