package thirdEdition;

// ���� Ŭ����, ����κ��� �ۼ�
class Product {
	// �Ӽ�
	int price;
	int bonusPoint;
	
	// ������
	Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
}

// �ڼ� Ŭ����
class Tv3 extends Product {
	Tv3() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}

// ����ϴ� Ŭ����
class Buyer {
	// �Ӽ�
	int money = 1000;
	int bonusPoint;
	
	// ���
	void buy(Product p) {	// �Ű����� ������
		// ��ȿ�� �˻� �ʼ�!
		if(money<p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"�� �����߽��ϴ�.");
	}

	void showInfo() {
		System.out.println("���� ���� "+money+"�Դϴ�.");
		System.out.println("���� ����Ʈ�� "+bonusPoint+"�Դϴ�.");
	}
	
	
}


public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		
		// �����ڰ� Tv, Computer�� ����
		buyer.buy(new Tv3());
		buyer.buy(new Computer());
		
		// ������ ���� ���
		buyer.showInfo();
	}

}
