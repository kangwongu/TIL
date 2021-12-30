package thirdEdition;

public class PowerTest {
	public static void main(String[] args) {
		int x = 2;
		int n = 2;
		long result = 0;
		
		// 2*«— ∞Õ¿ª √—«’
		for(int i=1; i<=n; i++) {
			result += power(x,i);
		}
		System.out.println(result);
	}
	
	// 2*
	static long power(int x, int n) {
		if(n==1) return x;
		return x * power(x, n-1);
	}

}
