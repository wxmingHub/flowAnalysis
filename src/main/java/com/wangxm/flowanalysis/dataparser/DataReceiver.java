package com.wangxm.flowanalysis.dataparser;

import com.wangxm.flowanalysis.dataparser.mysql.MysqlPacket;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;

public class DataReceiver implements PacketReceiver {

    @Override
    public void receivePacket(Packet packet) {
        if (packet instanceof TCPPacket) {
            TCPPacket tcpPacket = (TCPPacket) packet;
            System.out.println("\n--------------------------------------------------");
            System.out.println("Tcp 协议...");
            MysqlPacket mysqlPacket = new MysqlPacket(tcpPacket);
            System.out.println(mysqlPacket);
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("其他协议...");
        }
    }
}
