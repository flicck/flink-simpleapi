package com.simpleapi.entry;

import com.simpleapi.entry.connectors.kafka.Kafka;
import com.simpleapi.entry.connectors.kafka.consumer.Consumer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Connectors {
    private StreamExecutionEnvironment env;
    public Connectors(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public Kafka kafka(){
        return new Kafka(env);
    }
}
