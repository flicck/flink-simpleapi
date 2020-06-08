package com.simpleapi.entry.connectors.kafka.producer;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;
import org.apache.flink.streaming.connectors.kafka.partitioner.FlinkKafkaPartitioner;
import org.apache.flink.streaming.util.serialization.KeyedSerializationSchema;

import java.util.Optional;
import java.util.Properties;

public class Producer {

    public <IN>FlinkKafkaProducer011<IN> flinkKafkaProducer011(String brokerList, String topicId, SerializationSchema<IN> serializationSchema){
        return new FlinkKafkaProducer011<>(brokerList,topicId,serializationSchema);
    }

    public <IN>FlinkKafkaProducer011<IN> flinkKafkaProducer011(String defaultTopicId,
                                              KeyedSerializationSchema<IN> serializationSchema,
                                              Properties producerConfig,
                                              Optional<FlinkKafkaPartitioner<IN>> customPartitioner){
        return new FlinkKafkaProducer011<>(defaultTopicId,serializationSchema,producerConfig,customPartitioner);
    }
    public <IN>FlinkKafkaProducer011<IN> flinkKafkaProducer011(String defaultTopicId,
                                              KeyedSerializationSchema<IN> serializationSchema,
                                              Properties producerConfig,
                                              Optional<FlinkKafkaPartitioner<IN>> customPartitioner,
                                              FlinkKafkaProducer011.Semantic semantic,
                                              int kafkaProducersPoolSize){
         return new FlinkKafkaProducer011<>(defaultTopicId, serializationSchema, producerConfig, customPartitioner, semantic, kafkaProducersPoolSize);
    }

    public static void main(String[] args) {
//        final FlinkKafkaProducer011 flinkKafkaProducer011 = new FlinkKafkaProducer011<>();
    }
}

