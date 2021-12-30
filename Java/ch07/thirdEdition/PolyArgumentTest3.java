package thirdEdition;

import java.util.ArrayList;

// ���� Ŭ����, ����κ��� �ۼ�
class Product3 {
	// �Ӽ�
	int price;
	int bonusPoint;
	
	// ������
	Product3(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
}

// �ڼ� Ŭ����
class Tv5 extends Product3 {
	Tv5() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer3 extends Product3 {
	Computer3() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}

// ����ϴ� Ŭ����
class Buyer3 {
	// �Ӽ�
	int money = 1000;
	int bonusPoint;
	// ��ٱ���, �ϳ��� �迭�� �������� ��ü �ٷ��
	ArrayList<Product3> list = new ArrayList<>();
	
	// ���
	void buy(Product3 p) {	// �Ű����� ������
		// ��ȿ�� �˻� �ʼ�!
		if(money<p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		list.add(p);
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
		for(int i=0; i<list.size(); i++) {
			// ������ ���
			Product3 p = list.get(i);
			sum += p.price;
			itemList += (i==0) ? ""+p : ", " +p;
		}
		
		
		System.out.println("�� �ݾ��� "+sum+"�Դϴ�.");
		System.out.println("������ ��ǰ�� "+itemList+"�Դϴ�.");
	}
	
}


public class PolyArgumentTest3 {
	public static void main(String[] args) {
		Buyer3 buyer = new Buyer3();
		
		// �����ڰ� Tv, Computer�� ����
		buyer.buy(new Tv5());
		buyer.buy(new Computer3());
		
		
		buyer.summary();
		// ������ ���� ���
		buyer.showInfo();
		
		
	}

}
