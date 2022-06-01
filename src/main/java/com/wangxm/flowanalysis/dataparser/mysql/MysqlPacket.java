package com.wangxm.flowanalysis.dataparser.mysql;

import com.wangxm.flowanalysis.dataparser.mysql.command.BaseCommand;
import com.wangxm.flowanalysis.dataparser.mysql.command.Type;
import com.wangxm.flowanalysis.util.ByteUtil;
import jpcap.packet.TCPPacket;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MysqlPacket extends BasePacket {
    /**
     * length of compressed payload
     */
    private int compLen;
    /**
     * compressed sequence id
     */
    private int sequenceId;
    /**
     * type
     */
    private Type type;
    /**
     * payload
     */
    private byte[] payload;
    /**
     * command
     */
    private BaseCommand command;

    public MysqlPacket(TCPPacket packet) {
        super(packet.src_ip.getAddress(), packet.src_port, packet.dst_ip.getAddress(), packet.dst_port);

        if (packet.data != null && packet.data.length >= 3) {
            this.compLen = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 0, 3));
        }
        if (this.compLen != 0) {
            this.sequenceId = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 3, 4));
            this.type = Type.findCommandByCode(ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 4, 5)));
            this.payload = Arrays.copyOfRange(packet.data, 5, packet.data.length);
            Class clazz = this.type.getClazz();
            try {
                this.command = (BaseCommand) clazz.getDeclaredConstructor().newInstance();
                this.command.init(this.payload);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - MysqlPacket{" +
                "compLen=" + compLen +
                ", sequenceId=" + sequenceId +
                ", type=" + (type == null ? "" : type) +
                ", command=" + (command == null ? "" : command.value()) +
                '}';
    }
}
