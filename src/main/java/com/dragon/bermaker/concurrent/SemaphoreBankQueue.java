/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SemaphoreBankQueue
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-09 10:49
 * @Version: 1.0
 */
public class SemaphoreBankQueue {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                if (semaphore.availablePermits() > 0) {
                    System.out.println("[" + Thread.currentThread().getName() + "] enter the bank, there is "
                            + "windows which can service");
                } else {
                    System.out.println("[" + Thread.currentThread().getName() + "] should in line to wait for "
                            + "service");
                }
                try {
                    semaphore.acquire();
                    System.out.println("[" + Thread.currentThread().getName() + "] starts to be in service");
                    int serviceTime = random.nextInt(10);
                    TimeUnit.SECONDS.sleep(serviceTime);
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] ends service, service time=" + serviceTime);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Consumer-" + (i + 1)).start();

        }
    }

}
