package w01w_OTPGen;

/*
    Take the current OTP generator code and enhance it to support the following:

    The user must be able to press a + button and add a sitename and press ok.
    Once the user does the above, a code is generated and the JFrame shows an entry for the site with a code and a refresh button next to it
    Instead of auto refresh per line, provide a button to manually generate a new code.
    Hint: Use Arraylist and Gridlayouts
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;

import w01w_OTPGen.Company;

// OTP or two factor identification
// randomly generates a code sent to the user in case they lose their password
public class OTP extends JFrame implements ActionListener {
	
	// button for making new OTP
	JButton addCompany;
	// OTP refresh
	JButton reOTP;
	// result that shows OTP
	JLabel resultLabel;
	ArrayList<Company> company = new ArrayList<Company>();
	
	// allows user to input company names
	JTextField input;
	
	OTP (){
		// creates button and label
		addCompany = new JButton("Add Company!");
		resultLabel = new JLabel("Your OTP Code");
		input = new JTextField("");
		addCompany.addActionListener(this); // do some action when clicked
		
		// creates Border for layout(?)
		//setLayout(new BorderLayout());
		setLayout(new GridLayout(1, company.size()));
		
		// 'this' keyword is the JFrame we're working on
		// this.add
		
		// places buttons on border
		add(addCompany, BorderLayout.SOUTH);
		add(resultLabel, BorderLayout.CENTER);
		// adds text input field
		//add(input, BorderLayout.PAGE_END);
		
		// exit location
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// where it opens
		setLocation(250, 100);
		// shows on screen
		setVisible(true);
		// size dimensions
		setSize(600, 350);
	}
	
	public void addCompany(String name) {
		company.add(new Company(name));
		company.get(company.size()-1).createCode(6);
	}
	
	// Button thing
	//arg0
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// creates a string of 6 random numbers as characters in an array
		// creates a string of 6 random numbers as characters in an array
		//System.out.println(OTP.generate(length));
		// changes text of label to OTP generate
		if (e.getSource() == addCompany) {
			//createLabel()
		}
			
		
		resultLabel.setText(company.get(0).getName());
		
		//add(new JLabel(), BorderLayout.NORTH);
		
		
	}
	
	// main: runs it in a window
	public static void main(String[] args) {
		// opens swing
		new OTP();

	}

}

// My notes copy
/*
package w01w_OTPGen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Random;

// OTP or two factor identification
// randomly generates a code sent to the user in case they lose their password
public class OTP extends JFrame implements ActionListener {
	
	// button for making new OTP
	JButton newOTP;
	// result that shows OTP
	JLabel resultLabel;
	ArrayList<String> company = new ArrayList<String>();
	
	OTP (){
		// creates button and label
		newOTP = new JButton("Refresh!");
		resultLabel = new JLabel("Your OTP Code");
		newOTP.addActionListener(this); // do some action when clicked
		
		// creates Border for layout(?)
		setLayout(new BorderLayout());
		
		// 'this' keyword is the JFrame we're working on
		// this.add
		
		// places buttons on border
		add(newOTP, BorderLayout.SOUTH);
		add(resultLabel, BorderLayout.CENTER);
		
		// exit location
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// where it opens
		setLocation(250, 100);
		// shows on screen
		setVisible(true);
		// size dimensions
		setSize(600, 350);
	}
	
	// generates code
	public static char[] generate(int len) {
		System.out.println("Generating OTP Number.");
		String num = "1234567890";
		
		Random rng = new Random();
		char[] otp = new char [len];
		
		// randomly chooses numbers
		for (int i = 0; i < len; i++) {
			otp[i] = num.charAt(rng.nextInt(num.length()));
		}
		
		return otp;
	}
	
	// Button thing
	//arg0
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int length = 6;
		// creates a string of 6 random numbers as characters in an array
		System.out.println(OTP.generate(length));
		// changes text of label to OTP generate
		resultLabel.setText(String.valueOf(OTP.generate(length)));
	}
	
	// main: runs it in a window
	public static void main(String[] args) {
		// opens swing
		new OTP();

	}

}
 */


//Teacher's Copy
/*
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OTP extends JFrame implements ActionListener {

	JButton new_OTP;
	JLabel resultLabel;
	
	OTP() {
		new_OTP = new JButton("Refresh");
		resultLabel = new JLabel("Your OTP Code");
		new_OTP.addActionListener(this); // do some action on click
	
		// UX setup 
		setLayout(new BorderLayout()); // many layouts available. We picked border layout.
		resultLabel.setHorizontalAlignment(JLabel.CENTER); // center justifies the label contents
		add(new_OTP, BorderLayout.SOUTH);
		add(resultLabel, BorderLayout.CENTER); // organization of components within frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows close operation
		setLocation(250,100); //controls the position of the window
		setVisible(true); //shows the window
		setSize(600,350); //controls the size of the window

		 
	}
	
	static char[] generate(int len) {
		System.out.println("Generating OTP using random(): ");
		String numbers = "0123456789";
		Random rnd_choose = new Random();
		char[] otp = new char[len];
		//choose a random index in the numbers string and put it in otp char array
		for (int i = 0; i < len; i++ ) {
			otp[i] = numbers.charAt(rnd_choose.nextInt(numbers.length()));
		}
		return otp;
	}
	
	public void actionPerformed(ActionEvent e) {
		int length = 6;
		resultLabel.setText(String.valueOf(OTP.generate(length)));
		 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OTP();

	}
	

}*/
