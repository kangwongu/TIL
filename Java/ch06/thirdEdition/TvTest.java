package thirdEdition;

// Tv Ŭ����
class Tv {
	// �Ӽ�
	String color;
	int channel;
	boolean power;
	
	// ���
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest {
	public static void main(String[] args) {
		// ��ü ����
		Tv t = new Tv();
		
		// ��ü ���
		t.channel = 15;
		t.channelDown();
		System.out.println(t.channel);
	}

}
