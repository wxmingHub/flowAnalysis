package com.wangxm.flowanalysis.dataparser.mysql.command;

/**
 * 作者: wangxm
 * 日期: 2022/3/24
 * 版本: v2.2.0
 * 备注:
 */
public enum Command {

    COM_SLEEP(0x00, ComSleep.class, "服务器内部命令"),
    COM_QUIT(0x01, ComQuit.class, "关闭连接"),
    COM_INIT_DB(0x02, ComInitDb.class, "切换数据库"),
    COM_QUERY(0x03, ComQuery.class, "SQL查询请求"),
    COM_FIELD_LIST(0x04, ComFieldList.class, "获取数据表字段信息"),
    COM_CREATE_DB(0x05, ComCreateDb.class, "创建数据库"),
    COM_DROP_DB(0x06, ComDropDb.class, "删除数据库"),
    COM_REFRESH(0x07, ComRefresh.class, "清除缓存"),
    COM_SHUTDOWN(0x08, ComShutdown.class, "停止服务器"),
    COM_STATISTICS(0x09, ComStatistics.class, "获取服务器统计信息"),
    COM_PROCESS_INFO(0x0a, ComProcessInfo.class, "获取当前连接的列表"),
    COM_CONNECT(0x0b, ComConnect.class, "服务器内部命令"),
    COM_PROCESS_KILL(0x0c, ComProcessKill.class, "中断某个连接"),
    COM_DEBUG(0x0d, ComDebug.class, "保存服务器调试信息"),
    COM_PING(0x0e, ComPing.class, "测试连通性"),
    COM_TIME(0x0f, ComTime.class, "服务器内部命令"),
    COM_DELAYED_INSERT(0x10, ComDelayedInsert.class, "服务器内部命令"),
    COM_CHANGE_USER(0x11, ComChangeUser.class, "重新登陆"),
    COM_BINLOG_DUMP(0x12, ComBinlogDump.class, "获取二进制日志信息"),
    COM_TABLE_DUMP(0x13, ComTableDump.class, "获取数据表结构信息"),
    COM_CONNECT_OUT(0x14, ComConnectOut.class, "服务器内部命令"),
    COM_REGISTER_SLAVE(0x15, ComRegisterSlave.class, "从服务器向主服务器进行注册"),
    COM_STMT_PREPARE(0x16, ComStmtPrepare.class, "预处理SQL语句"),
    COM_STMT_EXECUTE(0x17, ComStmtExecute.class, "执行预处理语句"),
    COM_STMT_SEND_LONG_DATA(0x18, ComStmtSendLongData.class, "发送BLOB类型的数据"),
    COM_STMT_CLOSE(0x19, ComStmtClose.class, "销毁预处理语句"),
    COM_STMT_RESET(0x1a, ComStmtReset.class, "清除预处理语句参数缓存"),
    COM_SET_OPTION(0x1b, ComSetOption.class, "设置语句选项"),
    COM_STMT_FETCH(0x1c, ComStmtFetch.class, "获取预处理语句的执行结果"),
    COM_DAEMON(0x1d, ComDaemon.class, "服务器内部命令"),
    COM_RESET_CONNECTION(0x1f, ComResetConnection.class, "重置连接"),
    ;
    private int code;
    private Class clazz;
    private String desc;
    
    Command(int code, Class clazz, String desc) {
        this.code = code;
        this.clazz = clazz;
        this.desc = desc;
    }

    public static Command findCommandByCode(int code) {
        for (Command command: values()) {
            if (code == command.code) {
                return command;
            }
        }
        return null;
    }
}
