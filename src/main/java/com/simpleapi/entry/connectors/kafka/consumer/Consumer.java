package com.simpleapi.entry.connectors.kafka.consumer;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;

import java.util.List;


public class Consumer {
    public <T>FlinkKafkaConsumer011<T> flinkKafkaConsumer011(List<String> topics, DeserializationSchema<T> deserializer, KafkaCprop props){
        return new FlinkKafkaConsumer011<>(topics,deserializer,props);
    }
    public <T>FlinkKafkaConsumer011<T> flinkKafkaConsumer011(String topic, KafkaDeserializationSchema<T> deserializer, KafkaCprop props) {
        return new FlinkKafkaConsumer011<>(topic,deserializer,props);
    }
    public <T>FlinkKafkaConsumer011<T> flinkKafkaConsumer011(String topic, DeserializationSchema<T> valueDeserializer, KafkaCprop props) {
        return new FlinkKafkaConsumer011<>(topic,valueDeserializer,props);
    }
    public <T>FlinkKafkaConsumer011<T> flinkKafkaConsumer011(List<String> topics, KafkaDeserializationSchema<T> deserializer, KafkaCprop props) {
        return new FlinkKafkaConsumer011<>(topics,deserializer,props);
    }
}
