
//import java.awt.Color
//import java.awt.Container;

import java.awt.*;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//have a class for gui things that extends JFrame
//have a class for the first gui that will extends Account
public class RheanaFirstGui extends JFrame{
	//see why loging isnt working
	//declare variables
     boolean found;
	JLabel lblImage;
	String username,password,user1,pswrd1;
	private static Scanner x;
	JFrame firstFrame;
	public static final String FILENAME = "C:\\Users\\Rhea\\filename.txt";
	JPanel panFirst,  panLog;
	JLabel lblTitle,lblUser,lblPswrd,lblUserLogin,lblPswrdLogin;
	JButton btnSign, btnLog,btnAcc, btnCheck, btnCreate, btnAccount;
	JTextField txtUser,txtPswrd, txtUserLogin,txtPswrdLogin;
	JLayeredPane firstPane = getLayeredPane();
	JLayeredPane panSign = getLayeredPane();
//	JLayeredPane panLog = getLayeredPane();
	Color mybrwn = new Color(234,207,169);
	Color mygrey = new Color(94,74,63);
	Color myyellow = new Color(255,254,138);
	
	public RheanaFirstGui() {
		firstFrame = new JFrame();
		firstFrame.setSize(450,650);
	    firstFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		firstPane.setPreferredSize(new Dimension(550, 400));
		firstFrame.setResizable(false);
		firstFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - firstFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - firstFrame.getHeight()/2);
		this.found= false;
		//Color myBrown = new Color(201,176,136);
	}	
	
	public void createGui(){	
		//initiaize buttons
	     btnSign = new JButton("Sign Up");
		 btnSign.setBounds(130,175, 170, 60);
		 btnSign.setForeground(Color.WHITE);
		 btnSign.setBackground(mybrwn);
		 btnLog = new JButton("Log In");
		 btnLog.setBounds(130,275,170, 60);
		 //btnLog.setBorder(new RoundedBorder(10)); //10 is the radius
		 btnLog.setForeground(Color.WHITE);
		 btnLog.setBackground(mybrwn);
		 lblImage = new JLabel();
		ImageIcon img2g1 = new ImageIcon("C:\\Users\\Rhea\\summative\\firstgui.png");
		Image image = img2g1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(450,650, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon img2g = new ImageIcon(newimg);
		lblImage.setIcon(img2g);
		lblImage.setBounds(0,0,450,650);
		panFirst = new JPanel();
		panFirst.setLayout(null);
		panFirst.setSize(300,500);
		lblTitle = new JLabel("Welcome to *insert procrastination app name here*");
		lblTitle.setSize(75,200);
	//	btnSign = new JButton("Sign in");
		//btnSign.setSize(100,150);
		//btnSign.setOpaque(false);
		//btnLog = new JButton("Log in");
		//btnLog.setSize(100,150);
		//btnLog.setOpaque(false);
		//btnLog.setOpaque(false);
		//btnLog.setContentAreaFilled(false);
		btnLog.setBorderPainted(false);
		//btnSign.setOpaque(false);
		//btnSign.setContentAreaFilled(false);
		btnSign.setBorderPainted(false);
		lblImage.setLocation(0, 0);
		panFirst.setOpaque(false);
		//panFirst.add(lblTitle, BorderLayout.PAGE_START);
		//panFirst.add(btnSign, BorderLayout.LINE_START);
		panFirst.add(btnLog);
		panFirst.add(btnSign);
		panFirst.setVisible(true);
		firstPane.add(panFirst,new Integer(2));
		firstPane.add(lblImage,new Integer(1));
		firstPane.setVisible(true);
		firstFrame.add(firstPane);
		firstFrame.setVisible(true);
		thehandler handler = new thehandler();
		btnSign.addActionListener(handler);
		btnLog.addActionListener(handler);
}
	public class thehandler  implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
		   if(btnSign == (JButton) e.getSource()){
			   
			   
			 firstPane.setVisible(false);
			 panFirst.setVisible(false);
			 panSign.setSize(450,600);
			 panSign.setLayout(null);
			 lblUser = new JLabel("Enter a username");
			 lblUser.setBounds(130,100,200,50);
			 lblUser.setFont(new Font("Impact", Font.PLAIN, 26));
			 lblUser.setForeground(Color.white);
			 txtUser = new JTextField();	
			 txtUser.setBounds(70,150,300,50);
			 txtUser.setFont(new Font("Serif", Font.PLAIN, 26));
			 lblPswrd = new JLabel("Enter a password");
			 lblPswrd.setBounds(130,220,200,50);
			 lblPswrd.setFont(new Font("Impact", Font.PLAIN, 26));
		     lblPswrd.setForeground(Color.white);				
			 txtPswrd = new JTextField();
			 txtPswrd.setFont(new Font("Serif", Font.PLAIN, 26));
			 txtPswrd.setBounds(70,270,300,50);
			 btnAcc = new JButton("Create your account");
			 btnAcc.setBounds(120,350,200,50);
			 btnAcc.setForeground(Color.WHITE);
			 btnAcc.setBackground(mybrwn);
			 
			 
			 panSign.add(lblUser, new Integer(2));
			 panSign.add(txtUser, new Integer(2));
			 panSign.add(lblPswrd,new Integer(2));
			 panSign.add(txtPswrd, new Integer(2));
			 panSign.add(btnAcc, new Integer(2));
			 panSign.setVisible(true);
			 firstFrame.add(panSign);
			 
			 RheanaAccount account = new RheanaAccount();
			 btnAcc.addActionListener(account);
			 btnAcc.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				//	Account account = new Account();
					firstFrame.dispose();
					save();
				}
				 
			 });	 
		   }
			//	username = txtUser.getText();
		
			if(btnLog ==(JButton) e.getSource()){
					JLabel lblLog = new JLabel("Log In");
					lblLog.setFont(new Font("Impact", Font.PLAIN, 36));
					lblLog.setForeground(Color.white);
					lblLog.setBounds(175,0,300,100);
				    btnSign.setVisible(false);
				    panFirst.setVisible(false);
				    panLog = new JPanel();
				    panLog.setBounds(0, 0, 450, 650);
				    panLog.setLayout(null);
				    lblUserLogin = new JLabel("Enter your username: ");
				    lblUserLogin.setBounds(165,100,300,50);
					txtUserLogin = new JTextField();
					txtUserLogin.setBounds(80,140,300,50);
					lblPswrdLogin = new JLabel("Enter your password: ");
					lblPswrdLogin.setBounds(165,240,300,50);
					txtPswrdLogin = new JTextField();
					txtPswrdLogin.setBounds(80,280,300,50);
					btnCheck = new JButton("Log In");
					btnCheck.setBounds(160,380,115,50);
					panLog.add(lblLog);
					panLog.add(lblUserLogin);
					panLog.add(txtUserLogin);
					panLog.add(lblPswrdLogin);
					panLog.add(txtPswrdLogin);
					panLog.add(btnCheck);
			     	panLog.setOpaque(false);
					//firstFrame.setVisible(false);
				    panLog.setVisible(true);
				    firstPane.add(panLog, new Integer(2));
				
					
				    
				    btnCheck.addActionListener(new ActionListener(){
				    	@Override
						public void actionPerformed(ActionEvent e) {
							username = txtUserLogin.getText();
							password = txtPswrdLogin.getText();
				    		VerifyLogin(user1,pswrd1,FILENAME);
				    		if(found==true){
				    			RheanaAccount account = new RheanaAccount();
				    		}
				    		else{
				    		JOptionPane.showMessageDialog(null,"Sorry, the username/password is incorrect");
				    		
				    		}
						}
				    });}
			}
		  
		 public void save(){
				BufferedWriter bw = null;
				FileWriter fw = null;

				try {

			 username = txtUser.getText()+ ",";
		            password = txtPswrd.getText();
					fw = new FileWriter(FILENAME);
					bw = new BufferedWriter(fw);
					bw.write(username);
					bw.write(password);
					System.out.println("Done");

				} catch (IOException e) {

					e.printStackTrace();

				} finally {

					try {

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}

				}

			}
			
		  public boolean VerifyLogin(String username, String password, String filepath){
			  found = false;
				String tempUsername = "";
				String tempPassword = "";
				
				try{
					x = new Scanner(new File(filepath));
					x.useDelimiter("[,\n]");
					
					while(x.hasNext()&& !found)
					{
						tempUsername = x.next();
						tempPassword = x.next();
						
						if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
								{
							found = true;
							
								}
					}
					x.close();
					System.out.println(found);
					username = tempUsername;
					password = tempPassword;
					
				}
				
		catch(Exception e){
				System.out.println("error");
			}
				return found;
		}
		  
	}
}


