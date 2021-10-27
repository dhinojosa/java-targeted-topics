package com.evolutionnext.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    private final String name;

    public MyRunnable(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.format("Processing %s in Thread: %s, we are now %d/%d in waiting%n", name,
                Thread.currentThread(), cyclicBarrier.getNumberWaiting(), cyclicBarrier.getParties());
        try {
            cyclicBarrier.await(); //this may or may not last long
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.format("Finally finishing %s in Thread: %s%n", name,
                Thread.currentThread().getName());
    }
}
