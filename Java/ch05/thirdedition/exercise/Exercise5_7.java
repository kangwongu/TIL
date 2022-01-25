package thirdedition.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5_7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// �� �Է�
		int money = scanner.nextInt();
		System.out.println("money:"+money);
		
		int[] coinUnit = {500,100,50,10};	// ���� ����
		int[] coin = {5,5,5,5};				// ���� ����
		
		//
		for(int i=0; i<coinUnit.length; i++) {
			int coinNum = 0;	// ������ ����
			
			// 1. �ݾ��� ���������� ������ ������ ������ ���Ѵ�
			coinNum = money / coinUnit[i];
			
			// 2. �迭 coin���� coinNum��ŭ ������ ����
			if(coinNum <= coin[i]) {
				coin[i] -= coinNum;
			} else {
				coin[i] = 0;
				coinNum = 5;
			}
			
			// 3. �ݾ׿��� ������ ������ ���������� ���� ���� ����
			money -= coinNum * coinUnit[i];
			
			System.out.println(coinUnit[i]+"��:"+coinNum);
		}
		
		if(money > 0) {
			System.out.println("�Ž������� �����ؿ�");
			System.exit(0);
		}
		
		System.out.println("���� ���� ����");
		for(int j=0; j<coinUnit.length; j++) {
			System.out.println(coinUnit[j]+"��:"+coin[j]);
		}
		
	}
}
