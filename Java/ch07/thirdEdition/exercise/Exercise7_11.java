package thirdEdition.exercise;

class MyTv2 {
	// �Ӽ�
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	private int prevChannel;	// ���� ä���� ���� ���� ����
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 200;
	final int MIN_CHANNEL = 1;
	
	public boolean isPowerOn() {
		return isPowerOn;
	}
	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		prevChannel = this.channel;	// ���� ä�ο� ����
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	// ���
	// ���� ä�η� �̵��ϴ� �޼ҵ�
	public void gotoPrevChannel() {
		setChannel(prevChannel);	// ��ü������ �ڵ�
	}
	
	
}

public class Exercise7_11 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		t.setChannel(100);
		System.out.println(t.getChannel());
		t.setChannel(11);
		System.out.println(t.getChannel());
		t.gotoPrevChannel();
		System.out.println(t.getChannel());
		t.gotoPrevChannel();
		System.out.println(t.getChannel());
		
	}
}
