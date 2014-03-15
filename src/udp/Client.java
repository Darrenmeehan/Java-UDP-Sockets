package udp;


import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author darren
 */
public class Client {

    public static void main(String args[]) throws Exception {
        
        
        int portNum = 11112;
        DatagramSocket clientSocket = new DatagramSocket();
        
        InetAddress IPAddress = InetAddress.getByName("localhost");
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        // Creating Integer Object.
        Integer number = new Integer(50);
        
        // Creating byte array, using ByteBuffer. Array is 4 bytes in size.
        // Also adding Integer Object to array.
        // A lot happening here, change later.... YOLO though? ...
        byte[] bytes = ByteBuffer.allocate(4).putInt(number).array();
        
        sendData = bytes;
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ByteArrayInputStream bis = new ByteArrayInputStream(receiveData);
        
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, portNum);
        
        // Sending data to server.
        clientSocket.send(sendPacket);
        
        
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();

    }

}
