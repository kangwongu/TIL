package thirdEdition;

// ����Ŭ����
class Tv {
	// �Ӽ�
	boolean power;
	int channel;
	
	// ���
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// �ڼ�Ŭ����
class CaptionTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
}


public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 11;
		ctv.channelUp();
		ctv.displayCaption("�ȳ�");
		ctv.caption=true;
		ctv.displayCaption("�Ź�");
	
	}

}
