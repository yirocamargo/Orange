package Orange.Steps;

import java.security.SecureRandom;


public class DataRandom {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public static String randomUsers(int len){
	   StringBuilder userRandom = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      userRandom.append(AB.charAt(rnd.nextInt(AB.length())));
	   System.out.println(userRandom);
	   return userRandom.toString();
	}
}
