package edu.upc.eetac.dsa.FelipeBoix.ClassesEssencials3;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPsinConcurrenciaServidor {
	public static void main(String args[]) throws Exception 
    { 
     try
     { 
      DatagramSocket serverSocket = new DatagramSocket(9876); 
  
      byte[] receiveData = new byte[1024]; 
      byte[] sendData  = new byte[1024]; 
  
      while(true) 
        { 
    	  
    	  //Fecha
    	  Date fecha = new Date();
  		  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY  HH: mm: ss");
          String fechastring = formato.format(fecha);
          
          //recibir datos
          receiveData = new byte[1024];
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
        
          
          serverSocket.receive(receivePacket); 
          
          
          String sentence = new String(receivePacket.getData());   
          InetAddress IPAddress = receivePacket.getAddress(); 
  
          int port = receivePacket.getPort(); 
  
          System.out.println ("From: " + IPAddress + ":" + port);
          System.out.println ("Message: " + sentence);

         
         

          sendData = fechastring.getBytes();         
          
          DatagramPacket sendPacket =  new DatagramPacket(sendData, sendData.length, IPAddress, port); 
  
          serverSocket.send(sendPacket); 

         
        }

     }
      catch (SocketException ex) {
        System.out.println("UDP Port 9876 is occupied.");
        System.exit(1);
      }

    } 
}