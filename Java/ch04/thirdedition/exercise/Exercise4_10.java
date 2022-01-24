package thirdedition.exercise;

public class Exercise4_10 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		// 12345 -> 1,2,3,4,5의 합을 구하라
		// /10씩 나눠서 1의 자리를 얻을 수 있음
		
		while(num>0) {
			sum += num%10;
			num/=10;
		}
		
		System.out.println(sum);
	}
}
