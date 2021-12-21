package baekjoon;

import java.util.Scanner;

public class Ex2577 {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int gob = a*b*c;
		
		int[] arr = new int[10];
		
		// 수를 하나씩 검사
		while(gob!=0) {
			arr[gob%10]++;	// 해당 1의 자리를 그 배열요소에 ++
			gob /= 10;
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}
