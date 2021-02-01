package w01w_OTPGen;

import java.util.Random;

// My code

public class Company {
	
	private String name;
	private String code;
	// default length of OTP if length is not specified
	private int defaultLen = 6;
	
	Company(){
		name = "Unknown";
		newOTP(defaultLen);
	}
	
	public Company(String companyName){
		name = companyName;
		newOTP(defaultLen);
	}
	
	public Company(String companyName, int len){
		name = companyName;
		newOTP(len);
	}
	
	// generates code
	// default
	public void newOTP() {
		//System.out.println("Generating OTP Number.");
		String num = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		Random rng = new Random();
		char[] otp = new char [defaultLen];
		
		// randomly chooses numbers
		for (int i = 0; i < defaultLen; i++) {
			otp[i] = num.charAt(rng.nextInt(num.length()));
		}
		
		code = String.valueOf(otp);
	}
	// custom
	public void newOTP(int len) {
		//System.out.println("Generating OTP Number.");
		String num = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		Random rng = new Random();
		char[] otp = new char [len];
		
		// randomly chooses numbers
		for (int i = 0; i < len; i++) {
			otp[i] = num.charAt(rng.nextInt(num.length()));
		}
		
		code = String.valueOf(otp);
	}
	
	
	// getters and setters
	
	public void setName(String companyName) {
		name = companyName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOTP() {
		return code;
	}
}
