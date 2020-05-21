package com.simpleapi.entry;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamEnv {
    private StreamExecutionEnvironment env;
    public StreamEnv(){
        this.env = StreamExecutionEnvironment.getExecutionEnvironment();
    }
    public Source source(){
        return new Source(env);
    }
    public From from(){
        return new From(env);
    }
    public StreamExecutionEnvironment getEnv(){
        return env;
    }
    public Config config(){
        return new Config(env);
    }
    public ExConfig exConfig(){
        return new ExConfig(env);
    }
    public Register register(){
        return new Register(env);
    }
    public CheckPoint checkPoint(){
        return new CheckPoint(env);
    }
}
