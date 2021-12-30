
public class Ex6_3 {
	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		// Card클래스의 인스턴스1을 생성
		Card c1 = new Card();
		// 인스턴스1의 개별 속성을 초기화
		c1.kind = "Spade";
		c1.number = 7;
		// Card클래스의 인스턴스2를 생성
		Card c2 = new Card();
		// 인스턴스2의 개별 속성을 초기화
		c2.kind = "Heart";
		c2.number = 2;
		
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number
				+ "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number
				+ "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		
		// 공통 속성을 변경
		Card.height = 50;
		Card.width = 125;
		
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number
				+ "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number
				+ "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		
	}
}


// Card클래스
class Card {
	// 속성
	// 공통 속성 (폭, 높이)
	static int height = 250;
	static int width = 100;
	
	// 개별 속성 (무늬, 숫자)
	String kind;
	int number;
}
