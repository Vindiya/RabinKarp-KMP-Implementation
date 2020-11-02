import java.util.ArrayList;
import java.util.List;

public class KMPMatching {
	/** 
	 * @description this method pre-processes the pattern to be searched
	 * and generates LPS(longest prefix suffix) array such that LPS[i] implies
	 * to start checking pattern from LPS[i]th index if mismatch occurs at i index in pattern
	 * this way we don't have to backtrack in text if partial pattern matches with a sequence
	 * */
	public static List<Integer> search(String text, String pattern, boolean findFirst) {
		// search phase
		int pSize = pattern.length();
		int tSize = text.length();
		System.out.println("Text length: "+ tSize + " Pattern length: "+ pSize);
		int[] LPS = generateLPS(pattern, pSize);
		int i=0, j=0, passes=0;
		List<Integer> res = new ArrayList<Integer>();
		while(i < tSize) {
			passes++;
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;
				j++;
			}
			if(j==pSize) {
				res.add(i-j);
				if(findFirst) {
					System.out.println("Search time complexity: "+passes);
					return res;
				}
				j = LPS[j - 1]; 
			} else if(i < tSize && pattern.charAt(j)!=text.charAt(i)) {
				if(j != 0)
					j=LPS[j-1];
				else
					i=i+1;
			}
		}
		System.out.println("Search time complexity: "+passes);
		return res;
	}
	/**
	 *  @description this method generates LPS array
	 *  it uses indexTracker to compare characters in pattern
	 *  and returns an array LPS such that value at each index tells where to
	 *  start searching from in case of mismatch
	 */
	private static int[] generateLPS(String pattern, int pSize) {
		// preprocessing phase
		int[] lps = new int[pSize];
		lps[0]=0; // initialize first element to 0
		int i=1, indexTracker=0, count=1; // count 1 since lps[0] has already been initialized
		while(i<pSize) {
			count++;
			if(pattern.charAt(indexTracker)==pattern.charAt(i)) {
				indexTracker++;
				lps[i++]=indexTracker;
			} else {
				if(indexTracker==0) {
					lps[i] = indexTracker;
					i++;
				} else {
					indexTracker = lps[indexTracker-1];
				}
			}
		}
		System.out.println("Preprocessing time complexity: "+count);
		return lps;
	}
}
