/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.util;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: StackTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/28 2:01 PM
 * @Version: 1.0
 */
public class StackTest {

    private Stack<String> stack = new Stack<>();

    private LinkedList<String> list = new LinkedList<>();

    @Before
    public void init() {
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("E");
    }

    @Test
    public void testStackBasic() {
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list);
    }

}
