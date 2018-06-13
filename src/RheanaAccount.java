
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
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
		//create jlayeredpane
		JLayeredPane pane3 = new JLayeredPane();
		
		//set location of frame
		accFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - accFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - accFrame.getHeight()/2);
		//set layout to null
		panAccount.setLayout(null);
		//create new jlabel
		lblAccount = new JLabel("Your Account");
		//set size and location
		lblAccount.setBounds(125,50,400,50);
		//customize font
		lblAccount.setFont(new Font("Impact", Font.PLAIN, 35));
		//set foregound colour to white
		lblAccount.setForeground(Color.WHITE);
		//initialize label
		lblDisplayUser = new JLabel("Username: ");
		//set size and location of jlabel
		lblDisplayUser.setBounds(20,100,100,70);
		//customize font
		lblDisplayUser.setFont(new Font("Serif", Font.PLAIN, 20));
		//set foreground colour
		lblDisplayUser.setForeground(Color.white);
		//create new label
		lblUser3.setBounds(130,100,100,70);
		lblUser3.setFont(new Font("Serif", Font.PLAIN, 20));
		lblUser3.setForeground(Color.white);
		points = 0;
		txtAnswer = new JTextField();
		txtAnswer.setBounds(0,300,300,50);
		btnDone = new JButton("Done");
		btnDone.setBounds(70,375,200,20);
		btnDone.setVisible(false);
		btnToDo = new JButton("To Do");
		btnToDo.setBounds(25,450,100,50);
		btnToDo.setVisible(true);
		btnCode = new JButton("Input Code for points");
		btnCode.setBounds(170,450,110,50);
		btnCode.setVisible(true);
		btnStore = new JButton("Store");
		btnStore.setBounds(325,450,100,50);
	
		lblQuestion = new JLabel ("What is you main focus for today?");
		lblQuestion.setBounds(80,300,400,50);
		lblQuestion.setFont(new Font("Serif", Font.BOLD,20));
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setBackground(Color.DARK_GRAY);
		btnQuestion = new JButton("Answer question for a point"); 
		btnQuestion.setBackground(Color.white);
		btnQuestion.setForeground(Color.LIGHT_GRAY.brighter());
		txtAnswer.setVisible(false);
		btnDone.setVisible(false);
		btnQuestion.setBounds(125,350,200,20);
		btnQuestion.setFont(new Font("Serif", Font.PLAIN, 10));
		btnQuestion.setForeground(Color.gray);
		panAccount.add(btnQuestion);
		panAccount.add(btnStore);
		panAccount.add(btnCode);
		panAccount.add(txtAnswer);
		panAccount.add(btnDone);
		
		btnStore.addActionListener(new ActionListener(){

				@Override
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					RheanaStore store = new RheanaStore();
					store.createGui();
					store.ButtonActions();
				}
				  
			 });
	    btnToDo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RheanaToDo todo = new RheanaToDo();
				todo.createGui();
				//todo.Actions();
				accFrame.dispose();
			}
			  
		 });
	
		 btnStore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String lblCode = JOptionPane.showInputDialog(null, "What is the code?");
				
			}
			  
		 });
		btnQuestion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				btnQuestion.setVisible(false);
				lblQuestion.setVisible(false);
				txtAnswer.setVisible(true);
				btnDone.setVisible(true);
		
		btnDone.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//add JLayeredPanel for btnQuestion, txtAnswer and lblFocus
				//do something to check what the person inputed (e.g. if they inputted something)
				lblFocus = new JLabel("Focus of the day: " + txtAnswer.getText());
				lblFocus.setBounds(100,300,400,50);
				lblFocus.setVisible(true);
				panAccount.add(lblFocus);
				txtAnswer.setVisible(false);
				btnDone.setVisible(false);
				gainPoints(1);			
				}		
			}  
		);
                 					
				};
		   });
		   
		    panAccount.setOpaque(false);
		    panAccount.add(lblAccount);
			panAccount.add(lblDisplayUser);
			panAccount.add(lblUser3);
			panAccount.add(lblQuestion);
			panAccount.add(btnQuestion);
			panAccount.add(btnDone);
			panAccount.add(btnToDo);
			panAccount.add(btnCode);
			
			//panAccount.add(btnToDo);
			pane3.add(panAccount, new Integer(2));
			pane3.add(lblImage2, new Integer(1));
			accFrame.add(pane3);
			accFrame.setVisible(true);
		  
	}

	 public void gainPoints(int p){
		 //add more to this method? maybe if they get blank amount of points...special reward?
		 points = points + p;
		 JOptionPane.showMessageDialog(null, "You gained " + p + " point(s)! Now your total number of points is " + points);
	 }
	 
	 
	
	}

	
