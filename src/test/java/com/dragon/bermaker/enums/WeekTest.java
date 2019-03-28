/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.enums;

import org.junit.Test;

/**
 * @ClassName: WeekTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-03-28 17:49
 * @Version: 1.0
 */
public class WeekTest {

    @Test
    public void testEnumPrint() {
        for (Week w : Week.values()) {
            System.out.println(w);
        }
        System.out.println(Week.MON.getName());
    }
}
