/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author aluno
 */
public class UDPTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {

        DatagramSocket s = new DatagramSocket();
        s.setBroadcast(true);
        for(int i=0;i<30;i++){
            byte[] sendData2 = new byte[1024];
            byte[] receiveData2 = new byte[1024];
            String sentence2 = "teste - Dispositivo "+i*100;

            sendData2 = sentence2.getBytes();          
            
            s.connect(InetAddress.getByName("255.255.255.255"), 6789);
            s.send(new DatagramPacket(sendData2, sendData2.length));
            
        }
        s.close();
    }
    
}
