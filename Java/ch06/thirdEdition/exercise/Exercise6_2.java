package thirdEdition.exercise;

public class Exercise6_2 {
	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}

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
	String info() {
		
		return num + (isKwang ? "K" : "");
	}

}