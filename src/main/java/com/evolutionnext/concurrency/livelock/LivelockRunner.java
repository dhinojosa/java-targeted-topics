package com.evolutionnext.concurrency.livelock;

/**
 * Livelock occurs when two threads are expecting a state from each other but
 * never make it.
 * Thread-1 acts as a response to action of Thread-2
 * Thread 2 acts as a response to action of Thread-1
 **/
public class LivelockRunner {
    static final Police police = new Police();
    static final Criminal criminal = new Criminal();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> police.giveRansom(criminal));
        t1.start();

        Thread t2 = new Thread(() -> criminal.releaseHostage(police));
        t2.start();
    }
}
