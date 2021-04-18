package com.clover.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;


/**
 * @ClassName: EncryptUtil
 * @Description: base64加密解密
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    /**
     * 将字节数组进行base64编码
     *
     * @param bytes
     * @return
     */
    public static String encodeBase64(byte[] bytes) {
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

    /**
     * 将字符串进行base64解码
     *
     * @param str
     * @return
     */
    public static byte[] decodeBase64(String str) {
        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(str);
        return bytes;
    }

    /**
     * 将字符串str 先使用utf-8符集进行url编码 +转为%2B ?转为%3F 等防止传输过程中出问题，然后在进行base64编码
     *
     * @param str
     * @return
     */
    public static String encodeUTF8StringBase64(String str) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(str, "utf-8");
            encoded = Base64.getEncoder().encodeToString(encoded.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.warn("不支持的编码格式", e);
        }
        return encoded;

    }

    /**
     * 将字符串str 先进行base64解码 然后在使用utf-8字符集进行url解码
     *
     * @param str
     * @return
     */
    public static String decodeUTF8StringBase64(String str) {
        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(str);

        try {
            decoded = new String(bytes, "utf-8");
            decoded = URLDecoder.decode(decoded, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn("不支持的编码格式", e);
        }
        return decoded;
    }


    public static void main(String[] args) {
        System.out.println(EncryptUtil.encodeUTF8StringBase64("{\"message\":\"success\"}"));
    }


}
