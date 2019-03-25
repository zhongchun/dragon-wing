/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.bean;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 * @ClassName: MessageTest
 * @Project: dragon-wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/1/31 3:07 PM
 * @Version: 1.0
 */
public class MessageTest {

    @Test
    public void testProtobuf() {
        Message.Person.Builder builder = Message.Person.newBuilder();
        builder.setId(31432);
        builder.setName("Atom");
        builder.addPhone(Message.Person.Phone.newBuilder().setNumber("10010").setType(Message.Person.PhoneType.MOBILE));
        builder.addPhone(Message.Person.Phone.newBuilder().setNumber("10086").setType(Message.Person.PhoneType.HOME));
        builder.addPhone(Message.Person.Phone.newBuilder().setNumber("10000").setType(Message.Person.PhoneType.WORK));
        Message.Person person = builder.build();
        byte[] buff = person.toByteArray();
        try {
            Message.Person personOut = Message.Person.parseFrom(buff);
            System.out.print(personOut.toString());
            System.out.println("Buff length=" + buff.length);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        String json = "";
        try {
            json = JsonFormat.printer().print(builder);
            System.out.println(json);
            System.out.println("Json length=" + json.getBytes().length);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }

}
