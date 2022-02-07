package group3.instant.messenger.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server extends JFrame {
	// server is listening on port 9090
	ServerSocket serverSocket;
	
	Socket socket;
	
	// Vector to store active clients
		static Vector<ClientHandler> activeClients = new Vector<>();
		
		// counter for clients
		static int i = 0;


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		new Server().show();
		
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setTitle("konNect Server");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.MAGENTA, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton startServer = new JButton("Start Server");
		startServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					serverSocket = new ServerSocket(9090);
					while (true)
					{
						JOptionPane.showMessageDialog(null, "Server listening for clients...");
						// Accept the incoming request
						socket = serverSocket.accept();
							
						// obtain input and output streams
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
							
						// Create a new handler object for handling this request.
						ClientHandler mtch = new ClientHandler(socket,"client " + i, dis, dos);
	
						// Create a new Thread with this object.
						Thread t = new Thread(mtch);
						
						JOptionPane.showMessageDialog(null, "Adding this client to active client list");
	
						// add this client to active clients list
						activeClients.add(mtch);
	
						// start the thread.
						t.start();
	
						// increment i for new client.
						// i is used for naming only, and can be replaced
						// by any naming scheme
						i++;
	
					}
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		startServer.setFont(new Font("Tahoma", Font.BOLD, 16));
		startServer.setBackground(Color.MAGENTA);
		startServer.setBounds(228, 68, 255, 58);
		contentPane.add(startServer);
		
		JButton stopServer = new JButton("Stop Server");
		stopServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					socket.close();
					serverSocket.close();
					JOptionPane.showMessageDialog(null, "Server shutdown");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		stopServer.setBackground(Color.BLACK);
		stopServer.setForeground(Color.WHITE);
		stopServer.setFont(new Font("Tahoma", Font.BOLD, 16));
		stopServer.setBounds(228, 189, 255, 58);
		contentPane.add(stopServer);
		
		// position at the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
	}
}

//ClientHandler class
class ClientHandler implements Runnable
{
	Scanner scn = new Scanner(System.in);
	private String name;
	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s;
	boolean isloggedin;
	
	// constructor
	public ClientHandler(Socket s, String name,
							DataInputStream dis, DataOutputStream dos) {
		this.dis = dis;
		this.dos = dos;
		this.name = name;
		this.s = s;
		this.isloggedin=true;
	}

	@Override
	public void run() {

		String received;
		while (true)
		{
			try
			{
				// receive the string
				received = dis.readUTF();
				
				System.out.println(received);
				
				if(received.equals("logout")){
					this.isloggedin=false;
					this.s.close();
					break;
				}
				
				// break the string into message and recipient part
				StringTokenizer st = new StringTokenizer(received, "#");
				String MsgToSend = st.nextToken();
				String recipient = st.nextToken();

				// search for the recipient in the connected devices list.
				// ar is the vector storing client of active users
				for (ClientHandler mc : Server.activeClients)
				{
					// if the recipient is found, write on its
					// output stream
					if (mc.name.equals(recipient) && mc.isloggedin==true)
					{
						mc.dos.writeUTF(this.name+" : "+MsgToSend);
						break;
					}
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
