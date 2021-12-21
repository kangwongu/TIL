package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Ex1546 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1. 시험 볼 과목 개수 입력
		int N = scanner.nextInt();
		
		// 2. 시험 점수 입력
		double[] arr = new double[N];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextDouble();
		}
		
		// 3. 최대값 도출
		double max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		// 4. 시험 점수 /max*100으로 변경
		double hab = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i]/max*100; 
			hab += arr[i];
		}
		
		// 5. 최종 평균 구하기
		double average = hab/arr.length;
		System.out.println(average);
		
		
	}
}
