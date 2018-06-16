package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RheanaAccount extends RheanaFirstGui implements ActionListener {
//array of dicount/point codes
//declare variables
Scanner x;
JPanel panAccount = new JPanel();
JLabel lblDisplayUser,lblAccount;
JLabel lblUser3,lblQuestion, lblFocus, lblPoints;
int points;
JFrame accFrame;
JButton btnQuestion, btnDone, btnToDo, btnStore,btnCode;
JTextField txtAnswer;

//String username,password;
//do i have overriding?
	public RheanaAccount(){
		//initialize jframe
		accFrame = new JFrame();
		//set size of jframe
		accFrame.setSize(450,650);
		//initialize panel
		panAccount = new JPanel();
		//set size of panel
		panAccount.setSize(600,600);	
		//initialize points to zero
		this.points = 0;
	}
	
	public void actionPerformed(ActionEvent e) {
		//create new JLabel
		JLabel lblImage2 = new JLabel();
		//set value of imageicon
		ImageIcon img2g12 = new ImageIcon("C:\\Users\\Rhea\\ICS4USummative1\\summative\\account.png");
		// transform it 
		Image image2 = img2g12.getImage();
		//resize image
		Image newimg2 = image2.getScaledInstance(450,650, java.awt.Image.SCALE_SMOOTH); 
		//add new imageicon
		ImageIcon img2g2 = new ImageIcon(newimg2);
		//set label to image
		lblImage2.setIcon(img2g2);
		//set size and location
		lblImage2.setBounds(0,0,450,650);

		//set layout to null
		panAccount.setLayout(null);

		
		//set location of frame
		accFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - accFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - accFrame.getHeight()/2);
		
		//create jlayeredpane			
		JLayeredPane pane3 = new JLayeredPane();
		
		//create new components
		lblDisplayUser = new JLabel("Username: ");
		lblAccount = new JLabel("Your Account");
		txtAnswer = new JTextField();
		btnDone = new JButton("Done");
		btnToDo = new JButton("To Do");
		btnCode = new JButton("Input Code for points");
		btnStore = new JButton("Store");
		lblQuestion = new JLabel ("What is you main focus for today?");
		btnQuestion = new JButton("Answer question for a point"); 
		
		
		//set size and location of components
		lblDisplayUser.setBounds(20,100,100,70);
		lblAccount.setBounds(125,50,400,50);
		txtAnswer.setBounds(0,300,300,50);
		btnDone.setBounds(70,375,200,20);
		btnToDo.setBounds(25,450,100,50);
		btnCode.setBounds(170,450,110,50);
		btnStore.setBounds(325,450,100,50);
		lblQuestion.setBounds(80,300,400,50);
		btnQuestion.setBounds(125,350,200,20);
		lblUser3.setBounds(130,100,100,70);
		
		//make components visible
		btnDone.setVisible(false);
		btnToDo.setVisible(true);
		btnCode.setVisible(true);
		txtAnswer.setVisible(false);
		btnDone.setVisible(false);
		
		//customize the fonts of the components
		lblQuestion.setFont(new Font("Serif", Font.BOLD,20));
		btnQuestion.setFont(new Font("Serif", Font.PLAIN, 10));
		lblAccount.setFont(new Font("Impact", Font.PLAIN, 35));
		lblUser3.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//set text colour of labels
		lblQuestion.setForeground(Color.WHITE);
		btnQuestion.setForeground(Color.LIGHT_GRAY.brighter());
		btnQuestion.setForeground(Color.gray);
		lblAccount.setForeground(Color.WHITE);
		lblDisplayUser.setForeground(Color.white);
		lblUser3.setForeground(Color.white);
		//set background colours of components
		lblQuestion.setBackground(Color.DARK_GRAY);
		btnQuestion.setBackground(Color.white);
		
		//add buttons and textbox to panel
		panAccount.add(btnQuestion);
		panAccount.add(btnStore);
		panAccount.add(btnCode);
		panAccount.add(txtAnswer);
		panAccount.add(btnDone);
		
		btnStore.addActionListener(new ActionListener(){

				@Override
			public void actionPerformed(ActionEvent e) {
					// call Store class
					RheanaStore store = new RheanaStore();
					//call methods from Store class
					store.createGui();
					store.ButtonActions();
				}
				  
			 });
	    btnToDo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// call todo class
				RheanaToDo todo = new RheanaToDo();
				//call method from class
				todo.createGui();
				//delete frame
				accFrame.dispose();
			}
			  
		 });
	
		 btnStore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//finish this?
				String lblCode = JOptionPane.showInputDialog(null, "What is the code?");
				
			}
			  
		 });
		btnQuestion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//make components visible
				btnQuestion.setVisible(false);
				lblQuestion.setVisible(false);
				txtAnswer.setVisible(true);
				btnDone.setVisible(true);
		
		btnDone.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//add JLayeredPanel for btnQuestion, txtAnswer and lblFocus
				//do something to check what the person inputed (e.g. if they inputted something)
				//create new label and set text as the value of the textbox
				lblFocus = new JLabel("Focus of the day: " + txtAnswer.getText());
				//set size and location of label
				lblFocus.setBounds(100,300,400,50);
				//male label visible
				lblFocus.setVisible(true);
				//add label to panel
				panAccount.add(lblFocus);
				//make components invisible
				txtAnswer.setVisible(false);
				btnDone.setVisible(false);
				//call method
				gainPoints(1);			
				}		
			}  
		);
                 					
				};
		   });
		   //make panel transparent
		    panAccount.setOpaque(false);
		    //add components to panel
		    panAccount.add(lblAccount);
			panAccount.add(lblDisplayUser);
			panAccount.add(lblUser3);
			panAccount.add(lblQuestion);
			panAccount.add(btnQuestion);
			panAccount.add(btnDone);
			panAccount.add(btnToDo);
			panAccount.add(btnCode);
			
			//add components to layered pane
			pane3.add(panAccount, new Integer(2));
			pane3.add(lblImage2, new Integer(1));
			
			//add layered pane to jframe
			accFrame.add(pane3);
			//make frame visible
			accFrame.setVisible(true);
		  
	}

	 public void gainPoints(int p){
		 //add more to this method? maybe if they get blank amount of points...special reward?
		 //update points variable
		 points = points + p;
		 //show message telling user how many points they have
		 JOptionPane.showMessageDialog(null, "You gained " + p + " point(s)! Now your total number of points is " + points);
	 }
	 
	 
	
	}

	
