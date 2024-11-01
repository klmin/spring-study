    package com.example.study.completablefuture.config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Primary;
    import org.springframework.scheduling.annotation.EnableAsync;
    import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

    @Configuration
    @EnableAsync
    public class AsyncBean  {

        @Bean(name="primaryThreadPool")
        @Primary
        public ThreadPoolTaskExecutor threadPoolExecutor(){
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(8);
            executor.setThreadNamePrefix("primary-");
            executor.initialize();
            return executor;
        }

        @Bean(name="secondThreadPool")
        public ThreadPoolTaskExecutor secondThreadPool(){
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(16);
            executor.setThreadNamePrefix("second-");
            executor.initialize();
            return executor;
        }

    }
