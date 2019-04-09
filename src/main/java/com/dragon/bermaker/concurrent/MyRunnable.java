/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

/**
 * The type My runnable.
 *
 * @ClassName: MyRunnable
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 -04-01 17:28
 * @Version: 1.0
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing thread: " + Thread.currentThread().getName());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable(), "myRunnable");
        myThread.start();
    }
}
