package com.github.uryyyyyyy.javaSamples.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class CommandThatFailsFast extends HystrixCommand<String> {


    public CommandThatFailsFast() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withCircuitBreakerRequestVolumeThreshold(3)
                        .withCircuitBreakerSleepWindowInMilliseconds(200)
                ));
    }

    @Override
    protected String run() {
        System.out.println("heavy command start");
        Main.sleep(100);
        throw new RuntimeException("");
    }

    @Override
    protected String getFallback() {
        return "command Failure!";
    }
}