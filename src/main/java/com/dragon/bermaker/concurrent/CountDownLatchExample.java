/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Count down latch example.
 *
 * @ClassName: CountDownLatchExample
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 -04-08 18:15
 * @Version: 1.0
 */
public class CountDownLatchExample implements Runnable {

    private static final int NUMBER_OF_THREADS = 5;

    private static final CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

    private static final Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            int randomSleepTime = random.nextInt(20000);
            System.out.println("[" + Thread.currentThread().getName() + "] Sleeping for " + randomSleepTime);
            Thread.sleep(randomSleepTime);
            latch.countDown();
            System.out.println("[" + Thread.currentThread().getName() + "] Waiting for latch");
            latch.await();
            System.out.println("[" + Thread.currentThread().getName() + "] Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(new CountDownLatchExample());
        }
        executorService.shutdown();
    }
}
