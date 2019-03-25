/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.util;

import org.junit.Test;

/**
 * @ClassName: ZigZagText
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/20 4:37 PM
 * @Version: 1.0
 */
public class ZigZagText {

    @Test
    public void testEndcode() {
        int n = 123456789;
        int ne = ZigZag.encodeZigZag32(n);
        System.out.println(ne);
    }

    @Test
    public void testDecode() {
        int ne = 246913578;
        int n = ZigZag.decodeZigZag32(ne);
        System.out.println(n);
    }

}
