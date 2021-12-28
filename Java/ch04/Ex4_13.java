import java.util.Scanner;

public class Ex4_13 {

	public static void main(String[] args) {
		
		// 변수
		int i=0;
		int sum=0;
		// 합이 100을 넘길 때 까지 합함
		while(sum<=100) {
			System.out.println(i +", " + sum);
			sum += ++i;
		}
	
	}
}