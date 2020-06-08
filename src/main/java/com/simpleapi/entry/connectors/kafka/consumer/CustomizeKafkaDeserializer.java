package com.simpleapi.entry.connectors.kafka.consumer;

import org.apache.kafka.common.serialization.Deserializer;

public interface CustomizeKafkaDeserializer<T> extends Deserializer<T> {
}
