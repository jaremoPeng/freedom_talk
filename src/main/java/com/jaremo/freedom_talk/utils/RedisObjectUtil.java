package com.jaremo.freedom_talk.utils;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * @描述: redis 实现对象的存储工具类
 * @Author: pyj
 * @DateTime: 2018/10/29 0029--下午 2:15
 */
public class RedisObjectUtil {

    private static Logger logger = Logger.getLogger(RedisObjectUtil.class);

    /**
     * 功能描述 把对象变为字节数组
     * @author pyj
     * @date 2018/10/29 0029
     * @param obj 目标对象
     * @return byte[]
     */
    public static byte[] toByteArr(Object obj){

        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);

            bytes = baos.toByteArray();
        } catch (IOException e) {
            logger.debug("对象转为字节数组失败"+e.getMessage());
            throw new RuntimeException("对象转为字节数组失败");
        }finally {
            try {
                if(baos!=null)
                    baos.close();
                if(oos!=null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    /**
     * 功能描述 将字节数组变成对象
     * @author pyj
     * @date 2018/10/29 0029
     * @param bytes
     * @return java.lang.Object
     */
    public static Object toObject(byte[] bytes){
        Object obj = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;

        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            obj = ois.readObject();
        } catch (IOException e) {
            logger.debug("反序列化失败"+e.getMessage());
            throw new RuntimeException("反序列化失败");
        } catch (ClassNotFoundException e) {
            logger.debug("反序列化的类找到"+e.getMessage());
            throw new RuntimeException("反序列化的类找到");
        }finally {
            try {
                if(bais != null)
                    bais.close();
                if(ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
