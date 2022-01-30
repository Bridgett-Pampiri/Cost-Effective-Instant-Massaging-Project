package com.instant.mesenger.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trial extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trial frame = new Trial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Trial() {
		setTitle("KonNect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1750, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuBar = new JPanel();
		menuBar.setBackground(new Color(23, 23, 23));
		menuBar.setBounds(0, 58, 78, 787);
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
		aboutMePanel.setBounds(0, 0, 1540, 60);
		contentPane.add(aboutMePanel);
		aboutMePanel.setLayout(null);
		
		JLabel myProfileName = new JLabel("Sammy");
		myProfileName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		myProfileName.setHorizontalAlignment(SwingConstants.CENTER);
		myProfileName.setFont(new Font("Tahoma", Font.BOLD, 14));
		myProfileName.setForeground(Color.WHITE);
		myProfileName.setBounds(1351, 10, 82, 40);
		aboutMePanel.add(myProfileName);
		
		JLabel userProfilePic = new JLabel("PIC");
		userProfilePic.setBorder(new EmptyBorder(10, 10, 10, 10));
		userProfilePic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Image userProfileIcon = new ImageIcon(this.getClass().getResource("/myProfilePic.JPG")).getImage();
		userProfilePic.setIcon(new ImageIcon(userProfileIcon));
		userProfilePic.setHorizontalAlignment(SwingConstants.CENTER);
		userProfilePic.setForeground(Color.MAGENTA);
		userProfilePic.setBounds(1458, 10, 45, 50);
		aboutMePanel.add(userProfilePic);
		
		JPanel chatsPanel = new JPanel();
		chatsPanel.setBackground(Color.DARK_GRAY);
		chatsPanel.setBounds(78, 161, 362, 684);
		contentPane.add(chatsPanel);
		
		JPanel chatPane = new JPanel();
		chatPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		chatPane.setBackground(Color.DARK_GRAY);
		chatPane.setBounds(438, 116, 778, 669);
		contentPane.add(chatPane);
		
		JPanel aboutFriend = new JPanel();
		aboutFriend.setBackground(Color.DARK_GRAY);
		aboutFriend.setBounds(1216, 58, 324, 787);
		contentPane.add(aboutFriend);
		
		JPanel aboutMe = new JPanel();
		aboutMe.setBackground(new Color(23, 23, 23));
		aboutMe.setBounds(438, 58, 778, 60);
		contentPane.add(aboutMe);
		aboutMe.setLayout(null);
		
		JLabel friendProfilePic = new JLabel("Pic");
		friendProfilePic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		JLabel friendName = new JLabel("friend");
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
		inputBar.setBounds(438, 785, 778, 60);
		contentPane.add(inputBar);
		inputBar.setLayout(null);
		
		inputField = new JTextField();
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputField.setBorder(new EmptyBorder(10, 5, 5, 5));
		inputField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inputField.setBounds(54, 10, 670, 40);
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
			}
		});
		sendIcon.setForeground(Color.MAGENTA);
		sendIcon.setFont(new Font("Tahoma", Font.BOLD, 12));
		sendIcon.setBounds(734, 10, 34, 40);
		inputBar.add(sendIcon);
		
		JPanel searchBar = new JPanel();
		searchBar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		searchBar.setBackground(Color.DARK_GRAY);
		searchBar.setBounds(78, 58, 362, 101);
		contentPane.add(searchBar);
		searchBar.setLayout(null);
		
		LineBorder line = new LineBorder(Color.white, 1, true);		//line border
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchField.setBorder(line);
		searchField.setBackground(Color.DARK_GRAY);
		searchField.setForeground(Color.WHITE);
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchField.setBounds(67, 10, 285, 40);
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
			}
		});
		newChatIcon.setHorizontalAlignment(SwingConstants.CENTER);
		newChatIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		newChatIcon.setForeground(Color.WHITE);
		newChatIcon.setBounds(171, 60, 181, 34);
		searchBar.add(newChatIcon);
		
		// position at the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
	}
}
