
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RheanaToDo extends RheanaAccount{
	//declare variables
	JFrame todoFrame;
	ArrayList<JLabel> label = new ArrayList<JLabel>(); 
	JLabel image;
	JLayeredPane lpanTodo = new JLayeredPane();
	JPanel panToDo,panAdd,panDisplay;
	JButton btn1, btn2;
	JTextField txt1;
	String hi;
	JButton btnRemove, btnBack;
	JLabel lbl1;
	int int1;
	JLabel lblImage3;
	JLabel lblImage4;
	
	
	public RheanaToDo(){
		//create new jframe
		todoFrame = new JFrame();
		//set size of jframe
		todoFrame.setSize(450,650);
		//make jframe visible
		todoFrame.setVisible(true);
		//make frame non resizable
		todoFrame.setResizable(false);
		//set size of panel
		lpanTodo.setPreferredSize(new Dimension(550, 400));
		//set location of frame
		todoFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - todoFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - todoFrame.getHeight()/2);
	}
	
	public void createGui(){
		//create new components
		lblImage3 = new JLabel(); 
		panToDo = new JPanel();
		panDisplay = new JPanel();
		panAdd = new JPanel();
		txt1 = new JTextField("");
		JLabel lblAdd = new JLabel("Add your task in the textbox");
		btn1 = new JButton("Add");
		btnRemove = new JButton("Remove");
		btn2 = new JButton("Done");
		lblImage4 = new JLabel();
		btnBack = new JButton("Go back");
		
		//create new imageicon
		ImageIcon img2g13 = new ImageIcon("C:\\ICS4USummative1\\summative\\todo.png");
		// transform it into an image
		Image image3 = img2g13.getImage(); 
		// scale it the smooth way  
		Image newimg3 = image3.getScaledInstance(450,650, java.awt.Image.SCALE_SMOOTH); 
		//put image in an imageicon
		ImageIcon img2g3 = new ImageIcon(newimg3);
		//put image in label
		lblImage3.setIcon(img2g3);
		//set bounds of jlabel
		lblImage3.setBounds(0,0,450,650);
	
		
		//create new imageicon
		ImageIcon img2g14 = new ImageIcon("C:\\Users\\Rhea\\ICS4USummative1\\summative\\input.png");
		// transform it into an image
		Image image4 = img2g14.getImage(); 
		// scale it the smooth way  
		Image newimg4 = image4.getScaledInstance(450,650, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		//put image in an imageicon
		ImageIcon img2g4 = new ImageIcon(newimg4);
		//put image in label
		lblImage4.setIcon(img2g4);
		//set bounds of jlabel
		lblImage4.setBounds(0,0,450,650);

		//set layouts of jpanels to null
		panDisplay.setLayout(null);
		panAdd.setLayout(null);
		panToDo.setLayout(new BoxLayout(panToDo, BoxLayout.Y_AXIS));
		lpanTodo.setLayout(null);
		
		//set size and locations of components
		panToDo.setBounds(40,150,375,350);
		lpanTodo.setBounds(200,0,500,500);
		panAdd.setBounds(0,0,500,500);
		panAdd.setBounds(0, 0, 400, 400);
		lblAdd.setBounds(140,50,300,75);
	    txt1.setBounds(75,120,300,50);
	    btn2.setBounds(192,200,75,30);
		btn1.setBounds(40,550,100,40);
		btnRemove.setBounds(175,550,100,40);
		btnBack.setBounds(315,550,100,40);
		panDisplay.setBounds(0,0,450,600);
		
		//set colour of text
		lblAdd.setForeground(Color.white);
       
		//set background colour of button
        btn2.setBackground(Color.white);
       
        //make panels transparent
		panAdd.setOpaque(false);
		panToDo.setOpaque(false);
		panDisplay.setOpaque(false);
		
		//set components as invisible
		panAdd.setVisible(false);
		lblImage4.setVisible(false);
	
		//add components to panels
		panDisplay.add(btn1);
		panDisplay.add(btnRemove);
		panDisplay.add(btnBack);
	    panAdd.add(lblAdd);
		panAdd.add(btn2);
		panAdd.add(txt1);
		
		//add components to the layeredpanel
		lpanTodo.add(panToDo,new Integer(2));
		lpanTodo.add(panDisplay,new Integer(2));
		lpanTodo.add(panAdd,new Integer(2));
		lpanTodo.add(lblImage3,new Integer(1));
		lpanTodo.add(lblImage4,new Integer(1));
		lpanTodo.setVisible(true);
		todoFrame.add(lpanTodo);
		todoFrame.setVisible(true);
		
		//call method
		actions();
		
	}
		
	public void actions(){
		//add action listener to button
		btn1.addActionListener(new ActionListener(){
	
				@Override
				public void actionPerformed(ActionEvent e) {
					//set components as invisible
					panToDo.setVisible(false);
					panDisplay.setVisible(false);
		            lblImage3.setVisible(false);
		         
		            //set components to visible
					panAdd.setVisible(true);
					lblImage4.setVisible(true);
					
					 //add action listener to button
					 btn2.addActionListener(new ActionListener(){
	
						@Override
						public void actionPerformed(ActionEvent e) {
							//make panel invisible
							panAdd.setVisible(false);
							//call method
							output();	
						}
							
				});
					
				}});	
		    //add action listener to button
			btnRemove.addActionListener(new ActionListener(){
	
				@Override
				public void actionPerformed(ActionEvent e) {
				
					//put response the the input dialog in a string
					 String strRemove= JOptionPane.showInputDialog("Please input the number/index of the item you would like to delete");
					 //call the remove method with the string as the parameter
					 remove(strRemove);
					 int question = JOptionPane.showConfirmDialog(null, "Did you complete the task?", null, JOptionPane.YES_NO_OPTION);
				        if (question == JOptionPane.YES_OPTION) {
				        	gainPoints(5);
				        }
				        else{
				        	
				        }
					 //remove components in jpanel
					 panToDo.removeAll();
					 //set size and location of button
					 btn1.setBounds(40,550,100,40);
					 //set size and location of button
					 btnRemove.setBounds(200,550,100,40);
					btnBack.setBounds(315,550,100,40);
					 //call otput method
					 output();
					 //make components visible
					 panToDo.setVisible(true);
					 panDisplay.setVisible(true);
					 btnBack.setVisible(true);
				    }
	
				private void remove(String str) {
					//value of int1 is equal to the inputted string
					 int1 = Integer.parseInt(str);
					 //remove the arraylist component
					 label.remove(int1-1);
				}});

		RheanaAccount account = new RheanaAccount();
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose jframe
				todoFrame.dispose();
				//call method from RheanaAccount to create gui
				account.createGui();
				//call method
				account.Actions();
			
		}
		
	});
	
	
	}
		
	public void output() {
				
		do { 
			//set value
			 hi = txt1.getText();
			 //create new label
			 image = new JLabel(); 
			 //set text in label to the contents on the string
			 image.setText(hi);
			 //set size and location of label
			 image.setBounds(0,0,10,10); 
			 //set jlabel as visible
			 image.setOpaque(true); 
			 //add jlabel to arraylist
			 label.add(image);
			 //set value of textbox to null
			 txt1.setText("");    
			 //set value of string to null
			 hi = null;
	     //repeat while hi is not null
	    }while(hi!=null);
				
		for(JLabel j:label) { 
			//add components of arraylist to jpanel
		    panToDo.add(j); 
		}
		//set components as visible
	    panDisplay.setVisible(true);
		lblImage3.setVisible(true);
		panToDo.setVisible(false);
		panToDo.setVisible(true);
		}

    }
	