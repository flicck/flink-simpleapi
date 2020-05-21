package com.simpleapi.entry;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamEnv {
    private StreamExecutionEnvironment env;
    {
        this.env = StreamExecutionEnvironment.getExecutionEnvironment();
    }
    public Source source = new Source(env);

    public From from = new From(env);

    public StreamExecutionEnvironment getEnv(){
        return env;
    }
    public Config config = new Config(env);

    public ExConfig exConfig = new ExConfig(env);

    public Register register = new Register(env);

    public CheckPoint checkPoint = new CheckPoint(env);
}
