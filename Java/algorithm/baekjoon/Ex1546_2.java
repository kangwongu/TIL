package baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ex1546_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1. ���� �� ���� ���� �Է�
		// 2. ���� ���� �Է�
		double[] arr = new double[scanner.nextInt()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextDouble();
		}
		
		// 3. �ִ밪 ����
		// 4. ���� ���� /max*100���� ����
		Arrays.sort(arr);
		double hab = 0;
		for(int i=0; i<arr.length; i++) {
			hab += (arr[i] / arr[arr.length-1] * 100);
		}
		
		// 5. ���� ��� ���ϱ�
		System.out.println(hab/arr.length);
		
		
	}
}
