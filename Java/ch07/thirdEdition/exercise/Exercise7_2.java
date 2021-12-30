package thirdEdition.exercise;

import java.util.Arrays;

// 섯다클래스 포함하는 클래스
class SutdaDeck {
	// 속성
	final int CARD_NUM = 20;
	// 객체배열 생성
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	// 생성자
	SutdaDeck() {
		// 객체배열 각 요소에 객체 생성!!!!!!!!!!!
		// 섯다덱에 섯다카드요소 생성	
		for(int i=0; i<cards.length; i++) {
			// 숫자와, 광여부를 구함
			int num = i%10+1;
			boolean isKwang = (i<10)&&(num==1 || num==3 || num==8);
			// 카드요소 생성
			cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	// 기능
	// cards배열을 섞는다
	void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int idx = (int)(Math.random()*cards.length);
			SutdaCard temp = cards[i];
			cards[i] = cards[idx];
			cards[idx] = temp; 
		}
	}
	
	// 지정한 번호의 cards배열 요소를 가져옮
	SutdaCard pick(int index) {
		// 유효성 검사
		if(index < 0 || index >= CARD_NUM)
			return null;
		
		return cards[index];
	}
	
	// 임의의 번호의 cards배열 요소를 가져옴
	SutdaCard pick() {
		int idx = (int)(Math.random()*cards.length);
//		return pick(idx);	// 객체지향적 코드
		return cards[idx];
	}
}


// 섯다카드 클래스
class SutdaCard {
	// 속성
	int num;
	boolean isKwang;
	
	// 생성자
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	SutdaCard() {
		this(1, true);
	}
	
	// 기능
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
	
}

public class Exercise7_2 {
	public static void main(String[] args) {
		SutdaDeck d = new SutdaDeck();
		System.out.println(Arrays.toString(d.cards));
		System.out.println(d.pick(0));
		d.shuffle();
		System.out.println(Arrays.toString(d.cards));
		System.out.println(d.pick(0));
	}

}
