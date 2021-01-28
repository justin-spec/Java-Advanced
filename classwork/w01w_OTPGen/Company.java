package w01w_OTPGen;

import java.util.Random;

public class Company {
	
	private String name;
	private char[] code;
	
	Company(){
		name = "Unknown";
		//code = null;
	}
	
	public Company(String companyName){
		name = companyName;
		//code = null;
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
	
	public void createCode(int len) {
		System.out.println("Generating OTP Number.");
		String num = "1234567890";
		
		Random rng = new Random();
		char[] otp = new char [len];
		
		// randomly chooses numbers
		for (int i = 0; i < len; i++) {
			otp[i] = num.charAt(rng.nextInt(num.length()));
		}
		
		code = otp;
	}
	
	
	// getters and setters
	
	public void setName(String companyName) {
		name = companyName;
	}
	
	public String getName() {
		return name;
	}
}
