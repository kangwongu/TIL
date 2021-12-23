package baekjoon;


public class Ex15596 {
	public static long sum(int[] a) {
		// 배열의 합을 구해서 반환
		long total = 0;
		for(int i=0; i<a.length; i++) {
			total += a[i];
		}
		return total;
	}
	
	public static void main(String[] args) {
		
	}
}
