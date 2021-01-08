package com.evolutionnext.concurrency.accumulators;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class Accumulators {
    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            for (int i = 1; i < 10; i++) {
                longAccumulator.accumulate(i);
            }
        });

        executorService.submit(() -> {
            for (int i = 20; i < 30; i++) {
                longAccumulator.accumulate(i);
            }
        });

        System.out.println(longAccumulator.longValue());
        executorService.shutdown();
    }


}
