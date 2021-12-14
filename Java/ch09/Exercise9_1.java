// ����ī�� Ŭ����
class SutdaCard {
	// �Ӽ�
	int num;
	boolean isKwang;
	
	// ������
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	// ���
	public String toString() {
		// ���̸� K, �ƴϸ� ����
		return num + (isKwang ? "K" : "");
	}

	// num, isKwang�� ��
	@Override
	public boolean equals(Object obj) {
		// instanceof�����ڷ� Ÿ�� �˻� ��, ��
		if(obj instanceof SutdaCard) {
			SutdaCard s = (SutdaCard)obj;
			if(num==s.num && isKwang==s.isKwang) 
				return true;
		}
		
		return false;
	
	}
}


public class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.equals(c2));
	}

}
