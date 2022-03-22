package com.wangxm.flowanalysis.dataparser;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

import java.io.IOException;

/**
 * 作者: wangxm
 * 日期: 2022/3/22
 * 版本: v2.2.0
 * 备注:
 */
public class FlowCatcher {
    public static void main(String[] args) throws IOException {
        NetworkInterface[] networkInterfaces = JpcapCaptor.getDeviceList();
        JpcapCaptor jCaptor = JpcapCaptor.openDevice(networkInterfaces[0], 65535, true, 3*1000);
        jCaptor.setFilter("host 172.16.0.215", true);
        jCaptor.loopPacket(-1, new DataReceiver());
    }
}
