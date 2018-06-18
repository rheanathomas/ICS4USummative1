
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RheanaStore extends RheanaAccount implements ActionListener{
	//declare variables
	 String codeStr, realStr;
	 Scanner y;
	 boolean duplicate, used;
	 JLabel lblcode, lblDisplayCode;
	 public static final String CODEFILENAME = "C:\\codefile.txt";
	 JFrame storeFrame;
	 JPanel panStore;
	 JLabel lblTest;
	 JButton btnGetCode,btnBackground,btnAvatar,btnBack;
	 
	public RheanaStore(){
		//create new jframe
		storeFrame = new JFrame();
		//set size of jframe
		storeFrame.setSize(450,650);
		//create the exit button
	    storeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//stop uses from resizing jframe
		storeFrame.setResizable(false);
		//make jframe visible
		storeFrame.setVisible(true);
		//set location of jframe
		storeFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - storeFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - storeFrame.getHeight()/2);
		
	}
	
	public void Actions(){
        btnGetCode.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if((points-10)>=0){
					//call the price method
					price(10);
					//call method
					getCodeString();
					
					//show message that gives you the code
					JOptionPane.showMessageDialog(null,"Your code is " + realStr);
				}
				else{
					JOptionPane.showMessageDialog(null,"Sorry, you do not have enough points");
				}
				
			//}
			
		}});
        
        //
		RheanaAccount account = new RheanaAccount();
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose frame
				storeFrame.dispose();
				//create gui of RheanaAccount
				account.createGui();
				//call actions method from RheanaAccount
				account.Actions();
				//call method
				updatePoints();
			
		}
		
	});
		}
	
	
	public void createGui(){
		//create new jpanel
		panStore = new JPanel();
		//initialize jbuttons
		btnGetCode = new JButton("Code");
		btnBack = new JButton("Go back");
		
		//create new jbutton
		btnBackground = new JButton("Unlock backgrounds");
		//set size of jpanel
		panStore.setSize(450,600);
		//set size and location of button
		btnGetCode.setBounds(100,100,100,100);
		btnBack.setBounds(100,300,100,100);
		
		//add button to jpanel
	    panStore.add(btnGetCode);
	    panStore.add(btnBack);
	    //add panel to frame
		storeFrame.add(panStore);
		//get rid of account jframe
		accFrame.dispose();
		
		Actions();
	}
	
	
	
	protected String getCodeString() {
		//set value of string
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        //create new stringbuilder
        StringBuilder salt = new StringBuilder();
        //create random
        Random rnd = new Random();
        
        while (salt.length() < 6) { 
        	//set value of inex
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            //update value
            salt.append(SALTCHARS.charAt(index));
        }
        //set value of the string to the value of salt variable
        codeStr = salt.toString();
        //call verify login method
       VerifyLogin(codeStr, CODEFILENAME);
   
       //if boolean is false
       if(duplicate==false){
    	   //set value of realstr variable to value of codeStr
    	   realStr = codeStr;
    	   //call save method
    	   save(CODEFILENAME,realStr);
       }
       else{
    	   //call method
    	   getCodeString();
       }
        return codeStr;
       

}


	public void price (int p){
     		//update points variable
		points = points - p;
		//show message telling you how many points you have
		JOptionPane.showMessageDialog(null,"That cost " + p + "points. You now have " + points + "points "); 
		}
		
		
	  public boolean VerifyLogin(String code,String filepath){
		  duplicate = false;
			String tempUsername = "";
			//String tempPassword = "";
			
			try{
				//see if using the x scanner again works
				y = new Scanner(new File(filepath));
				y.useDelimiter("[,\n]");
				
				while(y.hasNext()&& !duplicate)
				{
					tempUsername = y.next();
					//tempPassword = x.next();
					
					if(tempUsername.trim().equals(code.trim()))
							{
						duplicate = true;
						
							}
				}
				y.close();
				System.out.println(duplicate);
				
				
			}
			
	catch(Exception e){
		//deal with what happens when there is nothing in the file
			System.out.println("error");
		}
			return duplicate;
	}		
	}
		
