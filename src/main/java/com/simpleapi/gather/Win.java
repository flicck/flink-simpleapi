package com.simpleapi.gather;


import org.apache.flink.streaming.api.windowing.assigners.*;
import org.apache.flink.streaming.api.windowing.time.Time;

/**  wanghan
 *  常用的窗口可以直接点出来，不用去背了
 */
public class Win {
    public static class Tumbling{
        public static TumblingEventTimeWindows eventTime(Time size){
            return TumblingEventTimeWindows.of(size);
        }
        public static TumblingEventTimeWindows eventTime(Time size,Time offset){
            return TumblingEventTimeWindows.of(size,offset);
        }
        public static TumblingProcessingTimeWindows processTime(Time size){
            return TumblingProcessingTimeWindows.of(size);
        }
        public static TumblingProcessingTimeWindows processTime(Time size,Time offset){
            return TumblingProcessingTimeWindows.of(size,offset);
        }
        @Deprecated
        public static TumblingTimeWindows time(Time size){
           return TumblingTimeWindows.of(size);
        }
        public static TumblingEventTimeWindows time(Time size,Time offset){
            return TumblingTimeWindows.of(size,offset);
        }
    }
    public static class Sliding{
        public static SlidingEventTimeWindows eventTime(Time size,Time slide){
            return SlidingEventTimeWindows.of(size,slide);
        }
        public static SlidingEventTimeWindows eventTime(Time size,Time slide,Time offset){
            return SlidingEventTimeWindows.of(size,slide,offset);
        }
    }
    public static class Session{
        public static EventTimeSessionWindows eventTime(Time size){
            return EventTimeSessionWindows.withGap(size);
        }
        public static <T> DynamicEventTimeSessionWindows<T> eventTime(SessionWindowTimeGapExtractor<T> sessionWindowTimeGapExtractor){
             return EventTimeSessionWindows.withDynamicGap(sessionWindowTimeGapExtractor);
        }
        public static ProcessingTimeSessionWindows processTime(Time size){
            return ProcessingTimeSessionWindows.withGap(size);
        }
        public static <T> DynamicProcessingTimeSessionWindows<T> processTime(SessionWindowTimeGapExtractor<T> sessionWindowTimeGapExtractor){
            return ProcessingTimeSessionWindows.withDynamicGap(sessionWindowTimeGapExtractor);
        }
    }
}
