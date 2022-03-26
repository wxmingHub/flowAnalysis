package com.wangxm.flowanalysis.dataparser.packet;

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
    private int command;
    /**
     * payload
     */
    private byte[] payload;

    public MysqlPacket(TCPPacket packet) {
        super(packet.src_ip.getAddress(), packet.src_port, packet.dst_ip.getAddress(), packet.dst_port);

        this.compLen = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 0, 3));
        if (this.compLen != 0) {
            this.sequenceId = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 3, 4));
            this.command = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 4, 5));
            this.payload = Arrays.copyOfRange(packet.data, 5, packet.data.length);
        }
    }

    public int getCompLen() {
        return compLen;
    }

    public void setCompLen(int compLen) {
        this.compLen = compLen;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }
}
