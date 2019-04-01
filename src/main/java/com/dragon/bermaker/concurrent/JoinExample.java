/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;

/**
 * @ClassName: JoinExample
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-01 18:45
 * @Version: 1.0
 */
public class JoinExample implements Runnable {

    private Random rand = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            rand.nextInt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
    }

}
