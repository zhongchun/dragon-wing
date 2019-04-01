/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;

/**
 * @ClassName: DeadLcok
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-01 19:31
 * @Version: 1.0
 */
public class DeadLcok implements Runnable {

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            boolean b = random.nextBoolean();
            if (b) {
                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
                synchronized(resource1) {
                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
                    synchronized(resource2) {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                    }
                }
            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
                synchronized(resource2) {
                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
                    synchronized(resource1) {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLcok(), "thread-1");
        Thread t2 = new Thread(new DeadLcok(), "thread-2");
        t1.start();
        t2.start();
    }
}
