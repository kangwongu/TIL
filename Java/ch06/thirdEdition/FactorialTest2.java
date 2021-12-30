package thirdEdition;

public class FactorialTest2 {
	public static void main(String[] args) {
		// 1~21���� ���丮�� ���ϱ�
		int n = 21;
		long result=0;
		for(int i=1; i<=n; i++) {
			result = factorial(i);
			
			// ���丮�� �޼ҵ��� ��ȿ�� �˻翡 �ɷ�����
			if(result==-1) {
				System.out.println("��ȿ���� ���� ��"+result);
				break;
			}
			
			System.out.printf("%2d!=%20d\n", i, result);
			
		}
	}
	
	// ���丮�� �޼ҵ�
	static int factorial(int n) {
		// ��ȿ�� �˻�
		if(n<=0 || n>20) return -1;
		int result = 0;
		
		if(n<=1) return 1;
			result = n * factorial(n-1);
		
		return result;
	}

}
