package thirdEdition.exercise;

import java.util.Arrays;

// 섯다클래스 포함하는 클래스
//class SutdaDeck {
//	// 속성
//	final int CARD_NUM = 20;
//	// 객체배열 생성
//	SutdaCard[] cards = new SutdaCard[CARD_NUM];
//	
//	// 생성자
//	SutdaDeck() {
//		// 객체배열 각 요소에 객체 생성!!!!!!!!!!!
//		// 섯다덱에 섯다카드요소 생성	
//		for(int i=0; i<cards.length; i++) {
//			// 숫자와, 광여부를 구함
//			int num = i%10+1;
//			boolean isKwang = (i<10)&&(num==1 || num==3 || num==8);
//			// 카드요소 생성
//			cards[i] = new SutdaCard(num, isKwang);
//		}
//	}
//	
//}


// 섯다카드 클래스
//class SutdaCard {
//	// 속성
//	int num;
//	boolean isKwang;
//	
//	// 생성자
//	SutdaCard(int num, boolean isKwang) {
//		this.num = num;
//		this.isKwang = isKwang;
//	}
//	
//	SutdaCard() {
//		this(1, true);
//	}
//	
//	// 기능
//	public String toString() {
//		return num + (isKwang ? "K" : "");
//	}
//	
//}
//
//public class Exercise7_1 {
//	public static void main(String[] args) {
//		SutdaDeck d = new SutdaDeck();
//		System.out.println(Arrays.toString(d.cards));
//	}
//
//}
