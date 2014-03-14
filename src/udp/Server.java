package udp;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author darren
 */
public class Server {

    public static void main(String args[]) throws SocketException, IOException {
        
        int portNum = 11112;
        DatagramSocket serverSocket = new DatagramSocket(portNum);
        System.out.println("Server is now running at port: " + portNum);
        
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        while (true) {
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            
            // Converting from bytes to String.
            String numString = new String(receivePacket.getData()); 

            // Creating Integer using String value.
            Integer number = new Integer(numString);
            
            System.out.println("Integer Object Recieved: " + number);
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length);
            serverSocket.send(sendPacket);
            
            
        }
    }

}
