//
//class Product {
//	int price;
//	int bonusPoint;
//	
//	Product(int price) {
//		this.price = price;
//		bonusPoint = (int)(price/10.0);
//	}
//}
//
//class Tv1 extends Product {
//	Tv1() { super(100); }
//	
//	public String toString() { return "Tv"; }
//}
//
//class Computer extends Product {
//	Computer() { super(200); }
//
//	public String toString() { return "Computer"; }
//}
//
//class Buyer {
//	int money = 1000;
//	int bonusPoint = 0;
//	
//	void buy(Product p) {
//		if(money < p.price) {
//			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
//			return;
//		}
//		money -= p.price;
//		bonusPoint += p.bonusPoint;
//		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
//	}
//}
//
//public class Ex7_8 {
//	public static void main(String[] args) {
//		Buyer b = new Buyer();
//		
//		b.buy(new Tv1());
//		b.buy(new Computer());
//		
//		System.out.println("���� ���� ���� " + b.money + "�����Դϴ�.");
//		System.out.println("���� ���ʽ������� " + b.bonusPoint + "���Դϴ�.");
//	}	
//
//}

// ���� Ŭ����
class Product {
	// �Ӽ�
	int price;
	int bonusPoint;
	
	// ������
	Product() {this(0);}

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}	
}

// �ڼ� Ŭ����
class Tv1 extends Product {
	Tv1() { super(100); }
	public String toString() { return "Tv"; }
}

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer"; }
}

// �̿��ϴ� Ŭ����
class Buyer {
	// �Ӽ�
	int money = 1000;
	int bonusPoint = 0;
	
	// ���
	// ���� �޼ҵ�, �Ű����� ������
	void buy(Product p) {
		// ��ȿ���˻�
		if(money < p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
}

class Ex7_8 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv1 tv = new Tv1();
		Computer c = new Computer();
		
		b.buy(tv);
		b.buy(c);
	}
}
