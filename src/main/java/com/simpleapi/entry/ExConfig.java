package com.simpleapi.entry;

import org.apache.flink.api.common.CodeAnalysisMode;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.ExecutionMode;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ExConfig extends ExecutionConfig {
    private StreamExecutionEnvironment env;
    public ExConfig(StreamExecutionEnvironment env) {
        this.env = env;
    }
}
