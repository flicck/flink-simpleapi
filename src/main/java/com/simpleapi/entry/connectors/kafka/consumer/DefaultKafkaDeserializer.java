package com.simpleapi.entry.connectors.kafka.consumer;

public enum DefaultKafkaDeserializer {
    ByteArray("org.apache.kafka.common.serialization.StringDeserializer"),
    ByteBuffer("org.apache.kafka.common.serialization.ByteBufferDeserializer"),
    Bytes("org.apache.kafka.common.serialization.BytesDeserializer"),
    Double("org.apache.kafka.common.serialization.DoubleDeserializer"),
    Float("org.apache.kafka.common.serialization.FloatDeserializer"),
    Integer("org.apache.kafka.common.serialization.IntegerDeserializer"),
    Long("org.apache.kafka.common.serialization.LongDeserializer"),
    Short("org.apache.kafka.common.serialization.ShortDeserializer"),
    String("org.apache.kafka.common.serialization.StringDeserializer"),
    ;
    private String value;
    private DefaultKafkaDeserializer(){
    }
    private DefaultKafkaDeserializer(String value) {
        this.value = value;
    }
    public java.lang.String getValue() {
        return value;
    }
}
