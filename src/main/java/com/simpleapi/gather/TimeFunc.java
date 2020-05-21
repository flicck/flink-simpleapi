package com.simpleapi.gather;

import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.functions.AssignerWithPunctuatedWatermarks;
import org.apache.flink.streaming.api.functions.IngestionTimeExtractor;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.time.Time;

/** wanghan
 * 水位线是判断数据是否超时的标志
 * 在方法assignTimestampsAndWatermarks(xxxx)中传入
 */

public class TimeFunc {
    //内置Extractor
    //周期性生成水位线，输入是任意新到元素和已到时间戳最大元素之间的时间差
    public abstract static class BoundedOutOfOrdernessTimestamp<T> extends BoundedOutOfOrdernessTimestampExtractor<T>{
        public BoundedOutOfOrdernessTimestamp(Time maxOutOfOrderness) {
            super(maxOutOfOrderness);
        }
    }
    //时间戳单调递增
    public abstract static class AscendingTimestamp<T> extends AscendingTimestampExtractor<T>{
    }
    //时间戳根据机器时间
    public abstract static class IngestionTime<T> extends IngestionTimeExtractor<T> {
    }
    //自定义分配器
    //周期性水位线
    public interface AssignerWithPeriodic<T> extends AssignerWithPeriodicWatermarks<T>{
    }
    //定点水位线
    public interface AssignerWithPunctuate<T> extends AssignerWithPunctuatedWatermarks<T>{
    }
}
