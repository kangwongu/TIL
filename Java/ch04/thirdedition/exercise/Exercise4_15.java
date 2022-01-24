package thirdedition.exercise;

import java.util.Scanner;

public class Exercise4_15 {
	public static void main(String[] args) {
		int number = 12321;
		int temp = number;
		
		int result = 0;
		
		// 수를 거꾸로 담기 (회문 만들기)
		while(temp != 0) {
			// 1. 10으로 나눈 나머지값을 도출해 1의 자리를 얻는다.
//			// 2. 얻은 1의 자리수의 10을 곱해줌
			result = result*10+temp%10;
			System.out.println("result:"+result);
			temp/=10;
		}
		
		// 회문 체크
		if(number == result) 
			System.out.println("회문이야ㅣ");
		else
			System.out.println("회문이 아니야");
	}
}
