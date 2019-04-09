/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockInterruptiblyDemo
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-09 17:01
 * @Version: 1.0
 */
public class LockInterruptiblyDemo {

    private Lock lock = new ReentrantLock();

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + " gets the lock");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE) {
                    break;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " execute finally");
            lock.unlock();
            System.out.println(thread.getName() + " releases the lock");
        }
    }

    public static void main(String[] args) {
        LockInterruptiblyDemo test = new LockInterruptiblyDemo();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    static class MyThread extends Thread {
        private LockInterruptiblyDemo demo = null;

        public MyThread(LockInterruptiblyDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            try {
                demo.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                e.printStackTrace();
            }
        }
    }

}
