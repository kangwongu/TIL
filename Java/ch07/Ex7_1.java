
// TvŬ����
class Tv {
	// �Ӽ�
	// �Ŀ�, ä��
	boolean power;
	int channel;
	// ���
	// �Ŀ��¿���, ä��_1, ä��-1
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }

}

// TvŬ������ ����� �޴� SmartTvŬ����
class SmartTv extends Tv {
	// �Ӽ�
	// + �ڸ�on/off
	boolean caption;
	// ���
	// + �ڸ�on�̸� �ڸ������ֱ�
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
}

public class Ex7_1 {
	public static void main(String[] args) {
		// TvŬ���� ��ӹ��� SmartTvŬ���� �ν��Ͻ� ����
		SmartTv stv = new SmartTv();
		// TvŬ������ ��� ��밡��
		stv.channel = 224;
		stv.channelUp();
		System.out.println(stv.channel);
		// SmartTvŬ������ �ڸ����
		stv.displayCaption("Hi");
		stv.caption = true;
		stv.displayCaption("Hi");
		
	}

}
