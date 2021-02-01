package w01w_OTPGen;

/*
    Take the current OTP generator code and enhance it to support the following:

    The user must be able to press a + button and add a sitename and press ok.
    Once the user does the above, a code is generated and the JFrame shows an entry for the site with a code and a refresh button next to it
    Instead of auto refresh per line, provide a button to manually generate a new code.
    Hint: Use Arraylist and Gridlayouts
 */

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;

//import w01w_OTPGen.Company;

// Modifying and testing Alexander Aghili's code to better understand how swing works

public class OTP extends JFrame implements ActionListener {
	
	// CompanyAuth somehow works even though it is not being imported directly
	// Maybe Java just automatically recognizes it because it's in the same folder
	//CompanyAuth test = new CompanyAuth("test");
	
	// arrays for each new company being added
	private static ArrayList<CompanyAuth> companyAuths = new ArrayList<CompanyAuth>();
	private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private static ArrayList<JButton> refreshButtons = new ArrayList<JButton>();
	
	// adding company name button and text field
	private JButton addCompanyButton;
	private JTextField addCompanyText;
	
	public OTP() {
		addCompany();
		// creates a grid: new labels created go down
		setLayout(new GridLayout(0, 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 100);
		this.setVisible(true);
		this.setSize(600, 350);
		
	}
	
	// creates new company label with OTP and refresh button
	private void createLabel(String companyName) {
		CompanyAuth newCompany = new CompanyAuth(companyName);
		companyAuths.add(newCompany);
		
		JLabel label = new JLabel("<html>Company: " + companyName
						+ "<br/>OTP: " + String.valueOf(newCompany.getOTP()) + "</html>");
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(label);
		labels.add(label);
		
		JButton refreshButton = new JButton("Refresh");
		this.add(refreshButton);
		refreshButtons.add(refreshButton);
		refreshButtons.get(refreshButtons.size() - 1).addActionListener(this);	
		
		//Refreshes the page
		this.invalidate();
		this.validate();
		this.repaint();
	}
	
	private void addCompany() {
		// creating and adds text field
		addCompanyText = new JTextField();
		this.add(addCompanyText);
		// button for adding company
		addCompanyButton = new JButton("+");
		// goes to action performed when clicked (addCompanyButton conditional is there)
		addCompanyButton.addActionListener(this);
		// adds button
		this.add(addCompanyButton);
	}
	
	private static void refreshOTP(int index) {
		companyAuths.get(index).newOTP();
		labels.get(index).setText("<html>Company: " + companyAuths.get(index).getCompanyName() 
				+ "<br/>OTP: " + String.valueOf(companyAuths.get(index).getOTP()) + "</html>");
	}
	
	public static void main(String[] args) {
		new OTP();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getSource());
		//System.out.println(addCompanyButton);
		
		// if e is addCompnyButton and is not empty string, add company name and reset text field
		if (e.getSource() == addCompanyButton && !addCompanyText.getText().equals("")) {
			createLabel(addCompanyText.getText());
			addCompanyText.setText("");
			addCompanyText.grabFocus();
			return;
		}
		
		for(int i = 0; i < refreshButtons.size(); i++) {
			if (e.getSource() == refreshButtons.get(i)) {
				refreshOTP(i);
			}
		}
		
	}

}

/*
//Alexander Aghili

public class OTP extends JFrame implements ActionListener {

	private static ArrayList<CompanyAuth> companyAuths = new ArrayList<CompanyAuth>();
	private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private static ArrayList<JButton> refreshButtons = new ArrayList<JButton>();
	
	
	private JButton addCompanyButton;
	private JTextField addCompanyText;
	
	public OTP() {
		addCompany();
		
		setLayout(new GridLayout(0, 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 100);
		this.setVisible(true);
		this.setSize(600, 350);
		
	}
	
	private void createLabel(String companyName) {
		CompanyAuth newCompany = new CompanyAuth(companyName);
		companyAuths.add(newCompany);
		
		JLabel label = new JLabel("<html>Company: " + companyName
						+ "<br/>OTP: " + String.valueOf(newCompany.getOTP()) + "</html>");
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(label);
		labels.add(label);
		
		JButton refreshButton = new JButton("Refresh");
		this.add(refreshButton);
		refreshButtons.add(refreshButton);
		refreshButtons.get(refreshButtons.size() - 1).addActionListener(this);	
		
		//Refreshes the page
		this.invalidate();
		this.validate();
		this.repaint();
	}
	
	private void addCompany() {
		addCompanyText = new JTextField();
		this.add(addCompanyText);
		addCompanyButton = new JButton("+");
		addCompanyButton.addActionListener(this);
		this.add(addCompanyButton);
	}
	
	private static void refreshOTP(int index) {
		companyAuths.get(index).newOTP();
		labels.get(index).setText("<html>Company: " + companyAuths.get(index).getCompanyName() 
				+ "<br/>OTP: " + String.valueOf(companyAuths.get(index).getOTP()) + "</html>");
	}
	
	public static void main(String[] args) {
		new OTP();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCompanyButton && !addCompanyText.getText().equals("")) {
			createLabel(addCompanyText.getText());
			addCompanyText.setText("");
			addCompanyText.grabFocus();
			return;
		}
		
		for(int i = 0; i < refreshButtons.size(); i++) {
			if (e.getSource() == refreshButtons.get(i)) {
				refreshOTP(i);
			}
		}
		
	}

}
 */

/*
// My old code - Does not work
public class OTP extends JFrame implements ActionListener {
	
	// button for making new company object and otp
	JButton addCompany;
	// OTP refresh for each company
	JButton reOTP;
	// result that shows company and otp
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

}*/

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
