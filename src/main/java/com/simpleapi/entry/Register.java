package com.simpleapi.entry;

import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.cache.DistributedCache;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.Serializable;

public class Register {
    private StreamExecutionEnvironment env;
    protected Register(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public void cachedFile(String filePath, String name){
        env.registerCachedFile(filePath,name);
    }
    public void cachedFile(String filePath, String name, boolean executable) {
        env.registerCachedFile(filePath,name,executable);
    }
    public void type(Class<?> type){
        env.registerType(type);
    }
    public <T extends Serializer<?> & Serializable>void typeWithKryoSerializer(Class<?> type, T serializer) {
        env.registerTypeWithKryoSerializer(type,serializer);
    }
    public void typeWithKryoSerializer(Class<?> type, Class<? extends Serializer> serializerClass) {
        env.registerTypeWithKryoSerializer(type,serializerClass);
    }
}
