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
		storeFrame = new JFrame();
		storeFrame.setSize(450,650);
	    storeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//firstPane.setPreferredSize(new Dimension(550, 400));
		storeFrame.setResizable(false);
		storeFrame.setVisible(true);
		storeFrame.setLocation((int) getToolkit().getDefaultToolkit().getScreenSize().getWidth()/2 - storeFrame.getWidth()/2,(int) getToolkit().getDefaultToolkit().getScreenSize().getHeight()/2 - storeFrame.getHeight()/2);
		
	}
	public void actionPerformed(ActionEvent e) {
		//override?
	
		}
	
	
	public void createGui(){
		panStore = new JPanel();
		panStore.setSize(450,600);
		btnCode = new JButton("Code");
		btnCode.setBounds(100,100,100,100);
		
		btnBackground = new JButton("Unlock backgrounds");
	    panStore.add(btnCode);
		storeFrame.add(panStore);
		accFrame.dispose();
	}
	
	public void ButtonActions(){
		btnCode.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if code is used more than once a day....
				if((points-10)>=0){
					price(10);
					getSaltString();
					JOptionPane.showMessageDialog(null,"Your code is " + saltStr);
				}
				
				
			}
			
		});
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        saltStr = salt.toString();
       System.out.println(saltStr);
       VerifyLogin(saltStr, CODEFILENAME);
       if(duplicate==false){
    	   realStr = saltStr;
    	   save();
    	   System.out.print("Your code is " + realStr);
    	 
       }
       else{
    	   getSaltString();
       }
        return saltStr;
       

}

	public void price (int p){
		points = points - p;
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
		
