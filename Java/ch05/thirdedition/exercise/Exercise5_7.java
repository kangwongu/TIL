package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_7 {
	public static void main(String[] args) {
		// ��ȿ�� �˻�
		if(args.length!=1) {
			System.out.println("����");
			System.exit(0);
		}
		
		int money = Integer.parseInt(args[0]);
		System.out.println("money="+money);
		
		int[] coinUnit = {500, 100, 50, 10};
		int[] coin = {5,5,5,5};
		
		
		for(int i=0; i<coinUnit.length; i++) {
			// �� ���� ������ ��������?
			int coinNum = money/coinUnit[i];
			
			if(coin[i]<coinNum) {
				coinNum = coin[i];
				coin[i] = 0;
			} else {
				coin[i]-=coinNum;
			}
			
			money -= coinNum*coinUnit[i];
			System.out.println(coinUnit[i]+"��: "+coinNum);
		}
	}
}
