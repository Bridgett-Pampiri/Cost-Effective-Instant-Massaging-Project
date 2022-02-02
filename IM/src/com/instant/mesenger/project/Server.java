package com.instant.mesenger.project;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//echo server
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String args[]){
	
		Socket socket = null;
		ServerSocket serversocket = null;
		System.out.println("Server is Listening for connections......");
		try{
		   serversocket = new ServerSocket(4545); // use private port
		
		}
		catch(IOException e){
			e.printStackTrace();
		
		}
		
		while(true){
		   try{
		       socket = serversocket.accept();
		       System.out.println("connection Established");
		       ServerThread serverThread = new ServerThread(socket);
		       serverThread.start();		// run the server
		
		   } catch(Exception e) {
			   e.printStackTrace();
			}
		}
	
	}
	
}
	
class ServerThread extends Thread{  
	
	String line=null;
	BufferedReader  inputStream = null;
	PrintWriter outputStream = null;
	Socket socket = null;
	
	public ServerThread(Socket s){
	   this.socket = s;
	}
	
	public void run() {
		try{
			// get input from the server
		   inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   outputStream = new PrintWriter(socket.getOutputStream());
		
		} catch(IOException e) {
		   System.out.println("Input Output error in server thread");
		}
		
		try {
		   line = inputStream.readLine();	// read text line
		   while(line.compareTo("QUIT")!=0){
		
		       outputStream.println(line);
		       outputStream.flush();
		       System.out.println("Response to Client  :  "+line);
		       line=inputStream.readLine();
		   }   
		} catch (IOException e) {
		
		   line=this.getName(); //reused String line for getting thread name
		   System.out.println("IO Error/ Client "+line+" terminated abruptly");
		}
		catch(NullPointerException e){
		   line=this.getName(); //reused String line for getting thread name
		   System.out.println("Client "+line+" Closed");
		}
		
		finally {    
			try {
			   System.out.println("Connection Closing..");
			   if (inputStream!=null){
			       inputStream.close(); 
			       System.out.println(" Socket Input Stream Closed");
			   }
		
			   if(outputStream!=null){
			       outputStream.close();
			       System.out.println("Socket Out Closed");
			   }
			   if (socket!=null){
			   socket.close();
			   System.out.println("Socket Closed");
			   }
			
			   }
			catch(IOException ie){
			   System.out.println("Socket Close Error");
			}
		}//end finally
	}
}	
