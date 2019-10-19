package com.watermelon.jtarget.common.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtils {

    public String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
