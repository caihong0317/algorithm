package com.caihong.net;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        datagramSocket.receive(packet);

        System.out.println("收到");
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        System.out.println(msg);
        datagramSocket.close();
    }
}
