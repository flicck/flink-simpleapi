# flink-simpleapi
由于笔者觉得flink的一些api太难记了，就写了这个工具包，将一些函数放在一块方便大家调用。  
使用方式：maven clean install  
然后在其他项目中加入  
 
`<dependency>`  
`<groupId>io.flicck.github</groupId>`  
`<artifactId>flink-simpleapi</artifactId>`  
`<version>1.0.0</version>`  
`</dependency>`  

以下为api结构图  
![结构](https://github.com/flicck/flink-simpleapi/blob/master/src/main/resources/gather%E5%8C%85%E4%B8%8B.png)
上面这些的接口或类或方法，有些是需要new出来，有些是需要实现或继承，根据所处场景进行判断  
如 `.window(Win.Sliding.eventTime(Time.seconds(2L), Time.seconds(2L)))`
![结构](https://github.com/flicck/flink-simpleapi/blob/master/src/main/resources/StreamEnv%E5%85%A5%E5%8F%A3.png)  


`final StreamEnv streamEnv = new StreamEnv();`  
      `streamEnv.from.collection(xxxxx);`  
      `streamEnv.checkPoint.enable(xxxx);`  
        `streamEnv.config.setStreamTimeCharacteristic(xxxx);`  
        `streamEnv.exConfig.setAutoWatermarkInterval(xxxx);` 等等  
        
### 下一阶段 整合所有Connector到StreamEnv，提供统一的入口
