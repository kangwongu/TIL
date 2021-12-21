package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Ex1546 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1. ���� �� ���� ���� �Է�
		int N = scanner.nextInt();
		
		// 2. ���� ���� �Է�
		double[] arr = new double[N];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextDouble();
		}
		
		// 3. �ִ밪 ����
		double max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		// 4. ���� ���� /max*100���� ����
		double hab = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i]/max*100; 
			hab += arr[i];
		}
		
		// 5. ���� ��� ���ϱ�
		double average = hab/arr.length;
		System.out.println(average);
		
		
	}
}
