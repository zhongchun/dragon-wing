/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The type Executors example.
 *
 * @ClassName: ExecutorsExample
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 -04-08 17:04
 * @Version: 1.0
 */
public class ExecutorsExample implements Callable<Integer> {

    private static Random random = new Random(System.currentTimeMillis());

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return random.nextInt(100);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     *
     * @throws ExecutionException   the execution exception
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer>[] futures = new Future[5];
        for (int i = 0; i < futures.length; i++) {
            futures[i] = executorService.submit(new ExecutorsExample());
        }
        for (int i = 0; i < futures.length; i++) {
            Integer retVal = futures[i].get();
            System.out.println(retVal);
        }
        executorService.shutdown();
    }

}
