
public class Ex6_3 {
	public static void main(String[] args) {
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		// CardŬ������ �ν��Ͻ�1�� ����
		Card c1 = new Card();
		// �ν��Ͻ�1�� ���� �Ӽ��� �ʱ�ȭ
		c1.kind = "Spade";
		c1.number = 7;
		// CardŬ������ �ν��Ͻ�2�� ����
		Card c2 = new Card();
		// �ν��Ͻ�2�� ���� �Ӽ��� �ʱ�ȭ
		c2.kind = "Heart";
		c2.number = 2;
		
		
		System.out.println("c1�� " + c1.kind + ", " + c1.number
				+ "�̸�, ũ��� (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2�� " + c2.kind + ", " + c2.number
				+ "�̸�, ũ��� (" + c2.width + ", " + c2.height + ")");
		
		// ���� �Ӽ��� ����
		Card.height = 50;
		Card.width = 125;
		
		
		System.out.println("c1�� " + c1.kind + ", " + c1.number
				+ "�̸�, ũ��� (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2�� " + c2.kind + ", " + c2.number
				+ "�̸�, ũ��� (" + c2.width + ", " + c2.height + ")");
		
	}
}


// CardŬ����
class Card {
	// �Ӽ�
	// ���� �Ӽ� (��, ����)
	static int height = 250;
	static int width = 100;
	
	// ���� �Ӽ� (����, ����)
	String kind;
	int number;
}
