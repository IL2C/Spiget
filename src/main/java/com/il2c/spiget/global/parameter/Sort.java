package com.il2c.spiget.global.parameter;

public class Sort {

    private final String field;
    private final Sort.Order order;

    public Sort(String field, Sort.Order order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public Sort.Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return field != null && order != null ? field + order.getCode() : null;
    }

    public enum Order {

        ASCENDING("+", "%2B"),
        DESCENDING("-", "-");

        private final String prefix;
        private final String code;

        Order(String prefix, String code) {
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
}
