package baekjoon;

import java.util.Scanner;

public class Ex10818 {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int max = 0;
		int min = 0;
		
		// 길이만큼의 배열 생성
		int[] arr = new int[length];
		// 배열 길이만큼 정수를 입력받아 배열 요소에 저장
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// 최대 최소값 구하기
		max = arr[0];
		min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
			else if(arr[i] < min)
				min = arr[i];
		}
		
		System.out.println(min+" "+max);
	}
}
