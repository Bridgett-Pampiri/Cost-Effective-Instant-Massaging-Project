package group3.instant.messenger.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	protected JTextField usernameField;
	protected JPasswordField passwordField;
	private static String username;
	final static String JDBC_DRIVER =  "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/Clients";
	
	final static String user = "root";
	final static String password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("KonNect LogIn");
		titleLabel.setForeground(Color.MAGENTA);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(152, 38, 483, 77);
		contentPane.add(titleLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setBorder(new EmptyBorder(10, 10, 10, 10));
		usernameField.setBounds(374, 170, 331, 48);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(165, 171, 153, 47);
		contentPane.add(idLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(165, 260, 153, 48);
		contentPane.add(passwordLabel);
		
		JButton signInButton = new JButton("Sign In");
		signInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//validate
				Validate();
			}
		});
		signInButton.setBackground(Color.DARK_GRAY);
		signInButton.setForeground(Color.MAGENTA);
		signInButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		signInButton.setBounds(374, 346, 122, 38);
		contentPane.add(signInButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.DARK_GRAY);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelButton.setForeground(Color.MAGENTA);
		cancelButton.setBounds(583, 346, 122, 38);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel = new JLabel("forgot Password?");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(374, 439, 331, 38);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Validate();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		passwordField.setBorder(new EmptyBorder(10, 10, 10, 10));
		passwordField.setBounds(374, 260, 331, 48);
		contentPane.add(passwordField);
		setUndecorated(true);
		
		// position at the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
	}
	
	public void Validate() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, user, password);
			String query = "Select * from ourclients where Username=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, usernameField.getText());
			pst.setString(2, passwordField.getText());
			ResultSet result = pst.executeQuery();
			
			if(result.next()) {
				JOptionPane.showMessageDialog(null, "You have signed in successfully");
				setUsername(usernameField.getText());
				new Client().show();
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Username and/or password do not match");
				usernameField.setText("");
				passwordField.setText("");
			}
			
			con.close();
			
		} catch(Exception ee) {
			JOptionPane.showMessageDialog(null, ee);
		}
	}
	
	public void setUsername(String username) {
		LogIn.username = username;
	}
	
	public static String getUsername() {
		return LogIn.username;
	}
	
}
