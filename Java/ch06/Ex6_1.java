
public class Ex6_1 {
	public static void main(String[] args) {
		// Tv�� �������� ����
		Tv t;
		// ��������  t�� Tv�ν��Ͻ��� �ּҰ� ����
		t = new Tv();
		
		// ��������(������) t�� Tv�ν��Ͻ� ���
		t.channel=11;
		t.channelUp();
		System.out.println(t.channel);
	}
}

class Tv {
	// �Ӽ� (����)
	String color;
	boolean power;
	int channel;
	
	// ��� (�޼ҵ�)
	void power() { power = !power;}
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}
