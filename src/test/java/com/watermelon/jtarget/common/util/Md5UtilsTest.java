package com.watermelon.jtarget.common.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5UtilsTest {

    @Autowired
    private Md5Utils md5Utils;

    @Test
    public void encoding() {
        String str = "test";
        Assert.assertEquals("098f6bcd4621d373cade4e832627b4f6", md5Utils.encoding(str));
    }

    @Test
    public void match() {
        Assert.assertEquals(true, md5Utils.match("test", "098f6bcd4621d373cade4e832627b4f6"));
        Assert.assertEquals(true, md5Utils.match("", ""));
        Assert.assertEquals(true, md5Utils.match("", null));
    }
}