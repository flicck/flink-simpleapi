package com.simpleapi.entry;

import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.runtime.state.StateBackend;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.transformations.StreamTransformation;

import java.io.Serializable;

public class Config {
    private StreamExecutionEnvironment env;
    protected Config(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public void setStreamTimeCharacteristic(TimeCharacteristic characteristic){
        env.setStreamTimeCharacteristic(characteristic);
    }
    public void setBufferTimeout(long timeoutMillis){
        env.setBufferTimeout(timeoutMillis);
    }
    public void setMaxParallelism(int maxParallelism){
        env.setMaxParallelism(maxParallelism);
    }
    public void setParallelism(int maxParallelism){
        env.setParallelism(maxParallelism);
    }
    public void setRestartStrategy(RestartStrategies.RestartStrategyConfiguration restartStrategyConfiguration){
        env.setRestartStrategy(restartStrategyConfiguration);
    }
    public void setStateBackend(StateBackend backend){
        env.setStateBackend(backend);
    }
    public <T extends Serializer<?> & Serializable>void addDefaultKryoSerializer(Class<?> type, T serializer){
        env.addDefaultKryoSerializer(type,serializer);
    }
    public void addDefaultKryoSerializer(Class<?> type, Class<? extends Serializer<?>> serializerClass) {
        env.addDefaultKryoSerializer(type, serializerClass);
    }
    public void addOperator(StreamTransformation<?> transformation){
        env.addOperator(transformation);
    }
    public void disableOperatorChaining(){
        env.disableOperatorChaining();
    }
}
