package thirdEdition.exercise;

class MyTv2 {
	// 속성
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	private int prevChannel;	// 이전 채널의 값을 담을 변수
	
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
		prevChannel = this.channel;	// 이전 채널에 저장
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	// 기능
	// 이전 채널로 이동하는 메소드
	public void gotoPrevChannel() {
		setChannel(prevChannel);	// 객체지향적 코드
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
