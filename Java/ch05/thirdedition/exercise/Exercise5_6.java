package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_6 {
	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money="+money);
		
		for(int i=0; i<coinUnit.length; i++) {
			// 몇 개의 동전이 나오는지?
			int coin = money/coinUnit[i];
			// 남은 돈
			money %= coinUnit[i];
			System.out.println(coinUnit[i]+"원 : " + coin);
		}
	}
}
