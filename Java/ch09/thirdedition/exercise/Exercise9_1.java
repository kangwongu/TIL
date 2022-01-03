package thirdedition.exercise;

public class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3,true);
		SutdaCard c2 = new SutdaCard(3,true);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.equals(c2));
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	SutdaCard() {
		this(1, true);
	}
	
	@Override
	public boolean equals(Object obj) {
		// instanceof�� ����ȯ �������� üũ
		if(obj instanceof SutdaCard) {
			// ����ȯ
			SutdaCard sc = (SutdaCard)obj;
			// ��
			return num==sc.num && isKwang==sc.isKwang;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}