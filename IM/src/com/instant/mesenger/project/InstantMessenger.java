package com.instant.mesenger.project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class InstantMessenger extends JFrame {
	
	private JLabel aboutMeLabel;
	private JPanel aboutMePanel;
	private JLabel myProfilePic;
	private JPanel menuPane;
	private JLabel chatIcon;
	private JLabel settingsIcon;
	private JTextField chatsPane;
	private JTextField friendStatusBar;
	private JTextField chatPane;
	private JPanel messageBar;
	private JTextArea messageInputBox;
	private JTextField friendAbout;
	private JButton send;

	public static void main(String[] args) {
		// create frame
		new InstantMessenger().show();

	}
	
	// CONSTRUCTOR
	public InstantMessenger() {
		// frame constructor
		setTitle("Instant Messenger");
		getContentPane().setBackground(new Color(30, 30, 30));
		//setSize(1500, 750);
		//setResizable(false);
		//setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints;
		

		//CREATE ABOUTMEPANEL
		aboutMePanel = new JPanel();
		aboutMePanel.setLayout(new GridBagLayout());
		aboutMePanel.setPreferredSize(new Dimension(1500, 40));
		aboutMePanel.setBackground(new Color(13, 13, 13));
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 4;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(aboutMePanel, gridConstraints);

		aboutMeLabel = new JLabel("ME");
		aboutMeLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		aboutMeLabel.setPreferredSize(new Dimension(1350, 40));
		aboutMeLabel.setBackground(new Color(13, 13, 13));
		aboutMeLabel.setForeground(Color.WHITE);
		aboutMeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		aboutMePanel.add(aboutMeLabel, gridConstraints);
		aboutMeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		// Profile image
		Image img = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
				
		myProfilePic = new JLabel("");
		myProfilePic.setIcon(new ImageIcon(img));
		myProfilePic.setBorder(new EmptyBorder(0, 0, 0, 10));
		myProfilePic.setPreferredSize(new Dimension(1500, 40));
		myProfilePic.setBackground(new Color(13, 13, 13));
		myProfilePic.setForeground(Color.WHITE);
		myProfilePic.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		aboutMePanel.add(myProfilePic, gridConstraints);
		
		
		// CREATE MENUPANE
		menuPane = new JPanel();
		menuPane.setLayout(new GridBagLayout());
		menuPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		menuPane.setPreferredSize(new Dimension(60, 750));
		menuPane.setBackground(new Color(30, 30, 30));
		menuPane.setForeground(Color.WHITE);	
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.gridheight = 3;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(menuPane, gridConstraints);
		menuPane.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// create chat Icon
		chatIcon = new JLabel("");
		chatIcon.setIcon(new ImageIcon(img));
		chatIcon.setBorder(new EmptyBorder(10, 0, 0, 0));
		chatIcon.setPreferredSize(new Dimension(60, 750));
		chatIcon.setBackground(new Color(13, 13, 13));
		chatIcon.setForeground(Color.WHITE);
		chatIcon.setVerticalAlignment(SwingConstants.TOP);
		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		//gridConstraints.weighty = 1;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		menuPane.add(chatIcon, gridConstraints);
		
		// create chat Icon
		settingsIcon = new JLabel("");
		settingsIcon.setIcon(new ImageIcon(img));
		settingsIcon.setBorder(new EmptyBorder(10, 0, 0, 0));
		settingsIcon.setPreferredSize(new Dimension(60, 750));
		settingsIcon.setBackground(new Color(13, 13, 13));
		settingsIcon.setForeground(Color.WHITE);
		settingsIcon.setVerticalAlignment(SwingConstants.TOP);
		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.weighty = 1;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		menuPane.add(settingsIcon, gridConstraints);
				
		// CREATE CHATSPANE
		chatsPane = new JTextField("");
		chatsPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		chatsPane.setPreferredSize(new Dimension(270, 750));
		chatsPane.setEditable(false);
		chatsPane.setBackground(new Color(43, 43, 43));
		chatsPane.setForeground(Color.WHITE);
		chatsPane.setHorizontalAlignment(SwingConstants.CENTER);		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridheight = 3;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(chatsPane, gridConstraints);
		chatsPane.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// CREATE FRIENDSTATUSBAR
		friendStatusBar = new JTextField("Tsala");
		friendStatusBar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		friendStatusBar.setPreferredSize(new Dimension(900, 60));
		friendStatusBar.setEditable(false);
		friendStatusBar.setBackground(new Color(13, 13, 13));
		friendStatusBar.setForeground(Color.WHITE);
		friendStatusBar.setHorizontalAlignment(SwingConstants.CENTER);		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(friendStatusBar, gridConstraints);
		friendStatusBar.setFont(new Font("Arial", Font.BOLD, 20));
		
		// CREATE CHATPANE
		chatPane = new JTextField("");
		chatPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		chatPane.setPreferredSize(new Dimension(900, 630));
		chatPane.setEditable(false);
		chatPane.setBackground(new Color(43, 43, 43));
		chatPane.setForeground(Color.WHITE);
		chatPane.setHorizontalAlignment(SwingConstants.CENTER);		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 2;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(chatPane, gridConstraints);
		chatPane.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// CREATE MESSAGEBAR
		messageBar = new JPanel();
		messageBar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		messageBar.setPreferredSize(new Dimension(900, 60));
		messageBar.setBackground(new Color(33, 33, 33));
		messageBar.setForeground(Color.WHITE);
		messageBar.setBorder(BorderFactory.createEmptyBorder(1, 5, 5, 5));
		
		// create message input box
		messageInputBox = new JTextArea();
		messageInputBox.setPreferredSize(new Dimension(750, 50));
		//messageInputBox.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		messageInputBox.setEditable(true);
		messageInputBox.setBackground(new Color(13, 13, 13));
		messageInputBox.setForeground(Color.WHITE);
		messageInputBox.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		messageBar.add(messageInputBox);
		messageInputBox.setFont(new Font("Arial", Font.PLAIN, 16));
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(messageBar, gridConstraints);
		
		// CREATE FRIENDABOUT
		friendAbout = new JTextField("");
		friendAbout.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		friendAbout.setPreferredSize(new Dimension(270, 750));
		friendAbout.setEditable(false);
		friendAbout.setBackground(new Color(43, 43, 43));
		friendAbout.setForeground(Color.WHITE);
		friendAbout.setHorizontalAlignment(SwingConstants.CENTER);		
		
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 1;
		gridConstraints.gridheight = 3;
		gridConstraints.insets = new Insets(0, 0, 0, 0);
		getContentPane().add(friendAbout, gridConstraints);
		friendAbout.setFont(new Font("Arial", Font.PLAIN, 20));
		
		pack();		
		// position at the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
	}
	
	private void exitForm(WindowEvent evt) {
		System.exit(0);
	}	

}
