/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchOrder
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-09 11:30
 * @Version: 1.0
 */
public class CountDownLatchOrder {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println("[" + Thread.currentThread().getName() + "] run over");
                countDownLatch.countDown();
            }, "Thread-" + (i + 1)).start();
        }
        countDownLatch.await();
        System.out.println("[Main thread] run over");
    }

}
