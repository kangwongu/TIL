package thirdEdition;

// Tv2 Ŭ����
class Tv2 {
	// �Ӽ�
	String color;
	int channel;
	boolean power;
	
	// ���
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest2 {
	public static void main(String[] args) {
		// ��ü ����
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		// ��ü ���
		t1.channel = 15;
		t1.channelDown();
		System.out.println(t1.channel);
		System.out.println(t2.channel);
		
		// t2�� t1 ���������� ���� ����(�ּ�)
		t2 = t1;
		
		System.out.println(t1.channel);
		System.out.println(t2.channel);
	}

}
