package com.simpleapi.entry;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public abstract class StreamEnv {
    private StreamExecutionEnvironment env;
    public StreamEnv(StreamExecutionEnvironment env){
        this.env = env;
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
    public Register register(){
        return new Register(env);
    }
    public CheckPoint checkPoint(){
        return new CheckPoint(env);
    }
}
