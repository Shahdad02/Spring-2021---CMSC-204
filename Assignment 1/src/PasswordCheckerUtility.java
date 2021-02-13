/**
 * 
 * @author Shahdad Parsi
 *
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	/*
	 * Check to see if password has uppercase letters
	 * @param passes String password which checks if its has an uppercase letter
	 * @returns true if there is one uppercase letter, or an exception if the password doesn't
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		if(password.equals(password.toLowerCase())) {
			throw new NoUpperAlphaException();
		}
		else {
			return true;
		}
	}
	
	/*
	 * Check to see if password has lowercase letters
	 * @param passes String password which checks if its has an lowercase letter
	 * @returns true if there is one lowercase letter, or an exception if the password doesn't
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException { 
		
		if(password.equals(password.toUpperCase())) {
			throw new NoLowerAlphaException();
		}
		else {
			return true;
		}
	}
	
	/*
	 * Check to see if password is of valid length letters
	 * @param passes String password that checks if password is valid length
	 * @returns true if password is valid length, or an exception if the password isnt
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() < 6) {
			throw new LengthException();
		}
		else {
			return true;
		}
	}
	
	/*
	 * Check to see if password has a digit in it
	 * @param passes String password that checks if password has a digit in it
	 * @returns true if password has a digit , or an exception if the password doesn't
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		char ch = password.charAt(0);
		if(!Character.isDigit(ch)) {
			throw new NoDigitException();
		}
		else {
			return true;
		}
	}
	
	/*
	 * Check to see if password has same character in its sequence
	 * @param passes String password that checks if password has same character in its sequence
	 * @returns true if password has same characters in its sequence, or an exception if the password doesn't
	 * @throws InvalidSequenceException
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		
		boolean sameChar = true;
		for(int i = 0; i <= password.length(); i++) {
			if((i+1 < password.length()) && (i+2 < password.length())){
				if((password.charAt(i) == password.charAt(i+1)) && (password.charAt(i+1) == password.charAt(i+2))) {
					
					sameChar = false;
					throw new InvalidSequenceException();
					//sameChar = false;
				}
				
			}
		}
		return sameChar;
	}
	
	/*
	 * Check to see if password has a special character in its sequence
	 * @param passes String password that checks if password has a special character in its sequence
	 * @returns true if password has a special character in its sequence, or an exception if the password doesn't
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}

	}
	
	/*
	 * Check to see if password is weak
	 * @param passes String password that checks if password is weak and needs more characters, digits, or speical characters
	 * @returns true if password is between 6-9 characters
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		
		boolean weakPass = false;
		if(password.length() >= 6 && password.length() <= 9) {
			weakPass = true;
		}
		
		return weakPass;
	}
	
	/*
	 * Checks the password lengths and complexity to see if it works for a password
	 * @param passes String password to check its complexity
	 * @returns true if password is valid, or whether it isnt
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
														NoLowerAlphaException, NoDigitException, 
														NoSpecialCharacterException, InvalidSequenceException {
		//return null;
		boolean length = false, 
		upper = false, 
		lower = false, 
		hasDigit = false, 
		specialChar = false, 
		sequence = false, valueOf = true;
		
		try {
		
			length = isValidLength(password);
			upper = hasUpperAlpha(password);
			lower = hasLowerAlpha(password);
			hasDigit = hasDigit(password);
			sequence = hasSameCharInSequence(password);
			specialChar = hasSpecialChar(password);
		
		} finally {
			
			if(length == true && upper == true && 
			lower == true && hasDigit == true 
			&& sequence == true && specialChar == true) {
			
				valueOf = true;
			
			} else {
			
				valueOf = false;
			}
		
		}
		return valueOf;
	}
	
	/*
	 * Checks to see what password in the array is invalid
	 * @param passes String password in the array to check whether it is valid or not
	 * @returns arraylist of bad passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
		//return null;
		ArrayList<String> invalid = new ArrayList<String>();
		String invalidPass = null;
		
//		for(String password : passwords) {
//			
//			try {
//				
//				isValidPassword(password);
//			} catch (Exception e) {
//				
//				invalid.add(password + " " + e.getMessage());
//			}
//			
//		}
		
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				
				invalidPass = passwords.get(i);
				if(!isValidPassword(invalidPass)) {
					
					invalidPass = invalidPass + "";
				}
				
			} catch (Exception e) {
				
				invalid.add(invalidPass + " " + e.getMessage());
			}
			
		}
		
		return invalid;
		
	}

	/*
	 * Compares both password inputed
	 * @param passes String password and String passwordConfirm which you compare the two
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if(!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
		
	}
	
	/*
	 * Compares both password inputed with intended return if they are same or not
	 * @param passes String password and String passwordConfirm
	 * @returns true if passwords are the same, false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		//return null;
		boolean works = false;
		if(password.equals(passwordConfirm)) {
			works = true;
		} else {
			works = false;
		}
		
		return works;
	}
	
	/*
	 * Compares both password inputed with intended return if they are same or not
	 * @param passes String password and String passwordConfirm
	 * @returns true if passwords are the same, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		//return null;
		boolean works = false;
		if(password.length() >= 6 && password.length() <= 9) {
			works = true;
		}else {
			works = false;
		}
	
		return works;
	}
	
}
