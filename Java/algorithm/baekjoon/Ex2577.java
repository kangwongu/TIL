package baekjoon;

import java.util.Scanner;

public class Ex2577 {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int gob = a*b*c;
		
		int[] arr = new int[10];
		
		// ���� �ϳ��� �˻�
		while(gob!=0) {
			arr[gob%10]++;	// �ش� 1�� �ڸ��� �� �迭��ҿ� ++
			gob /= 10;
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}
