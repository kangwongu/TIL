package thirdedition.exercise;

import java.util.Scanner;

public class Exercise4_14 {
	public static void main(String[] args) {
		int answer = (int)(Math.random()*100)+1;
		System.out.println(answer);
		int input = 0;	// ����ڰ� �Է��� ��
		int count = 0;	// ����õ��ߴ���
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1~100������ ���� �Է��ϼ���>>");
			input = scanner.nextInt();
			
			if(input > answer) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			} else if(input < answer) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			} else {
				System.out.println("����!");
				System.out.println("�õ�Ƚ���� "+count+"�� �Դϴ�.");
				break;
			}
			
		} while(true);
	}
}
