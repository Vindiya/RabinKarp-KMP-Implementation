import java.util.List;
import java.util.Scanner;

public class PatternMatch {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 for random string and pattern");
		System.out.println("Enter 2 for existing word");
		System.out.println("Enter 3 for partial fragment");
		int input = scanner.nextInt();
		int patternLength=0, textLength=0;
		boolean findFirst = false;
		String text = "";
		String pattern = "";
		switch(input) {
			case 1: // random text and pattern
				System.out.println("Enter text length");
				textLength = scanner.nextInt();
				System.out.println("Enter pattern length");
				patternLength = scanner.nextInt();
				text = RandomString.generateRandomString(textLength);
				pattern = RandomString.generateRandomString(patternLength);
				findFirst=true;
				break;
			case 2: // random text and existing pattern
				System.out.println("Enter text length");
				textLength = scanner.nextInt();
				System.out.println("Enter pattern length");
				patternLength = scanner.nextInt();
				text = RandomString.generateRandomString(textLength);
				pattern = RandomString.pickWord(patternLength);
				findFirst = true;
				break;
			case 3: // pre-recorded text and pattern
				text = StringWithPatterns.pickText();
				textLength = text.length();
				pattern = StringWithPatterns.pickPattern();
				break;
			default: break;
		}
		scanner.close();
		// KMP
		System.out.println();
		System.out.println("Knuth-Morris-Pratt");
		System.out.println("============================");
		List<Integer> res = KMPMatching.search(text, pattern, findFirst);
		printResults(res);
		// Rabin Karp
		System.out.println();
		System.out.println("Rabin Karp");
		System.out.println("============================");
		int prime = GeneratePrime.get(textLength);
		res = RabinKarp.search(text, pattern, prime, findFirst);
		printResults(res);
	}
	public static void printResults(List<Integer> list) {
		if(list.size()==0) {
			System.out.println("Pattern not found in text");
		} else {
			for(int i: list)
				System.out.println(i);
		}
	}
}
