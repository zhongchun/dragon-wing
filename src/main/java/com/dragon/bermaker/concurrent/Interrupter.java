/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

/**
 * @ClassName: Interrupter
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-01 17:38
 * @Version: 1.0
 */
public class Interrupter implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
        }
        while (!Thread.interrupted()) {
            // do nothing here
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Interrupted for the second time.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Interrupter(), "myThread");
        myThread.start();

        System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
        myThread.interrupt();

        System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
        myThread.interrupt();
    }
}
