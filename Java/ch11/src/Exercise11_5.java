import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

//����ī�� Ŭ����
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
		// instanceof�� Ÿ��üũ�ϰ� ����ȯ�ؼ� ��
		boolean isValid = false;
		
		if(obj instanceof SutdaCard) {
			// ����ȯ
			SutdaCard s = (SutdaCard)obj;
			isValid = (num==s.num) && (isKwang==s.isKwang);
		}
		return isValid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num, isKwang);
	}
	
	
}


public class Exercise11_5 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		
		System.out.println(set);
		
	}

}
