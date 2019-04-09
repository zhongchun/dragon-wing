/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: SemaphoreExample
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-08 18:03
 * @Version: 1.0
 */
public class SemaphoreExample implements Runnable {

    private static final Semaphore semaphore = new Semaphore(3, true);

    private static final AtomicInteger counter = new AtomicInteger();

    private static final long endMillis = System.currentTimeMillis() + 10000;

    @Override
    public void run() {
        while (System.currentTimeMillis() < endMillis) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int counterValue = counter.incrementAndGet();
            System.out.println("[" + Thread.currentThread().getName() + "] semaphore acquired: " + counterValue);
            if (counterValue > 3) {
                throw new IllegalArgumentException("More than three threads acquired the lock");
            }
            counter.decrementAndGet();
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SemaphoreExample());
        }
        executorService.shutdown();
    }
}
