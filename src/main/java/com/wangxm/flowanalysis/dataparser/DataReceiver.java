package com.wangxm.flowanalysis.dataparser;

import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;

/**
 * 作者: wangxm
 * 日期: 2022/3/22
 * 版本: v2.2.0
 * 备注:
 */
public class DataReceiver implements PacketReceiver {

    @Override
    public void receivePacket(Packet packet) {
        if (packet instanceof TCPPacket) {
            System.out.println("TCP 协议...");
        } else {
            System.out.println("其他协议...");
        }
    }
}
