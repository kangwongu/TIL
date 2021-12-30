package thirdEdition;

public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();
		Card c = d.pick(0);
		System.out.println(c);
		
		d.shuffle();
		c = d.pick(0);
		System.out.println(c);
	}
}

class Deck {
	final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];	// 포함
	
	// 생성자
	Deck() {
		// 카드 초기화
		int i=0;
		for(int k=Card.KIND_MAX; k>0; k--) {
			for(int n=0; n<Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	
	// 기능
	Card pick(int index) {
		return cardArr[index];
	}
	
	Card pick() {
		int idx = (int)(Math.random()*CARD_NUM);
		return cardArr[idx];
	}
	
	void shuffle() {
		// 섞기
		for(int i=0; i<cardArr.length; i++) {
			int idx = (int)(Math.random()*CARD_NUM);
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[idx];
			cardArr[idx] = tmp;
		}
	}
}

class Card {
	// 속성
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	int kind;
	int number;
	
	// 생성자
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	Card() {
		this(SPADE, 1);
	}
	
	// 기능
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		return "kind : " + kinds[this.kind]
					+ ", number : " + numbers.charAt(number);
	}
}
