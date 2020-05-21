package com.simpleapi.gather;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.FoldFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.Window;

/** wanghan
 * 常用的窗口函数可以直接点出来，不用去背了
 */
public class WinFunc {
    //reduce(new MyReduceFunction())
    //reduce(new MyReduceFunction(), new MyProcessWindowFunction());
    public interface Reduce<T> extends ReduceFunction<T>{
    }
    //aggregate(new AverageAggregate());
    //aggregate(new AverageAggregate(), new MyProcessWindowFunction())
    public interface Aggregate<IN, ACC, OUT> extends AggregateFunction<IN, ACC, OUT>{
    }
    //fold("", new MyFoldFunction());
    //fold(new Tuple3<String, Long, Integer>("",0L, 0), new MyFoldFunction(), new MyProcessWindowFunction())
    public interface Fold<O, T> extends FoldFunction<O, T>{
    }
    //process(new MyProcessWindowFunction());
    //aggregate(new AverageAggregate(), new MyProcessWindowFunction())
    //fold(new Tuple3<String, Long, Integer>("",0L, 0), new MyFoldFunction(), new MyProcessWindowFunction())
    //reduce(new MyReduceFunction(), new MyProcessWindowFunction());
    public abstract static class ProcessWindow<IN, OUT, KEY, W extends Window> extends ProcessWindowFunction<IN, OUT, KEY, W>{
    }
    //apply(new MyWindowFunction());
    public interface window<IN, OUT, KEY, W extends Window> extends WindowFunction<IN, OUT, KEY, W>{
    }

}
