package thirdEdition;

// ���� Ŭ����, ����κ��� �ۼ�
class Product2 {
	// �Ӽ�
	int price;
	int bonusPoint;
	
	// ������
	Product2(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
}

// �ڼ� Ŭ����
class Tv4 extends Product {
	Tv4() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer2 extends Product {
	Computer2() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}

// ����ϴ� Ŭ����
class Buyer2 {
	// �Ӽ�
	int money = 1000;
	int bonusPoint;
	// ��ٱ���, �ϳ��� �迭�� �������� ��ü �ٷ��
	Product[] list = new Product[10];
	int i = 0;
	
	// ���
	void buy(Product p) {	// �Ű����� ������
		// ��ȿ�� �˻� �ʼ�!
		if(money<p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		list[i++] = p;
		System.out.println(p+"�� �����߽��ϴ�.");
	}

	void showInfo() {
		System.out.println("���� ���� "+money+"�Դϴ�.");
		System.out.println("���� ����Ʈ�� "+bonusPoint+"�Դϴ�.");
	}
	
	// ������ ������, ������ ����Ʈ ���
	void summary() {
		int sum=0;	// ������ ������ ����
		String itemList="";	// īƮ�� ����ִ� ��ǰ
		
		// for������ ����Ʈ ��ȸ
		for(int i=0; i<list.length; i++) {
			// ���� ���ϱ�
			if(list[i]==null) break;
			sum += list[i].price;
			itemList += list[i]+",";
		}
		
		System.out.println("�� �ݾ��� "+sum+"�Դϴ�.");
		System.out.println("������ ��ǰ�� "+itemList+"�Դϴ�.");
	}
	
}


public class PolyArgumentTest2 {
	public static void main(String[] args) {
		Buyer2 buyer = new Buyer2();
		
		// �����ڰ� Tv, Computer�� ����
		buyer.buy(new Tv4());
		buyer.buy(new Computer2());
		
		
		buyer.summary();
		// ������ ���� ���
		buyer.showInfo();
		
		
	}

}
