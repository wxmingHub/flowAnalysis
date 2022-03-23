package com.wangxm.flowanalysis.dataparser.packet;

import com.wangxm.flowanalysis.util.ByteUtil;
import jpcap.packet.TCPPacket;

import java.util.Arrays;

public class MysqlPacket extends BasePacket {

    private String data;
    private int length;
    private int number;

    public MysqlPacket(TCPPacket packet) {
        this.length = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 0, 3));
        if (this.length != 0) {
            this.number = ByteUtil.byte2Int(Arrays.copyOfRange(packet.data, 3, 4));
            this.data = ByteUtil.byte2String(Arrays.copyOfRange(packet.data, 4, packet.data.length));
        }

        setScrIp(packet.src_ip.getAddress());
        setScrPort(packet.src_port);

        setDstIp(packet.dst_ip.getAddress());
        setDstPort(packet.dst_port);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + " MysqlPacket{" +
                "data='" + data + '\'' +
                ", length=" + length +
                ", number=" + number +
                '}';
    }
}
