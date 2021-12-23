package baekjoon;


public class Ex4673 {
	// �� �ڸ����� ���ϴ� �޼ҵ�
	public static int d(int n) {
		int dn = n;
		// �� �ڸ����� ����
		while(n!=0) {
			dn += n%10;	// ù°�ڸ��� +
			n/=10;
		}
		// �����ѹ��� ��ȯ
		return dn;
	}
	
	public static void main(String[] args) {
		// �����ѹ��� üũ�ϱ� ���� �迭
		boolean[] isSelfNumber = new boolean[10001];
		
		for(int i=1; i<isSelfNumber.length; i++) {
			int dn = d(i);	// �����ѹ��� ��ȯ
			
			// �����ѹ��� true�� üũ
			if(dn <= 10000)
				isSelfNumber[dn] = true;
		}
		
		// �����ѹ��� �ƴ� ���� ���
		for(int i=1; i<isSelfNumber.length; i++) {
			if(!isSelfNumber[i])
				System.out.println(i);
		}
		
	}
}
