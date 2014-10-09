package edu.upc.eetac.dsa.FelipeBoix.ClassesEssencials3;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TCPsinConcurrenciaServidor {
	public static void main(String[] args) throws IOException 
	   { 
	    ServerSocket serverSocket = null; 

	    try { 
	         serverSocket = new ServerSocket(10007); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Could not listen on port: 10007."); 
	         System.exit(1); 
	        } 

	    Socket clientSocket = null; 
	    System.out.println ("Waiting for connection.....");

	    try { 
	         clientSocket = serverSocket.accept(); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Accept failed."); 
	         System.exit(1); 
	        } 

	    System.out.println ("Connection successful");
	    System.out.println ("Waiting for input.....");
	    
	    Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY  HH: mm: ss");
     String fechastring = formato.format(fecha);
     
	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
	   
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 

	    String inputLine; 

	    while ((inputLine = in.readLine()) != null) 
	        { 
	    	 out.write("Fecha: " + fechastring);
	         System.out.println ("Server: " + inputLine); 
	         out.println(inputLine); 

	         if (inputLine.equals("Bye.")) 
	             break; 
	        } 

	    out.close(); 
	    in.close(); 
	    clientSocket.close(); 
	    serverSocket.close(); 
	   } 
}