/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Thread pool executor example.
 *
 * @ClassName: ThreadPoolExecutorExample
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 -04-08 16:05
 * @Version: 1.0
 */
public class ThreadPoolExecutorExample implements Runnable {

    private static AtomicInteger counter = new AtomicInteger();

    private int taskId;

    /**
     * Gets the value of taskId
     *
     * @return the value of taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Instantiates a new Thread pool executor example.
     *
     * @param taskId the task id
     */
    public ThreadPoolExecutorExample(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        //        ThreadFactory threadFactory  = new ThreadFactory() {
        //            @Override
        //            public Thread newThread(Runnable r) {
        //                int currentCount = counter.getAndIncrement();
        //                System.out.println("Create a new thread: " + currentCount);
        //                return new Thread(r, "mythread " + currentCount);
        //            }
        //        };
        //        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        //            @Override
        //            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //                if (r instanceof ThreadPoolExecutorExample) {
        //                    ThreadPoolExecutorExample example  = (ThreadPoolExecutorExample) r;
        //                    System.out.println("Rejecting task with id " + example.getTaskId());
        //                }
        //            }
        //        };

        // lambda expressions
        ThreadFactory threadFactory = r -> {
            int currentCount = counter.getAndIncrement();
            System.out.println("Create a new thread: " + currentCount);
            return new Thread(r, "mythread " + currentCount);
        };
        RejectedExecutionHandler rejectedExecutionHandler = (r, executor) -> {
            if (r instanceof ThreadPoolExecutorExample) {
                ThreadPoolExecutorExample example = (ThreadPoolExecutorExample) r;
                System.out.println("Rejecting task with id " + example.getTaskId());
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, queue, threadFactory,
                rejectedExecutionHandler);
        for (int i = 0; i < 100; i++) {
            executor.execute(new ThreadPoolExecutorExample(i));
        }
        executor.shutdown();
    }

}
