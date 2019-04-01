/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

/**
 * @ClassName: NotSynchronizedCounter
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-01 19:05
 * @Version: 1.0
 */
public class NotSynchronizedCounter implements Runnable {

    private static int counter = 0;

    @Override
    public void run() {
        while (counter < 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] before: " + counter);
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + "] after: " + counter);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NotSynchronizedCounter(), "thread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }
}
