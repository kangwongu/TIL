package thirdedition.exercise;

import java.util.Scanner;

public class Exercise4_15 {
	public static void main(String[] args) {
		int number = 12321;
		int temp = number;
		
		int result = 0;
		
		// ���� �Ųٷ� ��� (ȸ�� �����)
		while(temp != 0) {
			// 1. 10���� ���� ���������� ������ 1�� �ڸ��� ��´�.
//			// 2. ���� 1�� �ڸ����� 10�� ������
			result = result*10+temp%10;
			System.out.println("result:"+result);
			temp/=10;
		}
		
		// ȸ�� üũ
		if(number == result) 
			System.out.println("ȸ���̾ߤ�");
		else
			System.out.println("ȸ���� �ƴϾ�");
	}
}
