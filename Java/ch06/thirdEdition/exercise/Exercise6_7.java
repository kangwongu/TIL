package thirdEdition.exercise;

public class Exercise6_7 {
	public static void main(String[] args) {
		// ��ü ������
		MyPoint m = new MyPoint(1,1);
		
		System.out.println(m.getDistance(2, 2));
	}
}

class MyPoint {
	// �Ӽ�
	int x;
	int y;
	
	// ������
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// ���
	// ������ �Ÿ��� ����ϴ� ����
	double getDistance(int x1, int y1) {
		return Math.sqrt(Math.abs(((x-x1)*(x-x1))+((y-y1)*(y-y1)))); 
	}
	
}
