package com.rick.schedule.test;

import com.rick.schedule.util.MD5Util;
import org.junit.Test;

public class TestMD5Util {
    @Test
    public void testEncrypt(){


        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }





}
