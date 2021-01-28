package w01w_OTPGen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;

// OTP or two factor identification
// randomly generates a code sent to the user in case they lose their password
public class OTP extends JFrame implements ActionListener {
	
	JButton newOTP;
	JLabel resultLabel;
	
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
	
	public static void main(String[] args) {
		// opens swing
		new OTP();

	}

}
