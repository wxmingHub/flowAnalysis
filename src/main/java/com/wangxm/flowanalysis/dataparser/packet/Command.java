package com.wangxm.flowanalysis.dataparser.packet;

/**
 * 作者: wangxm
 * 日期: 2022/3/24
 * 版本: v2.2.0
 * 备注:
 */
public class Command {
    public static final int COM_SLEEP = 0;
    public static final int COM_QUIT = 1;
    public static final int COM_INIT_DB = 2;
    public static final int COM_QUERY = 3;
    public static final int COM_FIELD_LIST = 4;
    public static final int COM_CREATE_DB = 5;
    public static final int COM_DROP_DB = 6;
    public static final int COM_REFRESH = 7;
    public static final int COM_SHUTDOWN = 8;
    public static final int COM_STATISTICS = 9;
    public static final int COM_PROCESS_INFO = 10;
    public static final int COM_CONNECT = 11;
    public static final int COM_PROCESS_KILL = 12;
    public static final int COM_DEBUG = 13;
    public static final int COM_PING = 14;
    public static final int COM_TIME = 15;
    public static final int COM_DELAYED_INSERT = 16;
    public static final int COM_CHANGE_USER = 17;
    public static final int COM_RESET_CONNECTION = 31;
    public static final int COM_DAEMON = 29;
}
