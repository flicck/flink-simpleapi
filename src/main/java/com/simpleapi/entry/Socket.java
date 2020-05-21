package com.simpleapi.entry;

import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SocketTextStreamFunction;

public class Socket {
    private StreamExecutionEnvironment env;
    protected Socket(StreamExecutionEnvironment env) {
        this.env = env;
    }
    @PublicEvolving
    public DataStreamSource<String> textStream(String hostname, int port, String delimiter, long maxRetry) {
       return env.socketTextStream(hostname,port,delimiter,maxRetry);
    }
    @PublicEvolving
    public DataStreamSource<String> textStream(String hostname, int port, String delimiter) {
        return env.socketTextStream(hostname, port, delimiter, 0);
    }
    @PublicEvolving
    public DataStreamSource<String> textStream(String hostname, int port) {
        return env.socketTextStream(hostname, port, "\n");
    }
}
