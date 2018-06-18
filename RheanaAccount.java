

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
JLabel lblAccount;
JLabel lblQuestion, lblFocus, lblPoints,lblDisplayPoints;
int points;
JFrame accFrame;
JButton btnQuestion, btnDone, btnToDo, btnStore,btnCode;
JTextField txtAnswer;
public static final String USEDCODE = "C:\\fileUsed.txt";
public static final String CODEFILENAME = "C:\\codefile.txt";
boolean used,duplicate;
Scanner y;
String lblCode;
JLayeredPane pane3;
JLabel lblImage2;

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
		//intialize boolean as false
		this.used = false;
		this.duplicate = false;
	}
	
	public void actionPerformed(ActionEvent e) {
	}
		public void createGui(){
		//create new JLabel
		lblImage2 = new JLabel();
		//set value of imageicon
		ImageIcon img2g12 = new ImageIcon("C:\\ICS4USummative1\\summative\\account.png");
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
		 pane3 = new JLayeredPane();
		
		//create new components
		lblDisplayPoints = new JLabel("Points: ");
		lblPoints = new JLabel();
		lblAccount = new JLabel("Your Account");
		txtAnswer = new JTextField();
		btnDone = new JButton("Done");
		btnToDo = new JButton("To Do");
		btnCode = new JButton("Input Code");
		btnStore = new JButton("Store");
		lblQuestion = new JLabel ("What is you main focus for today?");
		btnQuestion = new JButton("Answer question for a point"); 
		
		//set size and location of components
		lblAccount.setBounds(125,50,400,50);
		txtAnswer.setBounds(100,300,300,50);
		btnDone.setBounds(140,375,200,20);
		btnToDo.setBounds(25,450,100,50);
		btnCode.setBounds(170,450,110,50);
		btnStore.setBounds(325,450,100,50);
		lblQuestion.setBounds(80,300,400,50);
		btnQuestion.setBounds(125,350,220,40);
		lblDisplayPoints.setBounds(180,80,100,70);
		lblPoints.setBounds(230,80,100,70);
		
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
		//lblUser3.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//set text colour of labels
		lblQuestion.setForeground(Color.WHITE);
		btnQuestion.setForeground(Color.LIGHT_GRAY.brighter());
		btnQuestion.setForeground(Color.gray);
		lblAccount.setForeground(Color.WHITE);
		lblDisplayPoints.setForeground(Color.white);
		lblPoints.setForeground(Color.white);
		//set background colours of components
		lblQuestion.setBackground(Color.DARK_GRAY);
		btnQuestion.setBackground(Color.white);

		updatePoints();
		
		
		//add buttons and textbox to panel
		panAccount.add(btnQuestion);
		panAccount.add(btnStore);
		panAccount.add(btnCode);
		panAccount.add(txtAnswer);
		panAccount.add(btnDone);
		panAccount.add(lblDisplayPoints);
		panAccount.add(lblPoints);
		}

	public void Actions(){
		btnStore.addActionListener(new ActionListener(){

				@Override
			public void actionPerformed(ActionEvent e) {
					// call Store class
					RheanaStore store = new RheanaStore();
					//call methods from Store class
					store.createGui();
					//dispose jframe
					accFrame.dispose();
					
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
	
	   btnCode.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			//create message box that asks for the code
			lblCode = JOptionPane.showInputDialog(null, "What is the code?");
			//make sure the code is correct by calling this method
			VerifyLogin(lblCode,CODEFILENAME);	
			//make sure that the code has not been used yet
			VerifyUsed(lblCode,USEDCODE);
			//if the code is correct and had not been used yet
			if(duplicate==true & used==false){
				//put the code in the file that tracks used code
				save(USEDCODE,lblCode);
				//call the points method
				gainPoints(20);
			}
			else{
				//show messagebox that lets you know that your code is not correct
				JOptionPane.showMessageDialog(null,"Sorry, your code is invalid");
			}
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
		 //update points variable
		 points = points + p;
		 //show message telling user how many points they have
		 JOptionPane.showMessageDialog(null, "You gained " + p + " point(s)! Now your total number of points is " + points);
		 //update label that displays points
		 updatePoints();
	 }
	 
	 private boolean VerifyUsed(String code,String filepath) {
		 		//create new string and intialize it to null
				String tempCode = "";
				try{
					//create new scanner
					y = new Scanner(new File(filepath));
					//get the scanner to ignore these symbols
					y.useDelimiter("[,\n]");
					
					while(y.hasNext()&& !used)
					{
						//make the string equal to the next scanned letter
						tempCode = y.next();
						//if the two values are equal to eachother
						if(tempCode.trim().equals(lblCode.trim()))
								{
							//set boolean to true
							used = true;
							
								}
					}
					//close scanner
					y.close();
				}
				
		catch(Exception e){
			//deal with what happens when there is nothing in the file
				System.out.println("error");
			}
				return used;
		}		
	 
	public void updatePoints() {
		//convert from int to string
		String strPoints = Integer.toString(points);
		//set text of jlabel
		lblPoints.setText(strPoints);
		}
	  public boolean VerifyLogin(String username,String filepath){
		   //
			String tempUsername = "";
			try{
				//create new scanner
				y = new Scanner(new File(filepath));
				//get scanner to ignore these symbols
				y.useDelimiter("[,\n]");
				
				while(y.hasNext()&& !duplicate)
				{
					//set value of string to the next thing the scanner scans
					tempUsername = y.next();
					//if the two values are equal to eachother
					if(tempUsername.trim().equals(lblCode.trim()))
							{
						//set value of boolean to true
						duplicate = true;
						
							}
				}
				//close scanner
				y.close();
				
			}
			
	catch(Exception e){
		  //print this out if there is an exception
			System.out.println("error");
		}
			return duplicate;
	}	
	  public void save(String filepath,String text){
		  //initialize variables
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				//declare new variables
				fw = new FileWriter(filepath);
				bw = new BufferedWriter(fw);
				//write the string
				bw.write(text);

			} catch (IOException e) {
				//deal with exception
				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						//close the bufferedwriter
						bw.close();

					if (fw != null)
						//close filewriter
						fw.close();

				} catch (IOException ex) {
					//deal with exception
					ex.printStackTrace();

				}

			}
	}}

	
