package baekjoon;

import java.util.Scanner;

public class Ex8958 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// �Է�, �� ���� ox����
		String[] arr = new String[scanner.nextInt()];
		
		// ox���� �Է�
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.next();
		}
		
		// �� ox������ ���� ����
		for(int i=0; i<arr.length; i++) {
			int score=0;
			int sum=0;
			
			for(int j=0; j<arr[i].length(); j++) {
				// O�̸�
				if(arr[i].charAt(j)=='O') {
					score++;
				// X��
				} else {
					score=0;
				}
				// ���� ���ϱ�
				sum += score;	
			}
			System.out.println(sum);
		}
		
	}
}
