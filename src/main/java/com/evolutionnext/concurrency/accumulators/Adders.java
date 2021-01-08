package com.evolutionnext.concurrency.accumulators;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class Adders {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
               longAdder.add(i);
            }
        });

        executorService.submit(() -> {
            for (int i = 200; i < 300; i++) {
                longAdder.add(i);
            }
        });

        System.out.println(longAdder.sum());
        executorService.shutdown();
    }
}
