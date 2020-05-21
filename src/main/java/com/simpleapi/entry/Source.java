package com.simpleapi.entry;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class Source {
    private StreamExecutionEnvironment env;
    protected Source(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public <OUT> DataStreamSource<OUT> customize(SourceFunction<OUT> function){
        return env.addSource(function, "Custom Source");
    }
    public <OUT> DataStreamSource<OUT> customize(SourceFunction<OUT> function, String sourceName) {
        return env.addSource(function, sourceName, null);
    }
    public <OUT> DataStreamSource<OUT> customize(SourceFunction<OUT> function, String sourceName, TypeInformation<OUT> typeInfo) {
        return env.addSource(function,sourceName, typeInfo);
    }
    public Read read(){
        return new Read(env);
    }
    public Socket socket(){
        return new Socket(env);
    }

}
