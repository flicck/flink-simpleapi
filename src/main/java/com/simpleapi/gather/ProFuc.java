package com.simpleapi.gather;

import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.co.BroadcastProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.streaming.api.functions.co.KeyedBroadcastProcessFunction;
import org.apache.flink.streaming.api.functions.co.ProcessJoinFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.Window;

/**wanghan
 * processFunction工具包，提供ProcessFunction、KeyedProcessFunction、CoProcessFunction、
 * ProcessJoinFunction、BroadcastProcessFunction、KeyedBroadProcessFunction、
 * ProcessWindowFunction、ProcessAllWindowFunction等低阶函数
 * 通常在.process(xxxx)中运用
 */
public class ProFuc {
    //KeyedProcessFunction作用于KeyedStream之上，该函数会对流中的每条记录调用一次，并返回
    //零个、一个或多个记录。所有处理函数都实现了RichFunction接口，因此支持open()、close()、
    //getRuntimeContext()等方法。除此之外，KeyedProcessFunction还提供以下两个方法:
    //processElement会针对流中的每条记录调用一次，可以像往常一样在方法中将结果记录传递给
    //Collector发送出去。Context对象是让处理函数与众不同的精华所在，可以通过它访问时间戳、
    //当前记录的键值和TimerService，此外，Context还支持将结果发送到副输出。
    //onTimer是一个回调函数，它会在之前注册的计时器触发时调用，timestamp参数给出了所触发计时器
    //的时间戳，Collector可以用来发出记录，OnTimerContext能够提供和processElement()方法中
    //的Context对象相同的服务，此外，它还会返回触发计时器的时间（处理时间或事件时间）。
    //Context和OnTimerContext对象中的TimerService提供了以下方法：
    //currentProcessingTime() 返回当前的处理时间
    //currentWatermark() 返回当前水位线的时间戳
    //registerProcessingTimeTimer() 针对当前键值注册一个处理时间的计时器，当执行机器的处理
    //时间到达给定的时间戳是，这个计时器就会触发
    //registerEventTimeTimer() 针对当前键值注册一个事件时间计时器，当更新后的水位线时间戳大于
    //或等于计时器的时间戳时，它就会触发。
    //deleteProcessingTimeTimer() 针对当前键值删除一个注册过的处理时间计时器，如果该计时器不存在，
    //则方法不会有任何作用。
    //deleteEventTimeTimer() 针对当前键值删除一个注册过的事件时间计时器，如果该计时器不存在，则
    //方法不会有任何作用
    public abstract static class KeyedProcess<K, I, O> extends KeyedProcessFunction<K, I, O>{
    }
    //针对有两个输入的底层操作，CoProcessFunction提供了一对作用在每个输入上的转换方法
    //processElement1()和processElement2()，它们和ProcessFunction中的方法类似，在被调用时都会
    //传入一个Context对象，用于访问当前元素或计时器时间戳，TimerService及副输出。CoProcessFunction
    //同样提供了OnTimer()的回调方法。
    public abstract static class CoProcess<IN1, IN2, OUT> extends CoProcessFunction<IN1, IN2, OUT>{
    }
    //操作join的两个流
    public abstract static class ProcessJoin<IN1, IN2, OUT> extends ProcessJoinFunction<IN1, IN2, OUT>{
    }
    //在两条数据流上应用带有广播状态的函数需要三个步骤
    //1、调用DataStream.broadcast()方法创建一个BroadcastStream并提供一个或多个MapStateDescriptor对象，每个
    //描述符都会为将来用于BroadcastStream的函数定义一个单独的广播状态
    //2、将BroadcastStream和一个DataStream或KeyedStream联结起来，必须将BroadcastStream作为参数给connect方法。
    //3、在联结后的数据流上应用一个函数，根据另一条流是否已经按键值分区，该函数可能是KeyedBroadcastProcessFunction
    //或BroadcastProcessFunction
    //处理广播流的函数
    public abstract static class BroadcastProcess<IN1, IN2, OUT> extends BroadcastProcessFunction<IN1, IN2, OUT>{
    }
    //处理广播流的函数
    public abstract static class KeyedBroadcastProcess<KS, IN1, IN2, OUT> extends KeyedBroadcastProcessFunction<KS, IN1, IN2, OUT>{
    }
    //处理窗口的函数
    public abstract static class ProcessWindow<IN, OUT, KEY, W extends Window> extends ProcessWindowFunction<IN, OUT, KEY, W>{
    }
    //处理窗口的函数
    public abstract static class ProcessAllWindow<IN, OUT, W extends Window> extends ProcessAllWindowFunction<IN, OUT, W>{
    }
}
