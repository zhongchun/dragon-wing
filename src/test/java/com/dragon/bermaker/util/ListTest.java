/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ListTest
 *
 * @Desc: TODO
 * @author: yuzhongchun
 * @date: Nov 30, 2018 7:12:12 PM
 */
public class ListTest {

    /**
     * @Title: ListTest
     * @Desc: TODO
     */
    public ListTest() {
        // TODO Auto-generated constructor stub
    }

    @Test
    public void testArrayList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        System.out.println(list);
    }


}
