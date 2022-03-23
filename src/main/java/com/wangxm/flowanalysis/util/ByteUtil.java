package com.wangxm.flowanalysis.util;

import java.io.UnsupportedEncodingException;

/**
 * 字节转向其他数据类型
 *
 * 相关运算符运算
 *  | 按位或  只要有一个为1则为1 否则为0
 *  & 按位与 都为1则为1 否则为0
 *  ^ 按位异或 相同为0 不同则为1
 *  <<  表示左移，不分正负数，低位补0
 *  >>  表示右移，如果该数为正，则高位补0，若为负数，则高位补1
 *  >>> 表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
 */
public class ByteUtil {

    /**
     * 将 bute[] 转换成 Int
     *
     * @param datas
     * @return
     */
    public static int byte2Int(byte[] datas) {
        int l = 0;
        for (int i = 0; i < datas.length; i++) {
            l |= ((datas[i] & 0xff) << (i << 3));
        }
        return l;
    }

    /**
     * 将 bute[] 转换成 Long
     *
     * @param datas
     * @return
     */
    public static long byte2Long(byte[] datas) {
        long l = 0;
        for (int i = 0; i < datas.length; i++) {
            l |= (datas[i] & 0xff) << (i << 3);
        }
        return l;
    }

    /**
     * 将 bute[] 转换成 String
     *
     * @param datas
     * @return
     */
    public static String byte2String(byte[] datas) {
        if (datas == null || datas.length <= 0) {
            return "";
        }
        try {
            return new String(datas, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
