package com.example.study.completablefuture.controller;


import com.example.study.completablefuture.service.CompletableFutureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cfuture")
@RequiredArgsConstructor
@Slf4j
public class CompletableFutureController {

    private final CompletableFutureService completableFutureService;

    @GetMapping("/forkjoin")
    public CompletableFuture<ResponseEntity<String>> asyncForkJoinPool(@RequestParam String value){
        return completableFutureService.asyncForkJoinPool(value).thenApply(ResponseEntity::ok);
    }
    @GetMapping("/threadpool")
    public CompletableFuture<ResponseEntity<String>> asyncThreadPool(@RequestParam String value){
        return completableFutureService.asyncThreadPool(value).thenApply(ResponseEntity::ok);
    }
    @GetMapping("/virtual")
    public CompletableFuture<ResponseEntity<String>> asyncVirtualThreadPool(@RequestParam String value){
        return completableFutureService.asyncVirtualThreadPool(value).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/sync")
    public ResponseEntity<String> sync(@RequestParam String value)  {
        return ResponseEntity.ok(completableFutureService.getString(value));
    }
}
