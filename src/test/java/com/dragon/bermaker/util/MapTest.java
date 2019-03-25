/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @ClassName: MapTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/25 7:26 PM
 * @Version: 1.0
 */
public class MapTest {

    @Test
    public void testLinkedHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.entrySet().iterator();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.entrySet().iterator();
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.entrySet().iterator();
        Map map = Collections.synchronizedMap(hashMap);
        map.entrySet().iterator();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    }

}
