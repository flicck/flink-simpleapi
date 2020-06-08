package com.simpleapi.entry.connectors.kafka.consumer;

import java.util.Properties;

public class KafkaCprop extends Properties {
    public KafkaCprop(String bootstrapServers,String zookeeperConnect){
        super();
        this.setProperty("bootstrap.servers",bootstrapServers);
        this.setProperty("zookeeper.connect",zookeeperConnect);
    }
    public KafkaCprop setGroupId(String groupId){
        this.setProperty("group.id",groupId);
        return this;
    }
    public KafkaCprop setKeyDeserializer(DefaultKafkaDeserializer deserializer){
        this.setProperty("key.deserializer", deserializer.getValue());
        return this;
    }
    public <T> KafkaCprop setKeyDeserializer(CustomizeKafkaDeserializer<T> deserializer){
        this.setProperty("key.deserializer", deserializer.getClass().getName());
        return this;
    }
    public KafkaCprop setValueDeserializer(DefaultKafkaDeserializer deserializer){
        this.setProperty("value.deserializer", deserializer.getValue());
        return this;
    }
    public <T> KafkaCprop setValueDeserializer(CustomizeKafkaDeserializer<T> deserializer){
        this.setProperty("value.deserializer", deserializer.getClass().getName());
        return this;
    }

    public KafkaCprop setAutoOffsetReset(AutoOffsetResetOption autoOffsetReset){
        this.setProperty("auto.offset.reset",autoOffsetReset.getValue());
        return this;
    }
    public KafkaCprop setOtherOption(String key,String value){
        this.setProperty(key,value);
        return this;
    }
}
