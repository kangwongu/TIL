package baekjoon;

import java.util.Scanner;

public class Ex2562 {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;	// 최대값
		int idx = 0;	// 위치
		
		// 배열 길이만큼 정수를 입력받아 배열 요소에 저장
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// 최대 최소값 구하기
		max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
