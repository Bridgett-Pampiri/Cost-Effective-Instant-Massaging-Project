package com.instant.mesenger.project;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IMServer {
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JPanel a1;
	static JFrame f1 = new JFrame();
	 private static Logger logger = Logger.getAnonymousLogger();
	
	static Box vertical = Box.createVerticalBox();
	
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream din;
	static DataOutputStream dout;
	
	public static void main(String args[]) {
		try {
			
			String msgInput = "";
			serverSocket = new ServerSocket(6501);
			
			while(true) {
				socket = serverSocket.accept();
				din = new DataInputStream(socket.getInputStream());
				dout = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					msgInput = din.readUTF();
					
					JPanel left = new JPanel(new BorderLayout());
					vertical.add(left);
					f1.validate();
				
				
				serverSocket.close();
				socket.close();
				}
			}
			
		} catch(Exception e) {
			
		}
	}

}
