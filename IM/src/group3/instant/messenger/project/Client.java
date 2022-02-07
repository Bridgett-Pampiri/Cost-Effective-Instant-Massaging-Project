package group3.instant.messenger.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private static JPanel contentPane;
	private JTextField inputField;
	private JTextField searchField;
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;
	private static JLabel friendName;
	
	static Box vertical = Box.createVerticalBox();
	
	static DataInputStream dataInput;
	static DataOutputStream dataOutput;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().show();
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		try {
			connectToServer();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("KonNect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel menuBar = new JPanel();
		menuBar.setBackground(new Color(23, 23, 23));
		menuBar.setBounds(0, 58, 80, 787);
		contentPane.add(menuBar);
		menuBar.setLayout(null);
				
		JLabel chatIcon = new JLabel(" ");
		// ADD MOUSE ACTION
		chatIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/chatIcon.png")).getImage();
		chatIcon.setIcon(new ImageIcon(img));
		chatIcon.setHorizontalAlignment(SwingConstants.CENTER);
		chatIcon.setForeground(Color.WHITE);
		chatIcon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chatIcon.setBounds(10, 10, 68, 60);
		menuBar.add(chatIcon);
		
		JLabel settingsIcon = new JLabel("");
		// ADD MOUSE EVENT
		settingsIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Under construction!!");
			}
		});
		Image image = new ImageIcon(this.getClass().getResource("/GearIcon.png")).getImage();
		settingsIcon.setIcon(new ImageIcon(image));
		settingsIcon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		settingsIcon.setForeground(Color.WHITE);
		settingsIcon.setBounds(10, 84, 68, 60);
		menuBar.add(settingsIcon);
		
		JPanel aboutMePanel = new JPanel();
		aboutMePanel.setBackground(Color.BLACK);
		aboutMePanel.setBounds(0, 0, 1280, 60);
		contentPane.add(aboutMePanel);
		aboutMePanel.setLayout(null);
		
		JLabel myProfileName = new JLabel(LogIn.getUsername());
		myProfileName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		myProfileName.setHorizontalAlignment(SwingConstants.CENTER);
		myProfileName.setFont(new Font("Tahoma", Font.BOLD, 14));
		myProfileName.setForeground(Color.WHITE);
		myProfileName.setBounds(1100, 10, 82, 40);
		aboutMePanel.add(myProfileName);
		
		JLabel userProfilePic = new JLabel("PIC");
		userProfilePic.setBorder(new EmptyBorder(10, 10, 10, 10));
		userProfilePic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Image userProfileIcon = new ImageIcon(this.getClass().getResource("/" + LogIn.getUsername() + ".png")).getImage();
		userProfilePic.setIcon(new ImageIcon(userProfileIcon));
		userProfilePic.setHorizontalAlignment(SwingConstants.CENTER);
		userProfilePic.setForeground(Color.MAGENTA);
		userProfilePic.setBounds(1200, 10, 45, 50);
		aboutMePanel.add(userProfilePic);
		
		JPanel chatsPanel = new JPanel();
		chatsPanel.setBackground(Color.DARK_GRAY);
		chatsPanel.setBounds(78, 161, 300, 684);
		contentPane.add(chatsPanel);
		
		JPanel chatPane = new JPanel();
		chatPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		chatPane.setBackground(Color.DARK_GRAY);
		chatPane.setBounds(0, 0, 600, 634);
		//contentPane.add(chatPane);
		
		JScrollPane scrollPane = new JScrollPane(chatPane);
		scrollPane.setBounds(380, 116, 600, 634);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		ScrollBarUI ui = new BasicScrollBarUI() {
			protected JButton createDecreaseButton(int orientation) {
				JButton button = super.createDecreaseButton(orientation);
				button.setBackground(Color.MAGENTA);
				button.setForeground(Color.WHITE);
				this.thumbColor = Color.MAGENTA;
				return button;
			}
			
			protected JButton createIncreaseButton(int orientation) {
				JButton button = super.createDecreaseButton(orientation);
				button.setBackground(Color.MAGENTA);
				button.setForeground(Color.WHITE);
				this.thumbColor = Color.MAGENTA;
				return button;
			}
		};
		
		scrollPane.getVerticalScrollBar().setUI(ui);
		contentPane.add(scrollPane);
		
		JPanel aboutFriend = new JPanel();
		aboutFriend.setBackground(Color.DARK_GRAY);
		aboutFriend.setBounds(980, 58, 300, 787);
		contentPane.add(aboutFriend);
		
		JPanel aboutMe = new JPanel();
		aboutMe.setBackground(new Color(23, 23, 23));
		aboutMe.setBounds(380, 58, 600, 60);
		contentPane.add(aboutMe);
		aboutMe.setLayout(null);
		
		JLabel friendProfilePic = new JLabel("Pic");
		friendProfilePic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Under Construction!!!");
			}
		});
		Image profileIcon = new ImageIcon(this.getClass().getResource("/profileIcon.png")).getImage();
		friendProfilePic.setIcon(new ImageIcon(profileIcon));
		friendProfilePic.setHorizontalAlignment(SwingConstants.CENTER);
		friendProfilePic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		friendProfilePic.setForeground(Color.WHITE);
		friendProfilePic.setBackground(Color.WHITE);
		friendProfilePic.setBounds(25, 10, 45, 40);
		aboutMe.add(friendProfilePic);
				
		friendName = new JLabel("friend");
		friendName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		friendName.setHorizontalAlignment(SwingConstants.CENTER);
		friendName.setForeground(Color.MAGENTA);
		friendName.setFont(new Font("Tahoma", Font.BOLD, 14));
		friendName.setBounds(80, 10, 67, 20);
		aboutMe.add(friendName);
		
		JLabel onlineStatus = new JLabel("Online");
		onlineStatus.setHorizontalAlignment(SwingConstants.CENTER);
		onlineStatus.setForeground(Color.WHITE);
		onlineStatus.setBounds(90, 33, 57, 20);
		aboutMe.add(onlineStatus);
		
		JPanel inputBar = new JPanel();
		inputBar.setBackground(new Color(23, 23, 23));
		inputBar.setBounds(380, 750, 600, 60);
		contentPane.add(inputBar);
		inputBar.setLayout(null);
		
		inputField = new JTextField();
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputField.setBorder(new EmptyBorder(10, 5, 5, 5));
		inputField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inputField.setBounds(54, 10, 480, 40);
		inputBar.add(inputField);
		inputField.setColumns(10);
		
		JLabel videoIcon = new JLabel("");
		videoIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Image vidIcon = new ImageIcon(this.getClass().getResource("/videoIcon.png")).getImage();
		videoIcon.setIcon(new ImageIcon(vidIcon));
		videoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		videoIcon.setFont(new Font("Tahoma", Font.BOLD, 20));
		videoIcon.setForeground(Color.MAGENTA);
		videoIcon.setBackground(Color.WHITE);
		videoIcon.setBounds(10, 10, 34, 40);
		inputBar.add(videoIcon);
		
		JLabel sendIcon = new JLabel("Send");
		sendIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String output = inputField.getText();
					sendTextToFile(output);
					
					JPanel p2 = formatLabel(output);
					
					chatPane.setLayout(new BorderLayout());
					
					JPanel right = new JPanel(new BorderLayout());
					right.add(p2, BorderLayout.LINE_END);
					vertical.add(right);
					vertical.add(Box.createVerticalStrut(15));
					
					chatPane.add(vertical, BorderLayout.PAGE_START);
										
					dataOutput.writeUTF(output);
					inputField.setText("");
				} catch (Exception ex) {
					System.out.println(ex);
				}				
				
			}
		});
		sendIcon.setForeground(Color.MAGENTA);
		sendIcon.setFont(new Font("Tahoma", Font.BOLD, 12));
		sendIcon.setBounds(550, 10, 34, 40);
		inputBar.add(sendIcon);
		
		JPanel searchBar = new JPanel();
		searchBar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		searchBar.setBackground(Color.DARK_GRAY);
		searchBar.setBounds(78, 58, 300, 101);
		contentPane.add(searchBar);
		searchBar.setLayout(null);
		
		LineBorder line = new LineBorder(Color.white, 1, true);		//line border
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Under Construction!!!");
			}
		});
		searchField.setBorder(line);
		searchField.setBackground(Color.DARK_GRAY);
		searchField.setForeground(Color.WHITE);
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchField.setBounds(67, 10, 200, 40);
		searchBar.add(searchField);
		searchField.setColumns(10);
		
		JLabel searchIcon = new JLabel("search");
		searchIcon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		searchIcon.setForeground(Color.WHITE);
		searchIcon.setBounds(10, 20, 47, 19);
		searchBar.add(searchIcon);
		
		JLabel recentChats = new JLabel("Recent Chats");
		recentChats.setHorizontalAlignment(SwingConstants.CENTER);
		recentChats.setFont(new Font("Tahoma", Font.BOLD, 16));
		recentChats.setForeground(Color.WHITE);
		recentChats.setBounds(10, 60, 124, 34);
		searchBar.add(recentChats);
		
		JLabel newChatIcon = new JLabel("+ New Chat");
		newChatIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Under Construction!!!");				
			}
		});
		newChatIcon.setHorizontalAlignment(SwingConstants.CENTER);
		newChatIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		newChatIcon.setForeground(Color.WHITE);
		newChatIcon.setBounds(150, 60, 181, 34);
		searchBar.add(newChatIcon);
		
		// position at the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
	}
	
	public void sendTextToFile(String message) throws FileNotFoundException {
		try (FileWriter f = new FileWriter("chat.txt");
				PrintWriter p = new PrintWriter(new BufferedWriter(f));) {
			p.println(friendName.getText() + ": " + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JPanel formatLabel(String out) {
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		
		JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l1.setBackground(Color.MAGENTA);
		l1.setOpaque(true);
		l1.setBorder(new EmptyBorder(15, 15, 15, 50));
		
		// get time the message was sent
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel l2 = new JLabel();
		l2.setText(sdf.format(cal.getTime()));
		
		p3.add(l1);
		p3.add(l2);
		return p3;
	}
	
	public void connectToServer() throws IOException, UnknownHostException {
		
		// getting localhost ip
		InetAddress ip = InetAddress.getByName("localhost");
		
		// establish the connection
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		
		// obtaining input and out streams
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		// sendMessage thread
		Thread sendMessage = new Thread(new Runnable()
		{
			@Override
			public void run() {
				while (true) {

					// read the message to deliver.
					String msg = inputField.getText();
					
					try {
						// write on the output stream
						dos.writeUTF(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// readMessage thread
		Thread readMessage = new Thread(new Runnable()
		{
			@Override
			public void run() {

				while (true) {
					try {
						// read the message sent to this client
						String msg = dis.readUTF();
						System.out.println(msg);
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});

		sendMessage.start();
		readMessage.start();
	}
}
