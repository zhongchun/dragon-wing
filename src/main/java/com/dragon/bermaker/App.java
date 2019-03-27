/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 * @author java-cmc
 * @version 1.0.0
 * @since 1.0.0
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("args num={}, args1={}, args2={}", args.length, args[0], args[1]);
        LOG.info("Hi, dragon wing!");
    }
}
