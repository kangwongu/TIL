package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Ex3052_2 {
	public static void main(String[] args) {
		
		// 나머지를 담을 배열
		boolean[] arr = new boolean[42];
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		// 입력%42한 나머지의 값을 true로 바꿈
		for(int i=0; i<10; i++) {
			arr[scanner.nextInt()%42] = true;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==true)
				count++;
		}
		
		System.out.println(count);
		
	}
}
