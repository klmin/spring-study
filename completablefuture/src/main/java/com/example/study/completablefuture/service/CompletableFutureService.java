package com.example.study.completablefuture.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class CompletableFutureService {

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public CompletableFutureService(@Qualifier("secondThreadPool") ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    public String getString(String value) {
        try {
            Thread thread = Thread.currentThread();
            log.info("therad name : {}, id : {}, group : {}, daemon : {}", thread.getName(), thread.getId(), thread.getThreadGroup(), thread.isDaemon());
            Thread.sleep(200);
        }catch(InterruptedException e){
            return null;
        }
        return value;
    }
    public String getStringException(boolean flag, String value){
        if(flag) {
            throw new RuntimeException();
        }
        return value;
    }

    public CompletableFuture<String> asyncVirtualThreadPool(String value){
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            return CompletableFuture.supplyAsync(() -> getString(value), executor);
        }
    }

    public CompletableFuture<String> asyncThreadPool(String value){
        return CompletableFuture.supplyAsync(() -> getString(value), threadPoolTaskExecutor);
    }

    public CompletableFuture<String> asyncForkJoinPool(String value){
        return CompletableFuture.supplyAsync(() -> getString(value));
    }

}
