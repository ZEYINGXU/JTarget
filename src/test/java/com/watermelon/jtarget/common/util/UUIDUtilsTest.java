package com.watermelon.jtarget.common.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UUIDUtilsTest {

    @Autowired
    private UUIDUtils uuidUtils;

    @Test
    public void testUUID() {
        String uuid = uuidUtils.generate();
        Assert.assertEquals(uuid.length(), 32);
    }
}