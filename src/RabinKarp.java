import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
	public final static int d = 256; 
	/** 
	 * @description this method uses a hash function and iteratively checks if hash value of
	 * pSize characters in text is equal to hash value of pattern. If it is equal, it checks
	 * character by character equality of the set and pattern
	 * Hash function is taken as (d^(m-1))%prime where d is more like the base value(256 for characters)
	 * and prime number is random prime number between 1 to length of text
	 * */
	public static List<Integer> search(String text, String pattern, int prime, boolean findFirst) {
		int pSize = pattern.length();
		int tSize = text.length();
		System.out.println("Text length: "+ tSize + " Pattern length: "+ pSize);
		int i, j;
		int hp = 0, ht = 0; // initial hash values for pattern and text
		int h = 1, count=0;
		List<Integer> res = new ArrayList<Integer>();
		
		// preprocessing phase
		for(i = 0; i < pSize-1; i++) {
			h=(h*d)%prime;
		}
		// Compute initial hash value for pattern and first window of text of pSize 
		for(i = 0; i < pSize; i++) {
			count++;
			hp = (d*hp + pattern.charAt(i))%prime; 
            ht = (d*ht + text.charAt(i))%prime; 
		}
		System.out.println("Preprocessing time complexity: "+count);
		// search phase
		count=0;
		for(i=0; i <= tSize-pSize; i++) {
			count++;
			if(hp == ht) {
				for(j=0; j<pSize; j++) {
					count++;
					if(text.charAt(i+j)!=pattern.charAt(j))
						break;
				}
				if(j==pSize) {
					res.add(i);
					if(findFirst) {
						System.out.println("Search time complexity: "+count);
						return res;
					}
				}
			}
			if(i < tSize-pSize) {
				// replacing hash value of most significant letter with least significant value
				ht = (d*(ht - text.charAt(i)*h) + text.charAt(i+pSize)) % prime;
				if(ht < 0) {
					ht = ht + prime;
				}
			}
		}
		System.out.println("Search time complexity: "+count);
		return res;
	}
}
