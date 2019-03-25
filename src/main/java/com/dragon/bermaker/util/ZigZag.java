/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.util;

/**
 * @ClassName: ZigZag
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/2/20 4:36 PM
 * @Version: 1.0
 */
public class ZigZag {

    /**
     * @param n
     *
     * @return
     */
    public static int encodeZigZag32(int n) {
        return (n << 1) ^ (n >> 31);
    }

    /**
     * @param n
     *
     * @return
     */
    public static int decodeZigZag32(int n) {
        return (n >>> 1) ^ -(n & 1);
    }
}
