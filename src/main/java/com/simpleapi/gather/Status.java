package com.simpleapi.gather;

import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.checkpoint.ListCheckpointed;

import java.io.Serializable;

/** wanghan
 * 提供算子列表状态的接口，如果要实现键值分区状态，那么在keyedStream上调用富方法就可以使用了。
 * 要使用算子列表状态，需要实现下面的接口
 */
public class Status {
    //实现该接口需要实现restoreState和snapshotState两个方法，前者是用于状态恢复的，后者
    //是用于生成检查点的
    public interface ListCheck<T extends Serializable> extends ListCheckpointed<T>{
    }
    //checkpointedFunction是用于指定有状态函数的最底层接口，实现该接口需要实现initializeState
    //和snapshotState，initializeState在创建CheckpointedFunction的并行实例时被调用。其触发
    //时机是应用启动或由于故障而重启任务。flink在调用该方法时会传入一个FunctionInitializationContext
    //对象。我们可以利用它访问OperatorStateStore和KeyedStateStore两个对象。这两个状态存储可以使用
    //flink运行时来注册函数状态并返回状态对象，比如ValueState、ListState、BroadcastState、我们在
    //注册一个状态时，都需要提供一个函数范围内唯一的名称，在函数注册状态过程中，状态存储首先会利用给
    //定名称检查状态后端是否存在一个为当前函数注册过的同名状态，并尝试用它对状态进行初始化。如果是重启
    //任务的情况，flink就会用保存的数据初始化状态，如果应用不是从检查点或保存点启动，那状态就会初始化
    //为空
    public interface Checkpointed extends CheckpointedFunction{
    }

}
