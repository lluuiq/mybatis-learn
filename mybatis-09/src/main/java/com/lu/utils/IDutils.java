package com.lu.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class IDutils {
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test() {
        System.out.println(IDutils.getID());
    }
}