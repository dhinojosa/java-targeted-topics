package com.evolutionnext.concurrency.threads;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class UsingExecutorService {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(4);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                 //Query your MQ
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> hello = executorService.submit(
            () -> System.out.println("Hello"), 10);

        for (int i = 0; i < 5; i++) {
            final int x = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(x * 10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        //1.5
        Future<Integer> integerFuture =
            executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 120 + 34;
            }
        });

        //8
        CompletableFuture<Integer> integerCompletableFuture =
            CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 40;
            }
        });

        integerCompletableFuture.thenApply(x -> x * 10);
        executorService.shutdown();
    }
}
