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
	
	// toString()�������̵����� ��ü�� ������ ���ڿ��� ǥ�ð���
	// �������̵� ���ϸ� ��ü�� ������ ��µ�
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

