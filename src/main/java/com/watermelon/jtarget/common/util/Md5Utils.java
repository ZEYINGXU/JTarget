package com.watermelon.jtarget.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Md5Utils {

    public String encoding(String content) {
        return DigestUtils.md5Hex(content.getBytes());
    }

    public boolean match(String content, String cipherText) {
        if (StringUtils.isEmpty(content)
                && StringUtils.isEmpty(cipherText)) {
            return true;
        }
        if (! StringUtils.isEmpty(content)) {
            String contentText = encoding(content);
            return contentText.equals(cipherText);
        }
        return false;
    }
}
