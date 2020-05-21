package com.simpleapi.entry;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FromSplittableIteratorFunction;
import org.apache.flink.util.SplittableIterator;

import java.util.Collection;
import java.util.Iterator;

public class From {
    private StreamExecutionEnvironment env;
    protected From(StreamExecutionEnvironment env) {
        this.env = env;
    }
    @SafeVarargs
    public final <OUT> DataStreamSource<OUT> elements(OUT... data) {
        return env.fromElements(data);
    }
    @SafeVarargs
    public final <OUT> DataStreamSource<OUT> elements(Class<OUT> type, OUT... data){
        return env.fromElements(type,data);
    }
    public <OUT> DataStreamSource<OUT> collection(Collection<OUT> data) {
        return env.fromCollection(data);
    }
    public <OUT> DataStreamSource<OUT> collection(Collection<OUT> data, TypeInformation<OUT> typeInfo) {
        return env.fromCollection(data,typeInfo);
    }
    public <OUT> DataStreamSource<OUT> collection(Iterator<OUT> data, Class<OUT> type) {
        return env.fromCollection(data, TypeExtractor.getForClass(type));
    }
    public <OUT> DataStreamSource<OUT> collection(Iterator<OUT> data, TypeInformation<OUT> typeInfo) {
        return env.fromCollection(data,typeInfo);
    }
    public <OUT> DataStreamSource<OUT> parallelCollection(SplittableIterator<OUT> iterator, Class<OUT> type) {
        return env.fromParallelCollection(iterator, TypeExtractor.getForClass(type));
    }
    public <OUT> DataStreamSource<OUT> parallelCollection(SplittableIterator<OUT> iterator, TypeInformation<OUT>
            typeInfo) {
        return env.fromParallelCollection(iterator,typeInfo);
    }
}
