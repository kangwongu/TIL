package thirdedition.exercise;

import java.util.Scanner;

public class Exercise4_15 {
	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0;
		
		while(tmp != 0) {
			// tmp���� �Ųٷ� result�� ��´�
			result = result*10 + tmp%10;
			tmp/=10;
			
			System.out.println(result);
		}
		
		if(number == result)
			System.out.println(number+"�� ȸ���� �Դϴ�");
		else
			System.out.println(number+"�� ȸ������ �ƴմϴ�");
	}
}