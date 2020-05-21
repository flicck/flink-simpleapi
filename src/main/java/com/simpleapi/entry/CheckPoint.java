package com.simpleapi.entry;

import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class CheckPoint {
    private StreamExecutionEnvironment env;
    protected CheckPoint(StreamExecutionEnvironment env) {
        this.env = env;
    }
    @Deprecated
    public StreamExecutionEnvironment enable(long interval, CheckpointingMode mode, boolean force) {
        return env.enableCheckpointing(interval,mode,force);
    }
    public StreamExecutionEnvironment enable(long interval, CheckpointingMode mode) {
        return env.enableCheckpointing(interval,mode);
    }
}
