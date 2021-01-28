package w01w_OTPGen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Random;

// OTP or two factor identification
// randomly generates a code sent to the user in case they lose their password
public class OTP extends JFrame implements ActionListener {
	
	JButton newOTP;
	JLabel resultLabel;
	
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
	
	public static void main(String[] args) {
		// creates a string of 6 random numbers as characters in an array
		System.out.println(OTP.generate(6));

	}
	
	//arg0
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
