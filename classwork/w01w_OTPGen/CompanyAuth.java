package w01w_OTPGen;

import java.util.Random;

// Alexander Aghili's code

public class CompanyAuth {

	private String companyName;
	private char[] OTP;
	private int generateLength = 6;
	
	public CompanyAuth(String companyName) {
		this.companyName = companyName;
		OTP = generate(generateLength);
	}
	
	
	private char[] generate(int len) {
		String numbers  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rndNumbers = new Random();
		char[] otp = new char[len];
		//Takes random number from the numbers string and adds it to the character array
		for (int i = 0; i < len; i++) {
			otp[i] = numbers.charAt(rndNumbers.nextInt(numbers.length()));
		}
		
		return otp;
	}
	
	public char[] getOTP() {
		return OTP;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void newOTP() {
		OTP = generate(generateLength);
	}
}