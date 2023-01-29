package com.il2c.spiget.global;

public enum SortOrder {

    ASCENDING("+", "%2B"),
    DESCENDING("-", "-");

    private final String prefix;
    private final String code;

    SortOrder(String prefix, String code) {
        this.prefix = prefix;
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getCode() {
        return code;
    }
}
