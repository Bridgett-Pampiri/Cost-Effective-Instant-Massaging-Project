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

/*
 * import javax.net.ssl.*;
import javax.net.*;
import java.io.*;
import java.net.*;

public class LogServer {
  private static final int PORT_NUM = 5000;
  public static void main(String args[]) {
    ServerSocketFactory serverSocketFactory =
      ServerSocketFactory.getDefault();
    ServerSocket serverSocket = null;
    try {
      serverSocket =
        serverSocketFactory.createServerSocket(PORT_NUM);
    } catch (IOException ignored) {
      System.err.println("Unable to create server");
      System.exit(-1);
    }
    System.out.printf("LogServer running on port: %s%n", PORT_NUM);
    while (true) {
      Socket socket = null;
      try {
        socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(
          new InputStreamReader(is, "US-ASCII"));
        String line = null;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException exception) {
        // Just handle next request.
      } finally {
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException ignored) {
          }
        }
      }
    }
  }
}


public class ThreadedEchoServer {

    static final int PORT = 1978;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new EchoThread(socket).start();
        }
    }
}


public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                } else {
                    out.writeBytes(line + "\n\r");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
 */
