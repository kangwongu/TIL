class Card {
	String kind;
	int number;
	
	Card() {
		this("SPADE", 1);
	}
	
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	// toString()오버라이딩으로 객체의 내용을 문자열로 표시가능
	// 오버라이딩 안하면 객체의 정보가 출력됨
	public String toString() {
		return kind+","+number;
	}
}


public class Ex9_4 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.toString());
		System.out.println(c2);
	}

}

