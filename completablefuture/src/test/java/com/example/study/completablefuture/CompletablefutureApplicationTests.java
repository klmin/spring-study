package com.example.study.completablefuture;

import com.example.study.completablefuture.service.CompletableFutureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class CompletablefutureApplicationTests {

    @Autowired
    private CompletableFutureService completableFutureService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 병렬실행_동기() {

        log.info("## 병합테스트_동기 시작 ##");
        String param1 = "apple";
        String param2 = "banana";
        String param3 = "tomato";

        CompletableFuture<String> apple = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param1));
        CompletableFuture<String> banana = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param2));
        CompletableFuture<String> tomato = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param3));

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(apple, banana, tomato);

        String result = completableFuture.thenApply(v -> {

            String task1 = apple.join();
            String task2 = banana.join();
            String task3 = tomato.join();
            return task1 + task2 + task3;

        }).exceptionally(e -> {
            log.error("Exception : ", e);
            return null;
        }).join();

        log.info("## 완료 ##");
        assertEquals(result, param1 + param2 + param3);

        log.info("## 병합테스트_동기 종료 ##");

    }

    @Test
    void 병렬실행_비동기() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        log.info("## 병합테스트_비동기 start ##");

        String param1 = "apple";
        String param2 = "banana";
        String param3 = "tomato";

        CompletableFuture<String> apple = CompletableFuture.supplyAsync(() ->  completableFutureService.getString(param1));
        CompletableFuture<String> banana = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param2));
        CompletableFuture<String> tomato = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param3));

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(apple, banana, tomato);

        completableFuture.thenAccept(v -> {

            String task1 = apple.join();
            String task2 = banana.join();
            String task3 = tomato.join();
            String result = task1 + task2 + task3;

            log.info("## 완료 ##");
            assertEquals(result, param1 + param2 + param3);

            countDownLatch.countDown();
        }).exceptionally(e -> {
            log.error("Exception : ", e);
            return null;
        });


        log.info("## 병합테스트_비동기 end ##");
        countDownLatch.await();
    }

    @Test
    void 병렬실행_예외() throws Exception{

        log.info("## 병합테스트_예외 시작 ##");
        String param1 = "apple";
        String param2 = "banana";
        String param3 = "tomato";

        CompletableFuture<String> apple = CompletableFuture.supplyAsync(() ->
                completableFutureService.getStringException(true, param1)
        ).exceptionally(e -> {
            log.error("### apple error", e);
            return null;
        });

        CompletableFuture<String> banana = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param2));
        CompletableFuture<String> tomato = CompletableFuture.supplyAsync(() ->  completableFutureService.getString(param3));

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(apple, banana, tomato);

        String result = completableFuture.thenApply(v -> {

            String task1 = apple.join();
            String task2 = banana.join();
            String task3 = tomato.join();
            return task1 + task2 + task3;

        }).exceptionally(e -> {
            log.error("thenapply exception", e);
            return null;
        }).join();

        log.info("## 완료 ##");
        assertEquals(result, "null"+param2+param3);

        String result1 = completableFuture.thenApply(v -> {

            String task2 = banana.join();
            String task3 = tomato.join();
            if("banana".equals(task2)){
                throw new RuntimeException("강제 예외");
            }
            return task2 + task3;

        }).exceptionally(e -> {
            log.error("thenapply exception", e);
            return null;
        }).join();

        assertNull(result1);

        log.info("## 병합테스트_예외 종료 ##");

    }

    @Test
    void 병합테스트() throws Exception{

        log.info("## 병합테스트 시작 ##");
        String param1 = "apple";
        String param2 = "banana";
        String param3 = "tomato";

        CompletableFuture<String> apple = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param1));
        CompletableFuture<String> banana = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param2));
        CompletableFuture<String> tomato = CompletableFuture.supplyAsync(() -> completableFutureService.getString(param3));

        CountDownLatch countDownLatch = new CountDownLatch(1);

        CompletableFuture<String> result = apple.thenCombine(banana, (a,b) -> a + " and " + b)
                .thenCombine(tomato, (b,c) -> b + " and "+ c);

        result.thenAccept(r -> {
            log.info("result : {}", r);
            countDownLatch.countDown();
        });

        log.info("## 병합테스트 종료 ##");
        assertEquals(result.join(), param1 + " and "+param2 + " and "+param3);

        countDownLatch.await();

    }

    @Test
    void 비동기실행만하기() throws Exception{

        log.info("## 비동기실행만하기 시작 ##");
        String param1 = "apple";
        String param2 = "banana";

        CountDownLatch countDownLatch = new CountDownLatch(2);

        CompletableFuture.runAsync(() -> {
            String result = completableFutureService.getString(param1);
            log.info("run apple : {}", result);
            countDownLatch.countDown();
        });
        CompletableFuture.runAsync(() -> {
            String result = completableFutureService.getString(param2);
            log.info("run banana : {}", result);
            countDownLatch.countDown();
        });


        log.info("## 비동기실행만하기 종료 ##");


        countDownLatch.await();

    }

    @Test
    void 예외또는결과(){

        CompletableFuture.runAsync(() -> {
                    completableFutureService.getString("apple");
                    Random random = new Random();
                    boolean shouldThrowException = random.nextBoolean();
                    if(shouldThrowException){
                        throw new RuntimeException("강제예외");
                    }
                }).handle((result, ex) -> {
                    if (ex != null) {
                        log.error("Exception: ", ex);
                        return "fail";
                    }
                    return "success";
                }).thenAccept(r -> {
                    log.info("결과 : {}", r);
                }).thenRun(() -> log.info("## 종료 ##"))
                .join();


        String s = CompletableFuture.supplyAsync(() -> {
                    String apple = completableFutureService.getString("apple");
                    Random random = new Random();
                    boolean shouldThrowException = random.nextBoolean();
                    if(shouldThrowException){
                        throw new RuntimeException("강제예외");
                    }
                    return apple;
                }).handle((result, ex) -> {
                    if (ex != null) {
                        log.error("Exception: ", ex);
                        return "fail";
                    }
                    return result;

                })
                .thenApply(String::toUpperCase)
                .join();

        log.info("result {}", s);
    }

    @Test
    void 비동기컨트롤러_포크조인() throws Exception {

        String value = "test";

        List<CompletableFuture<MvcResult>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CompletableFuture<MvcResult> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return mockMvc.perform(get("/cfuture/forkjoin")
                                    .param("value", value))
                            .andExpect(request().asyncStarted())
                            .andReturn();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (CompletableFuture<MvcResult> future : futures) {
            MvcResult result = future.join();
            mockMvc.perform(asyncDispatch(result))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().string(value))
            ;

        }
    }

    @Test
    void 비동기컨트롤러_스레드풀() throws Exception {

        String value = "test";

        List<CompletableFuture<MvcResult>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CompletableFuture<MvcResult> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return mockMvc.perform(get("/cfuture/threadpool")
                                    .param("value", value))
                            .andExpect(request().asyncStarted())
                            .andReturn();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (CompletableFuture<MvcResult> future : futures) {
            MvcResult result = future.join();
            mockMvc.perform(asyncDispatch(result))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().string(value))
            ;

        }
    }

    @Test
    void 비동기컨트롤러_가상스레드풀() throws Exception {

        String value = "test";

        List<CompletableFuture<MvcResult>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CompletableFuture<MvcResult> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return mockMvc.perform(get("/cfuture/virtual")
                                    .param("value", value))
                            .andExpect(request().asyncStarted())
                            .andReturn();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (CompletableFuture<MvcResult> future : futures) {
            MvcResult result = future.join();
            mockMvc.perform(asyncDispatch(result))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().string(value))
            ;

        }
    }


    @Test
    void 동기컨트롤러() throws Exception {

        String value = "test";

        for(int i = 0; i < 100; i++) {
            mockMvc.perform(get("/cfuture/sync")
                            .param("value", "test"))
                    .andDo(print())
                    .andExpect(content().string(value));

        }

    }

}
