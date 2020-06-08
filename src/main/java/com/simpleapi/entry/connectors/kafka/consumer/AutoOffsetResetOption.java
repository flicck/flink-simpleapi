package com.simpleapi.entry.connectors.kafka.consumer;

public enum AutoOffsetResetOption {
    Earliest("earliest"),
    Latest("latest"),
    None("none"),
    ;
    private String value;
    private AutoOffsetResetOption(){
    }
    AutoOffsetResetOption(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
