package com.jaremo.freedom_talk.utils;

import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * @描述: 加密字符串
 * @Author: pyj
 * @DateTime: 2018/10/26 0026--下午 6:55
 */
public class EncryptUtil {

    /**
     * 功能描述 利用sha256进行加密
     * @author pyj
     * @date 2018/10/26 0026
     * @param target 需要加密的字符串
     * @param saltVal 盐值
     * @return java.lang.String
     */
    public static String encryptStr(String target,String saltVal){
        Sha256Hash sha256Hash = new Sha256Hash(target,saltVal);
        String encryptPwd = sha256Hash.toHex();
        return encryptPwd;
    }
}
