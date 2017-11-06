package com.wdlily.sell.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * @author wangDi
 * @description
 * @date 2017/10/29 13:31
 */
public class KeyUtil {

    /**
     * 时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer num = random.nextInt(9000) + 1000;
        return System.currentTimeMillis() + String.valueOf(num);
    }

}
