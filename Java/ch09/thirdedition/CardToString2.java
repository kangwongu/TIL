package thirdedition;

public class CardToString2 {
	public static void main(String[] args) throws Exception {
		Card c1 = new Card();
		Card c2 = new Card("HEART", 7);
		// Class��ü �̿��� ���� ����
		Card c3 = Card.class.newInstance();
		Class c4 = c2.getClass();
			
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4.toGenericString());
		System.out.println(c4.toString());
	}

}

class Card {
	String kind;
	int number;
	
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	Card() {
		this("SPADE", 1);
	}
	
	// �������̵�
	public String toString() {
		return kind+", "+number;
	}
}
