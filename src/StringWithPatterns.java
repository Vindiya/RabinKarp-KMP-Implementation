import java.util.Random;

public class StringWithPatterns {
	private static String[] textList = {
			"abaaaaaaaaaaaaababababababababababaab",
			"abcdabfreuabiosdiabceabsdcdsoicjdoicjdioc",
			"todaytheboyplayedwithaballandaballooninthepark",
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
			"zzzzzzzzzzzzzzzzzzzzzzzzzzzzz",
			"ttttttttttttttttttttttttttttttt",
			"hhhhhhhhhh",
			"hhhhhhhhhhhhhhhhhhhh",
			"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
			"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
			"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
	};
	private static String[] patternList = {
			"abaab",
			"abceab",
			"balloon",
			"aaab",
			"zzz",
			"ty",
			"hhhh",
			"hhhhhhhhhh",
			"hhh",
			"hhhh",
			"hhhhh"
	};
	private static int index=-1;
	public static int pickIndex() {
		Random r = new Random();
		return r.nextInt((textList.length) + 1);
	}
	public static String pickText() {
		index = pickIndex();
		System.out.println("Generated text:"+textList[index]);
		return textList[index];
	}
	public static String pickPattern() {
		System.out.println("Generated pattern:"+patternList[index]);
		return patternList[index];
	}
}
