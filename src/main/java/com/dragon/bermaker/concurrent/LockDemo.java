/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockDemo
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-04-09 16:25
 * @Version: 1.0
 */
public class LockDemo {

    private List<Integer> list = new ArrayList<>();

    private Lock lock = new ReentrantLock();

    public void insert(Thread thread) {
        //        lock.lock();
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + " gets the lock");
                for (int i = 0; i < 5; i++) {
                    list.add(i);
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(thread.getName() + " releases the lock");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + " failed to get the lock");
        }
    }

    public static void main(String[] args) {
        final LockDemo lockDemo = new LockDemo();
        new Thread(() -> lockDemo.insert(Thread.currentThread())).start();
        new Thread(() -> lockDemo.insert(Thread.currentThread())).start();
    }

}
