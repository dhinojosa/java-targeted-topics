package com.evolutionnext.concurrency.phaser;

import java.util.concurrent.Phaser;

public class PhaserRunner {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        Thread t = new Thread(new MyRunnable(phaser, "A"));
        Thread t2 = new Thread(new MyRunnable(phaser, "B"));
        Thread t3 = new Thread(new MyRunnable(phaser, "C"));
        Thread t4 = new Thread(new MyRunnable(phaser, "D"));

        //Thread.sleep(40);
        t.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
