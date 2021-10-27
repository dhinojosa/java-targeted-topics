package com.evolutionnext.concurrency.primitives;

public class BankAccount {
    private int balance;

    public BankAccount(int i) {
        this.balance = i;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
        notifyAll();
    }

    public synchronized int withdrawal(int amount) {
        while ((this.balance - amount) <= 0) {
            try {
                wait();  //thread waits here.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.balance -= amount;
        return amount;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            BankAccount bankAccount = new BankAccount(0);
            new Thread(() -> {
                bankAccount.deposit(1000);
            }).start();
            new Thread(() -> {
                bankAccount.withdrawal(3000);
            }).start();
            new Thread(() -> {
                bankAccount.deposit(200);
            }).start();
            new Thread(() -> {
                bankAccount.deposit(500);
            }).start();
            new Thread(() -> {
                bankAccount.deposit(7000);
            }).start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(bankAccount.getBalance());
            System.out.println("Balance should be : " + (1000 + 200 + 500 + 7000 - 3000));
        }
    }
}
