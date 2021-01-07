package com.evolutionnext.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * * It enables you to define a synchronization object that suspends until
 * the specified number of threads has reached the barrier point.
 * * Call to `await` must be made within the `Thread`
 * * When the amount of the barrier has been reached execution will resume
 */
public class CyclicBarrierRunner {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("Done");
        });

        Thread t1 = new Thread(new MyRunnable(cyclicBarrier, "A"));
        Thread t2 = new Thread(new MyRunnable(cyclicBarrier, "B"));
        Thread t3 = new Thread(new MyRunnable(cyclicBarrier, "C"));
        Thread t4 = new Thread(new MyRunnable(cyclicBarrier, "D"));
        Thread t5 = new Thread(new MyRunnable(cyclicBarrier, "E"));
        Thread t6 = new Thread(new MyRunnable(cyclicBarrier, "F"));
        Thread t7 = new Thread(new MyRunnable(cyclicBarrier, "G"));
        Thread t8 = new Thread(new MyRunnable(cyclicBarrier, "H"));
        Thread t9 = new Thread(new MyRunnable(cyclicBarrier, "I"));
        Thread t10 = new Thread(new MyRunnable(cyclicBarrier, "J"));
        Thread t11 = new Thread(new MyRunnable(cyclicBarrier, "K"));
        Thread t12 = new Thread(new MyRunnable(cyclicBarrier, "L"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
    }
}
