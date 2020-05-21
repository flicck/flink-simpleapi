package com.simpleapi.gather;

import org.apache.flink.streaming.api.functions.source.ParallelSourceFunction;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class Sou {
    public abstract static class RichParallelSource<OUT> extends RichParallelSourceFunction<OUT>{
    }
    public abstract static class RichSource<OUT> extends RichSourceFunction<OUT>{
    }
    public interface Source<OUT> extends SourceFunction<OUT> {
    }
    public interface ParallelSource<OUT> extends ParallelSourceFunction<OUT>{
    }
}
