package thirdEdition.exercise;

import java.util.Arrays;

// ����Ŭ����
class Product {
	// �Ӽ�
	int price;
	
	// ������
	Product(int price) { this.price = price; }
}

// �ڼ�Ŭ����
class Tv extends Product {
	Tv() { super(100); }
}

class Computer extends Product {
	Computer() { super(200); }
}

class Audio extends Product {
	Audio() { super(50); }
}


class Buyer {
	// �Ӽ�
	int money = 1000;
	// �ϳ��� �迭�� ������ü�� �ٷ��
	Product[] list = new Product[3];	// ������ ����
	int i=0;
	
	
	// ���
	// ��ǰ�� �����Ѵ�
	// �Ű����� ������ -> ������ ����, Product, Product�ڼո��� �Ű������� ok
	void buy(Product p) {
		// �����ڰ� �������� ���ǰ����� ���ٸ� ����
		if(money < p.price) {
			System.out.println("�ܾ��� ������ ���� �Ұ�");
			return;
		}
		
		money -= p.price;	// ���������� ���ǰ� ����
		add(p);				// ��ٱ��Ͽ� ��´�, ��ü������ �ڵ�
	}
	
	// ��ٱ��Ͽ� ��� �޼ҵ�
	void add(Product p) {
		// ��ȿ�� �˻�
		if(i>=list.length) {
			// ���� ��ٱ��� 2�� �뷮�� ���ο� ��ٱ��� ���� 
			Product[] newList = new Product[list.length*2];
			// ���ο� ��ٱ��Ͽ� ���� ��ٱ��� ����
//			System.arraycopy(list, 0, newList, 0, list.length);
			newList = Arrays.copyOf(list, newList.length);
			// ���� ��ٱ��Ϸ� �ٲٱ�
			list = newList;
		}
		// ��ٱ��Ͽ� ��´�
		list[i++] = p;
		
	}
	
	// ��ٱ��� ��� ���, �� ���ź��, ���� ������ ���
	void summary() {
		int sum=0;	// �ѱ��ź��
		for(int i=0; i<list.length; i++) {
			sum += list[i].price;
		}
		System.out.println(Arrays.toString(list));
		System.out.println(sum);
		System.out.println(money);
	}
}

public class Exercise7_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}
