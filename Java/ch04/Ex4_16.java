import java.util.Scanner;

public class Ex4_16 {

	public static void main(String[] args) {
		// 변수
		// 합을 담을 변수, 카운트할 변수
		int sum = 0, i = 0;
		
		// 무한루프 돌며 i를 1씩 증가
		// sum += i, sum이 100이상 되면 break
		while(true) {
			if(sum > 100) {
				break;
			}
			sum += ++i;
			System.out.printf("i = %d, sum = %d\n", i, sum);
		}
		System.out.println();
		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
	}
}