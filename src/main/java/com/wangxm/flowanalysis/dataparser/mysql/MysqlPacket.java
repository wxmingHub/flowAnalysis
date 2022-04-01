package com.wangxm.flowanalysis.dataparser.mysql;

import com.wangxm.flowanalysis.dataparser.mysql.command.Command;
import com.wangxm.flowanalysis.util.ByteUtil;
import jpcap.packet.TCPPacket;

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
     * length of payload before compression
     */
    private Command command;
    /**
     * payload
     */
    private byte[] payload;

    public MysqlPacket(TCPPacket packet) {
        super(packet.src_ip.getAddress(), packet.src_port, packet.dst_ip.getAddress(), packet.dst_port);

        this.compLen = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 0, 3));
        if (this.compLen != 0) {
            this.sequenceId = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 3, 4));
            this.command = Command.findCommandByCode(ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 4, 5)));
            this.payload = Arrays.copyOfRange(packet.data, 5, packet.data.length);
        }
    }
}
