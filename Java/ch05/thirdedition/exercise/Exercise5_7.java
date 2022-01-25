package thirdedition.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5_7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 돈 입력
		int money = scanner.nextInt();
		System.out.println("money:"+money);
		
		int[] coinUnit = {500,100,50,10};	// 동전 단위
		int[] coin = {5,5,5,5};				// 동전 개수
		
		//
		for(int i=0; i<coinUnit.length; i++) {
			int coinNum = 0;	// 동전의 개수
			
			// 1. 금액을 동전단위로 나눠서 동전의 개수를 구한다
			coinNum = money / coinUnit[i];
			
			// 2. 배열 coin에서 coinNum만큼 동전을 뺀다
			if(coinNum <= coin[i]) {
				coin[i] -= coinNum;
			} else {
				coin[i] = 0;
				coinNum = 5;
			}
			
			// 3. 금액에서 동전의 개수와 동전단위를 곱한 것을 뺀다
			money -= coinNum * coinUnit[i];
			
			System.out.println(coinUnit[i]+"원:"+coinNum);
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족해요");
			System.exit(0);
		}
		
		System.out.println("남은 동전 개수");
		for(int j=0; j<coinUnit.length; j++) {
			System.out.println(coinUnit[j]+"원:"+coin[j]);
		}
		
	}
}
