
public class Ex6_4 {
	public static void main(String[] args) {
		// MyMathŬ���� �ν��Ͻ� ����
		MyMath mm = new MyMath();
		
		// ��������(������)���� �ν��Ͻ� ����
		System.out.println(mm.add(5L, 3L));
		System.out.println(mm.subtract(5L, 3L));
		System.out.println(mm.multiply(5L, 3L));
		System.out.println(mm.divide(5L, 3L));	// long�� ���ڷ� ȣ�������� �ڵ�����ȯ
	}
}

class MyMath {
	// ���
	// ��ȯŸ�� long, �Ű����� 2�� longŸ������ ����
	long add(long a, long b) { return a+b; }
	long subtract(long a, long b) { return a-b; }
	long multiply(long a, long b) { return a*b; }
	double divide(double a, double b) { return a/b; }
}
