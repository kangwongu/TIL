package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Ex3052_2 {
	public static void main(String[] args) {
		
		// �������� ���� �迭
		boolean[] arr = new boolean[42];
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		// �Է�%42�� �������� ���� true�� �ٲ�
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
