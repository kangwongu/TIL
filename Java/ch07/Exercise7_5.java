class MyTv {
	// �Ӽ�
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;	// ���� ä���� ������ ����
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
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
		// ��ȿ���˻�
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL)
			return;
		prevChannel = this.channel;
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		// ��ȿ���˻�
		if(volume > MAX_VOLUME || volume < MIN_VOLUME)
			return;
		this.volume = volume;
	}
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
		
	}
	
}

public class Exercise7_5 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());

	}

}
