package thirdEdition.exercise;

import java.util.Arrays;

// ����Ŭ���� �����ϴ� Ŭ����
class SutdaDeck {
	// �Ӽ�
	final int CARD_NUM = 20;
	// ��ü�迭 ����
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	// ������
	SutdaDeck() {
		// ��ü�迭 �� ��ҿ� ��ü ����!!!!!!!!!!!
		// ���ٵ��� ����ī���� ����	
		for(int i=0; i<cards.length; i++) {
			// ���ڿ�, �����θ� ����
			int num = i%10+1;
			boolean isKwang = (i<10)&&(num==1 || num==3 || num==8);
			// ī���� ����
			cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	// ���
	// cards�迭�� ���´�
	void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int idx = (int)(Math.random()*cards.length);
			SutdaCard temp = cards[i];
			cards[i] = cards[idx];
			cards[idx] = temp; 
		}
	}
	
	// ������ ��ȣ�� cards�迭 ��Ҹ� ������
	SutdaCard pick(int index) {
		// ��ȿ�� �˻�
		if(index < 0 || index >= CARD_NUM)
			return null;
		
		return cards[index];
	}
	
	// ������ ��ȣ�� cards�迭 ��Ҹ� ������
	SutdaCard pick() {
		int idx = (int)(Math.random()*cards.length);
//		return pick(idx);	// ��ü������ �ڵ�
		return cards[idx];
	}
}


// ����ī�� Ŭ����
class SutdaCard {
	// �Ӽ�
	int num;
	boolean isKwang;
	
	// ������
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	SutdaCard() {
		this(1, true);
	}
	
	// ���
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
	
}

public class Exercise7_2 {
	public static void main(String[] args) {
		SutdaDeck d = new SutdaDeck();
		System.out.println(Arrays.toString(d.cards));
		System.out.println(d.pick(0));
		d.shuffle();
		System.out.println(Arrays.toString(d.cards));
		System.out.println(d.pick(0));
	}

}
