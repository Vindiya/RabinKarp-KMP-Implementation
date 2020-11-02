import java.util.Random;

public class RandomString {
	public static String generatedString = "";
	public static void main(String args[]) {
		generateRandomString(10);
	}
	public static String generateRandomString(int stringSize) {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(stringSize);
	    for (int i = 0; i < stringSize; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    generatedString = buffer.toString();
	 
	    System.out.println("Generated string: "+generatedString);
	    return generatedString;
	}
	public static String pickWord(int limit) {
		Random r = new Random();
		int start = r.nextInt((generatedString.length()-limit) + 1);
		String word = generatedString.substring(start, start+limit);
		System.out.println("Generated string: "+word);
		return word;
	}
}
