package com.wangxm.flowanalysis.dataparser.packet;

import com.wangxm.flowanalysis.util.ByteUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePacket {

    private String scrIp;
    private int scrPort;
    private String dstIp;
    private int dstPort;

    public String getScrIp() {
        return scrIp;
    }

    public void setScrIp(byte[] scrIp) {
        List<String> scrIpItem = new ArrayList<>();
        for (byte ipItem: scrIp) {
            scrIpItem.add(String.valueOf(ByteUtil.byte2Int(new byte[] {ipItem})));
        }
        this.scrIp = String.join(".", scrIpItem);
    }

    public int getScrPort() {
        return scrPort;
    }

    public void setScrPort(int scrPort) {
        this.scrPort = scrPort;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(byte[] dstIp) {
        List<String> scrIpItem = new ArrayList<>();
        for (byte ipItem: dstIp) {
            scrIpItem.add(String.valueOf(ByteUtil.byte2Int(new byte[] {ipItem})));
        }
        this.dstIp = String.join(".", scrIpItem);
    }

    public int getDstPort() {
        return dstPort;
    }

    public void setDstPort(int dstPort) {
        this.dstPort = dstPort;
    }

    @Override
    public String toString() {
        return "BasePacket{" +
                "scrIp='" + scrIp + '\'' +
                ", scrPort=" + scrPort +
                ", dstIp='" + dstIp + '\'' +
                ", dstPort=" + dstPort +
                '}';
    }
}
