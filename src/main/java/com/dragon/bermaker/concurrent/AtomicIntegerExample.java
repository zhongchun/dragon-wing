/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AtomicIntegerExample
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-08 17:51
 * @Version: 1.0
 */
public class AtomicIntegerExample implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int newValue = atomicInteger.getAndIncrement();
            if (newValue == 42) {
                System.out.println("[" + Thread.currentThread().getName() + "]: " + newValue);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new AtomicIntegerExample());
        }
        executorService.shutdown();
    }
}
