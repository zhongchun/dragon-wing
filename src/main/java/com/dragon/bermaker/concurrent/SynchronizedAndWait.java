/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName: SynchronizedAndWait
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-02 11:08
 * @Version: 1.0
 */
public class SynchronizedAndWait {

    private static final Queue queue = new ConcurrentLinkedQueue();

    public Integer getNextInt() {
        Integer retVal = null;
        synchronized(queue) {
            try {
                while (queue.isEmpty()) {
                    queue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retVal = (Integer) queue.poll();
        }
        return retVal;
    }

    public void putInt(Integer value) {
        synchronized(queue) {
            queue.add(value);
            queue.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedAndWait queue = new SynchronizedAndWait();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.putInt(i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Integer nextInt = queue.getNextInt();
                    System.out.println("Next int: " + nextInt);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
