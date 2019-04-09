/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: CyclicBarrierExample
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-08 18:23
 * @Version: 1.0
 */
public class CyclicBarrierExample implements Runnable {

    private static final int NUMBER_OF_THREADS = 5;
    private static AtomicInteger counter = new AtomicInteger();
    private static Random random = new Random(System.currentTimeMillis());
    private static final CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
        public void run() {
            counter.incrementAndGet();
        }
    });

    @Override
    public void run() {
        try {
            while (counter.get() < 3) {
                int randomSleepTime = random.nextInt(10000);
                System.out.println("[" + Thread.currentThread().getName() + "] Sleeping for " + randomSleepTime);
                Thread.sleep(randomSleepTime);
                System.out.println("[" + Thread.currentThread().getName() + "] Waiting for barrier.");
                barrier.await();
                System.out.println("[" + Thread.currentThread().getName() + "] Finished.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(new CyclicBarrierExample());
        }
        executorService.shutdown();
    }
}
