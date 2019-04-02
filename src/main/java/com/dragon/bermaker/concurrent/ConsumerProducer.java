/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName: ConsumerProducer
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-02 10:45
 * @Version: 1.0
 */
public class ConsumerProducer {

    private static final Queue<Integer> queue = new ConcurrentLinkedQueue();

    private static final long startMills = System.currentTimeMillis();

    public static class Producer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (System.currentTimeMillis() < (startMills + 10000)) {
                queue.add(i++);
                synchronized(queue) {
                    queue.notify();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized(queue) {
                queue.notifyAll();
            }
        }
    }

    public static class Consumer implements Runnable {
        @Override
        public void run() {
            while (System.currentTimeMillis() < (startMills + 10000)) {
                synchronized(queue) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!queue.isEmpty()) {
                    Integer i = queue.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "]: " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] consumerThreads = new Thread[5];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);
            consumerThreads[i].start();
        }
        Thread producerThread = new Thread(new Producer(), "producer");
        producerThread.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].join();
        }
        producerThread.join();
    }
}
