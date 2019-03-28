/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.enums;

/**
 * @ClassName: Week
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019-03-28 17:28
 * @Version: 1.0
 */
public enum Week {
    MON("Monday", 1),

    TUE("Tuesday", 2),

    WED("Wensday", 3),

    THU("Thursday", 4),

    FRI("Friday", 5),

    SAT("Saturday", 6),

    SUN("Sunday", 7);

    private final String name;

    private final int index;

    Week(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getName(int i) {
        for (Week w : Week.values()) {
            if (w.getIndex() == i) {
                return w.getName();
            }
        }
        throw new IllegalArgumentException();
    }

    public int getIndex() {
        return index;
    }

}


