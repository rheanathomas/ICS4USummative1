
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
	Color mybrwn = new Color(234,207,169);
	Color mygrey = new Color(94,74,63);
	Color myyellow = new Color(255,254,138);
	
	public RheanaFirstGui() {
		//create JFrame
		firstFrame = new JFrame();
		//set size of jframe
		firstFrame.setSize(450,650);
		//allow the jframe to delete upon pressing the exit button
	    firstFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //set size of jlayeredpanel
		firstPane.setPreferredSize(new Dimension(550, 400));
		//make jframe non resizable
		firstFrame.setResizable(false);
		//set location of jframe
		firstFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - firstFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - firstFrame.getHeight()/2);
		//set variable to false
		this.found= false;
	}	
	
	public void createGui(){	
		//initiaize button
	     btnSign = new JButton("Sign Up");
	     //set size and location of button
		 btnSign.setBounds(130,175, 170, 60);
		 btnSign.setForeground(Color.WHITE);
		 btnSign.setBackground(mybrwn);
		//set size and location of button
		 btnLog = new JButton("Log In");
		//set size and location of button
		 btnLog.setBounds(130,275,170, 60);
		 //btnLog.setBorder(new RoundedBorder(10)); //10 is the radius
		 //set foreground colour to white
		 btnLog.setForeground(Color.WHITE);
		 //set background colour of jbutton
		 btnLog.setBackground(mybrwn);
		 
		 //initialize labels
		 lblImage = new JLabel();
		ImageIcon img2g1 = new ImageIcon("C:\\Users\\Rhea\\ICS4USummative1\\summative\\firstgui.png");
		// transform it 
		Image image = img2g1.getImage(); 
		// scale it the smooth way  
		Image newimg = image.getScaledInstance(450,650, java.awt.Image.SCALE_SMOOTH); 
		//initialize image icon
		ImageIcon img2g = new ImageIcon(newimg);
		//set icon of jlabel
		lblImage.setIcon(img2g);
		//set size and location of label
		lblImage.setBounds(0,0,450,650);
		//initialize panel
		panFirst = new JPanel();
		//set layout to null
		panFirst.setLayout(null);
		//set size of panel
		panFirst.setSize(300,500);
		//initialize jlabel
		lblTitle = new JLabel("Welcome to *insert procrastination app name here*");
		//set size of label
		lblTitle.setSize(75,200);
		
		//remove border of buttons
		btnLog.setBorderPainted(false);
		btnSign.setBorderPainted(false);
		
		//set location of label
		lblImage.setLocation(0, 0);
		//set panel to opaque
		panFirst.setOpaque(false);
		
		//add components to panel
		panFirst.add(btnLog);
		panFirst.add(btnSign);
		
		//set panel as visible
		panFirst.setVisible(true);
		
		//add components to frame
		firstPane.add(panFirst,new Integer(2));
		firstPane.add(lblImage,new Integer(1));
		
		//set visibility to true
		firstPane.setVisible(true);
		firstFrame.setVisible(true);
		
		//create new class
		thehandler handler = new thehandler();
		
		//create actionlisteners
		btnSign.addActionListener(handler);
		btnLog.addActionListener(handler);
}
	public class thehandler  implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			//if the sign button is clicked
		   if(btnSign == (JButton) e.getSource()){
			  //set panels to invisible
			 firstPane.setVisible(false);
			 panFirst.setVisible(false);
			 //set size of panel
			 panSign.setSize(450,600);
			 //set layout to null
			 panSign.setLayout(null);
			 //initialize label
			 lblUser = new JLabel("Enter a username");
			 //set size and location
			 lblUser.setBounds(130,100,200,50);
			 //customize font
			 lblUser.setFont(new Font("Impact", Font.PLAIN, 26));
			 //create text colour to white
			 lblUser.setForeground(Color.white);
			 //initialize textfield
			 txtUser = new JTextField();	
			 //set size and location
			 txtUser.setBounds(70,150,300,50);
			 //set font
			 txtUser.setFont(new Font("Serif", Font.PLAIN, 26));
			 //initialise label
			 lblPswrd = new JLabel("Enter a password");
			 //set size and location
			 lblPswrd.setBounds(130,220,200,50);
			 //customize font
			 lblPswrd.setFont(new Font("Impact", Font.PLAIN, 26));
			 //
		     lblPswrd.setForeground(Color.white);				
			 txtPswrd = new JTextField();
			 txtPswrd.setFont(new Font("Serif", Font.PLAIN, 26));
			 txtPswrd.setBounds(70,270,300,50);
			 btnAcc = new JButton("Create your account");
			//set size and location of button
			 btnAcc.setBounds(120,350,200,50);
			//create text colour to white
			 btnAcc.setForeground(Color.WHITE);
			 //set background colour to brown
			 btnAcc.setBackground(mybrwn);
			 
			 //add components to layered panel
			 panSign.add(lblUser, new Integer(2));
			 panSign.add(txtUser, new Integer(2));
			 panSign.add(lblPswrd,new Integer(2));
			 panSign.add(txtPswrd, new Integer(2));
			 panSign.add(btnAcc, new Integer(2));
			 //make panel visible
			 panSign.setVisible(true);
			 //add panel to frame
			 firstFrame.add(panSign);
			 //call new class
			 RheanaAccount account = new RheanaAccount();
			 //add actionlistener to button so that it will register when users press on the button
			 btnAcc.addActionListener(account);
			 btnAcc.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//get rid of frame
					firstFrame.dispose();
					//call save method
					save();
				}
				 
			 });	 
		   }
		
			if(btnLog ==(JButton) e.getSource()){
				   //create new label
					JLabel lblLog = new JLabel("Log In");
					//customize font
					lblLog.setFont(new Font("Impact", Font.PLAIN, 36));
					//set text colour
					lblLog.setForeground(Color.white);
					//set size and location 
					lblLog.setBounds(175,0,300,100);
					//make button invisible
				    btnSign.setVisible(false);
					//make panel invisible
				    panFirst.setVisible(false);
				    //create new panel
				    panLog = new JPanel();
				  //set size and location 
				    panLog.setBounds(0, 0, 450, 650);
				    //set layout to null
				    panLog.setLayout(null);
				    //create new label
				    lblUserLogin = new JLabel("Enter your username: ");
				    //set size and location
				    lblUserLogin.setBounds(165,100,300,50);
				    //create new textfield
					txtUserLogin = new JTextField();
					 //set size and location 
					txtUserLogin.setBounds(80,140,300,50);
					
					//initialize components
					lblPswrdLogin = new JLabel("Enter your password: ");
					lblPswrdLogin.setBounds(165,240,300,50);
					txtPswrdLogin = new JTextField();
					
					//set size and location
					txtPswrdLogin.setBounds(80,280,300,50);
					//initialize button
					btnCheck = new JButton("Log In");
					//set size and location
					btnCheck.setBounds(160,380,115,50);
					
					//add components to panel
					panLog.add(lblLog);
					panLog.add(lblUserLogin);
					panLog.add(txtUserLogin);
					panLog.add(lblPswrdLogin);
					panLog.add(txtPswrdLogin);
					panLog.add(btnCheck);
					
					//make panel transparent
			     	panLog.setOpaque(false);
			     	
					//make panel visible
				    panLog.setVisible(true);
				    
				    //add panel to  frame
				    firstPane.add(panLog, new Integer(2));
				
					
				    
				    btnCheck.addActionListener(new ActionListener(){
				    	@Override
						public void actionPerformed(ActionEvent e) {
				    		//set value of strings to the value of the trxtfields
							username = txtUserLogin.getText();
							password = txtPswrdLogin.getText();
							//call method
				    		VerifyLogin(user1,pswrd1,FILENAME);
				    		
				    		if(found==true){
				    			//call class if method returns true
				    			RheanaAccount account = new RheanaAccount();
				    		}
				    		else{
				    		//if method is not true, show messagebox
				    		JOptionPane.showMessageDialog(null,"Sorry, the username/password is incorrect");
				    		
				    		}
						}
				    });}
			}
		  
		 public void save(){
			 	//set value to null
				BufferedWriter bw = null;
				FileWriter fw = null;

				try {
					//set values of strings to value of textfields
			        username = txtUser.getText()+ ",";
		            password = txtPswrd.getText();
		            
		            //set values to the values of the variables
					fw = new FileWriter(FILENAME);
					bw = new BufferedWriter(fw);
					
					//write the value of the strings
					bw.write(username);
					bw.write(password);

				} catch (IOException e) {
					//catch exception
					e.printStackTrace();

				} finally {

					try {

						if (bw != null)
							//if value is null, close variable
							bw.close();

						if (fw != null)
							//if value is null, close variable
							fw.close();

					} catch (IOException ex) {
						//catch exception
						ex.printStackTrace();

					}

				}

			}
			
		  public boolean VerifyLogin(String username, String password, String filepath){
			    //set values of the strings as empty
				String tempUsername = "";
				String tempPassword = "";
				
				try{
					//direct scanner to the correct class
					x = new Scanner(new File(filepath));
					//ignore these symbols while scanning
					x.useDelimiter("[,\n]");
					
					while(x.hasNext()&& !found)
					{
						//variables are equal to the characters that the scanner scans
						tempUsername = x.next();
						tempPassword = x.next();
						
						if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
								{
							//set boolean to true
							found = true;
							
								}
					}
					x.close();
					//set value of variables
					username = tempUsername;
					password = tempPassword;
					
				}
				
		catch(Exception e){
			//if exception occurs, output "error"
				System.out.println("error");
			}
				//return boolean
				return found;
		}
		  
	}
}


