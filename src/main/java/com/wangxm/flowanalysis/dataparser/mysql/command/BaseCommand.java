package com.wangxm.flowanalysis.dataparser.mysql.command;

/**
 * 作者: wangxm
 * 日期: 2022/3/26
 * 版本: v2.2.0
 * 备注:
 */
public interface BaseCommand {

    default void init(byte[] payload) {

    }

    default String value() {
        return "";
    }
}
