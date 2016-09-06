package com.sender;


import org.apache.commons.codec.binary.Base64;

/**
 * {@author equa1s}
 */
public class Base64Util {

    public static String encode(String param) {
        return new String(Base64.encodeBase64(param.getBytes()));
    }

    public static String decode(String param) {
        return new String(Base64.decodeBase64(param.getBytes()));
    }

}
