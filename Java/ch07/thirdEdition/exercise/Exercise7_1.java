package thirdEdition.exercise;

import java.util.Arrays;

// ����Ŭ���� �����ϴ� Ŭ����
//class SutdaDeck {
//	// �Ӽ�
//	final int CARD_NUM = 20;
//	// ��ü�迭 ����
//	SutdaCard[] cards = new SutdaCard[CARD_NUM];
//	
//	// ������
//	SutdaDeck() {
//		// ��ü�迭 �� ��ҿ� ��ü ����!!!!!!!!!!!
//		// ���ٵ��� ����ī���� ����	
//		for(int i=0; i<cards.length; i++) {
//			// ���ڿ�, �����θ� ����
//			int num = i%10+1;
//			boolean isKwang = (i<10)&&(num==1 || num==3 || num==8);
//			// ī���� ����
//			cards[i] = new SutdaCard(num, isKwang);
//		}
//	}
//	
//}


// ����ī�� Ŭ����
//class SutdaCard {
//	// �Ӽ�
//	int num;
//	boolean isKwang;
//	
//	// ������
//	SutdaCard(int num, boolean isKwang) {
//		this.num = num;
//		this.isKwang = isKwang;
//	}
//	
//	SutdaCard() {
//		this(1, true);
//	}
//	
//	// ���
//	public String toString() {
//		return num + (isKwang ? "K" : "");
//	}
//	
//}
//
//public class Exercise7_1 {
//	public static void main(String[] args) {
//		SutdaDeck d = new SutdaDeck();
//		System.out.println(Arrays.toString(d.cards));
//	}
//
//}
