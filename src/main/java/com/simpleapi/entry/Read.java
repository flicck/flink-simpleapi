package com.simpleapi.entry;

import org.apache.flink.api.common.io.FileInputFormat;
import org.apache.flink.api.common.io.FilePathFilter;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;

public class Read {
    private StreamExecutionEnvironment env;
    protected Read(StreamExecutionEnvironment env) {
        this.env = env;
    }
    public <OUT> DataStreamSource<OUT> file(FileInputFormat<OUT> inputFormat,
                                            String filePath){
       return env.readFile(inputFormat, filePath, FileProcessingMode.PROCESS_ONCE, -1);
    }
    @Deprecated
    public <OUT> DataStreamSource<OUT> file(FileInputFormat<OUT> inputFormat,
                                                String filePath,
                                                FileProcessingMode watchType,
                                                long interval,
                                                FilePathFilter filter){
        return env.readFile(inputFormat,filePath,watchType,interval,filter);
    }
    public <OUT> DataStreamSource<OUT> file(FileInputFormat<OUT> inputFormat,
                                                String filePath,
                                                FileProcessingMode watchType,
                                                long interval) {
        return env.readFile(inputFormat,filePath,watchType,interval);
    }
    public <OUT> DataStreamSource<OUT> file(FileInputFormat<OUT> inputFormat,
                                                String filePath,
                                                FileProcessingMode watchType,
                                                long interval,
                                                TypeInformation<OUT> typeInformation){
        return env.readFile(inputFormat,filePath,watchType,interval,typeInformation);
    }
    public DataStreamSource<String> textFile(String filePath) {
        return env.readTextFile(filePath);
    }
    public DataStreamSource<String> textFile(String filePath, String charsetName){
        return env.readTextFile(filePath,charsetName);
    }
}
