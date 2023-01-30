package com.il2c.spiget.response.parameter;

public class Parameter {

    private final String key;
    private final Object value;

    public Parameter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
