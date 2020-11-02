import java.util.Random;

public class GeneratePrime {
	public static int get(int limit) {
		int num=0;
	    Random r = new Random();
	    num = r.nextInt(limit)+1;
	    while(!checkPrime(num)) {
	    	num = r.nextInt(limit)+1;
	    }
	    System.out.println("Prime number:"+num);
	    return num;
	}
	public static boolean checkPrime(int n) {
		if (n <= 3 || n % 2 == 0) 
            return n == 2 || n == 3;
        int divisor = 3;
        while ((divisor <= Math.sqrt(n)) && (n % divisor != 0)) 
            divisor += 2;
        return n % divisor != 0;
	}
}
