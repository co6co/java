[主页](../reademe.md)

-  application 增加 @EnableCircuitBreaker
-  在需要开启熔断降级的方法上添加@HystrixCommand
```
@HystrixCommand(fallbackMethod = "helloFallback")
@GetMapping("/hello")
public String hello(String msg){
    throw new RuntimeException("hello throw RuntimeException");
}
public String helloFallback(String msg, Throwable t) {
    return "helloFallback:" + msg + "," + t.getMessage();
}
````
- 异常传播
抛出`HystrixBadRequestException`,不会进入到fallback,业务异常继承`HystrixBadRequestException`
`ignoreExceptions` 

```
@HystrixCommand(fallbackMethod = "helloFallback", 
                     ignoreExceptions = ParamException.class)
```
- 熔断
```java
    @GetMapping("/open")
    //如果5秒内，请求达到了4个，错误率达到50%以上，就开启跳闸，
    //就会直接走fallback，业务代码将不再会调用
    //如果3秒以后再调用，会再执行一次业务方法
    @HystrixCommand(
      fallbackMethod = "openFallback",
      commandProperties={
          @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000"),
          @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="4"),
          @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
          @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="3000")
      }
    )
    public String open(){...}
       
```
当然如果不想在代码中做配置，也可以在配置文件做配置：
```xml
hystrix:
  command:
    # 这里的default代表默认的所有的command
    # 可以换成某一个特定的command的key，默认就是方法的名字
    default:
      execution:
        isolation:
          #strategy: SEMAPHORE
          thread:
            timeoutInMilliseconds: 1000
      metrics:
        rollingStats:
          timeInMilliseconds: 5000
      circuitBreaker:
        requestVolumeThreshold: 4
        errorThresholdPercentage: 50
        sleepWindowInMilliseconds: 3000
    # 设置某个具体的command的参数
    commandKeyTest:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 10000
```

