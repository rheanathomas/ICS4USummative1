package src;
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
//code
//avatars
//backgrounds
//make everything look nicer

public class RheanaStore extends RheanaAccount implements ActionListener{
	//declare variables
	 String saltStr, realStr;
	 Scanner y;
	 boolean duplicate;
	 JLabel lblcode, lblDisplayCode;
	 public static final String CODEFILENAME = "C:\\Users\\Rhea\\filena.txt";
	 JFrame storeFrame;
	 JPanel panStore;
	 JLabel lblTest;
	 JButton btnCode,btnBackground,btnAvatar;
	 
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
	public void actionPerformed(ActionEvent e) {
		//override?
	
		}
	
	
	public void createGui(){
		//create new jpanel
		panStore = new JPanel();
		//initialize jbutton
		btnCode = new JButton("Code");
		//create new jbutton
		btnBackground = new JButton("Unlock backgrounds");
		//set size of jpanel
		panStore.setSize(450,600);
		//set size and location of button
		btnCode.setBounds(100,100,100,100);
		
		//add button to jpanel
	    panStore.add(btnCode);
	    //add panel to frame
		storeFrame.add(panStore);
		//get rid of account jframe
		accFrame.dispose();
	}
	
	public void ButtonActions(){
		btnCode.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if code is used more than once a day....
				if((points-10)>=0){
					//call the price method
					price(10);
					//call method
					getSaltString();
					//show message that gives you the code
					JOptionPane.showMessageDialog(null,"Your code is " + saltStr);
				}
				
				
			}
			
		});
	}
	
	protected String getSaltString() {
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
        saltStr = salt.toString();
        //call verify login method
       VerifyLogin(saltStr, CODEFILENAME);
       //if boolean is false
       if(duplicate==false){
    	   //set value of realstr variable to value of saltstr
    	   realStr = saltStr;
    	   //call save method
    	   save();
       }
       else{
    	   //call method
    	   getSaltString();
       }
        return saltStr;
       

}

	public void price (int p){
		//update points variable
		points = points - p;
		//show message telling you how many points you have
		JOptionPane.showMessageDialog(null,"That cost " + p + "points. You now have " + points + "points "); 
		}
		
		
	 public void save(){
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

		
				fw = new FileWriter(CODEFILENAME);
				bw = new BufferedWriter(fw);
				bw.write(realStr);
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
	  public boolean VerifyLogin(String username,String filepath){
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
					
					if(tempUsername.trim().equals(saltStr.trim()))
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
		
