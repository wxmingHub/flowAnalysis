package com.wangxm.flowanalysis.dataparser.mysql;

import com.wangxm.flowanalysis.util.ByteUtil;

public abstract class BasePacket {

    private String srcIp;
    private int srcPort;
    private String dstIp;
    private int dstPort;

    public BasePacket(String srcIp, int srcPort, String dstIp, int dstPort) {
        this.srcIp = srcIp;
        this.srcPort = srcPort;
        this.dstIp = dstIp;
        this.dstPort = dstPort;
    }

    public BasePacket(byte[] srcIp, int srcPort, byte[] dstIp, int dstPort) {
        this.srcIp = ByteUtil.byte2Ip(srcIp);
        this.srcPort = srcPort;
        this.dstIp = ByteUtil.byte2Ip(dstIp);
        this.dstPort = dstPort;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(int srcPort) {
        this.srcPort = srcPort;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
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
                "srcIp='" + srcIp + '\'' +
                ", srcPort=" + srcPort +
                ", dstIp='" + dstIp + '\'' +
                ", dstPort=" + dstPort +
                '}';
    }
}
