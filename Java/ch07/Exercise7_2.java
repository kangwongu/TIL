// 섯다덱 클래스
class SutdaDeck {
	// 속성
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	// 생성자
	SutdaDeck() {
		for(int i=0; i<cards.length; i++) {
			// 수 세팅
			int num = i%10+1;
			// 광 세팅
			boolean isKwang = (i < 10)&&(num==1||num==3||num==8);
			
			// 객체 배열에 인스턴스 생성해 추가해줌
			cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	// 기능
	// 카드를 섞는 메소드
	void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int idx = (int)(Math.random()*20);
			SutdaCard tmp = cards[i];
			cards[i] = cards[idx];
			cards[idx] = tmp;
		}
	}
	
	// 카드 배열에서 지정된 위치의 요소를 반환하는 메소드
	SutdaCard pick(int index) {
		// 매개변수가 있는 메소드는 항상 유효성 검사
		if(index < 0 || index >= CARD_NUM)
			return null;
		return cards[index];
	}
	
	// 카드 배열에서 임의의 위치의 요소를 반환하는 메소드
	SutdaCard pick() {
		int idx = (int)(Math.random()*20);
		return cards[idx];
	}
	
}

// 섯다카드 클래스
class SutdaCard {
	// 속성
	int num;
	boolean isKwang;
	
	// 생성자
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		// 광이면 K, 아니면 공백
		return num + (isKwang ? "K" : "");
	}
	
	// 기능

}


public class Exercise7_2 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i]+", ");
		}
		System.out.println();
		System.out.println(deck.pick(0));
		
	}

}
