/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.bean;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 * @ClassName: PersonModelTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/1/30 5:49 PM
 * @Version: 1.0
 */
public class PersonModelTest {

    @Test
    public void testProtobuf() {

        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(1);
        builder.setName("tiantian");
        builder.setEmail("tiantian@baidu.com");

        PersonModel.Person person = builder.build();
        System.out.println("Before: ");
        System.out.println(person);

        byte[] buff = person.toByteArray();
        System.out.println("=======================================================================");
        for (byte b : buff) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println("Buf length=" + buff.length);
        System.out.println("=======================================================================");


        PersonModel.Person personParsed = null;
        try {
            personParsed = PersonModel.Person.parseFrom(buff);
            System.out.println("After: ");
            System.out.println(personParsed);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        // 转换成json
        String json = "";
        try {
            json = JsonFormat.printer().print(builder);
            System.out.println(json.toString());
            System.out.println("Json length=" + json.getBytes().length);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }

}
