package com.simpleapi.entry.connectors.kafka;

import com.simpleapi.entry.connectors.kafka.consumer.Consumer;
import com.simpleapi.entry.connectors.kafka.producer.Producer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class Kafka {
    private StreamExecutionEnvironment env;
    public Kafka(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public Consumer consumer(){
        return new Consumer();
    }
    public Producer producer(){
        return new Producer();
    }
}
