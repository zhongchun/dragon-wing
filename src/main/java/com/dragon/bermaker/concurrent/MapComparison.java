/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The type Map comparison.
 *
 * @ClassName: MapComparison
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 -04-08 17:25
 * @Version: 1.0
 */
public class MapComparison implements Runnable {

    private static Map<Integer, String> map;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            int randomInt = random.nextInt(100);
            map.get(randomInt);
            randomInt = random.nextInt(100);
            map.put(randomInt, String.valueOf(randomInt));
        }
    }

    private static void fillMap(Map<Integer, String> map) {
        for (int i = 0; i < 100; i++) {
            map.put(i, String.valueOf(i));
        }
    }

    private static void runPerfTest(Map<Integer, String> map) throws InterruptedException {
        MapComparison.map = map;
        fillMap(map);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long startMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MapComparison());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(
                map.getClass().getSimpleName() + " took " + (System.currentTimeMillis() - startMillis) + " ms");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     *
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        runPerfTest(new Hashtable<>());
        runPerfTest(Collections.synchronizedMap(new HashMap<>()));
        runPerfTest(new ConcurrentHashMap<>());
        runPerfTest(new ConcurrentSkipListMap<>());
    }
}
